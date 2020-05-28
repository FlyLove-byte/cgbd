package com.edu.cgbd.utils;

import com.edu.cgbd.pojo.MarkdownData;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpHost;
import org.elasticsearch.action.DocWriteResponse;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.fieldcaps.FieldCapabilities;
import org.elasticsearch.action.fieldcaps.FieldCapabilitiesRequest;
import org.elasticsearch.action.fieldcaps.FieldCapabilitiesResponse;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.search.ShardSearchFailure;
import org.elasticsearch.action.support.IndicesOptions;
import org.elasticsearch.action.support.replication.ReplicationResponse;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.Strings;
import org.elasticsearch.common.text.Text;
import org.elasticsearch.common.unit.Fuzziness;
import org.elasticsearch.common.unit.TimeValue;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.query.MatchQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.rest.RestStatus;
import org.elasticsearch.script.Script;
import org.elasticsearch.script.ScriptType;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.aggregations.AggregationBuilders;
import org.elasticsearch.search.aggregations.Aggregations;
import org.elasticsearch.search.aggregations.bucket.terms.Terms;
import org.elasticsearch.search.aggregations.bucket.terms.TermsAggregationBuilder;
import org.elasticsearch.search.aggregations.metrics.Avg;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.fetch.subphase.FetchSourceContext;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightField;
import org.elasticsearch.search.sort.FieldSortBuilder;
import org.elasticsearch.search.sort.ScoreSortBuilder;
import org.elasticsearch.search.sort.SortOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.*;
import java.util.concurrent.TimeUnit;

import static java.util.Collections.singletonMap;

@Slf4j
@Component
public class EsUtil {

    /*RestHighLevelClient client = new RestHighLevelClient(
            RestClient.builder(
                    new HttpHost("192.168.10.140", 9200, "http")//此处写你自己的ip,如果是单机版本,删掉其他两个就好了
                 ));*/

    @Qualifier("getRHLClient")
    @Autowired
    private RestHighLevelClient client;

/*@Autowired
private MarkdownData markdownData;*/

    /**
     * 创建索引
     *
     * @throws IOException
     */
    public void creatIndex(MarkdownData markdownData) throws IOException {

        Map<String, Object> map = BeanAndMapChange.bean2Map(markdownData);
        IndexRequest indexRequest = new IndexRequest(markdownData.getTag())
                .id(FormatUtil.getUUID()).source(map);

        //同步执行
        //当以下列方式执行索引请求时，客户端在继续执行代码之前等待返回索引响应:
        IndexResponse indexResponse = client.index(indexRequest, RequestOptions.DEFAULT);
        System.out.println(indexResponse);

        String index = indexResponse.getIndex();
        String id = indexResponse.getId();

        if (indexResponse.getResult() == DocWriteResponse.Result.CREATED) {
            //处理(如果需要)第一次创建文档的情况

        } else if (indexResponse.getResult() == DocWriteResponse.Result.UPDATED) {
            //处理(如果需要)将文档重写为已经存在的情况

        }
        ReplicationResponse.ShardInfo shardInfo = indexResponse.getShardInfo();
        if (shardInfo.getTotal() != shardInfo.getSuccessful()) {
            //处理成功碎片的数量少于总碎片的情况

        }
        if (shardInfo.getFailed() > 0) {
            for (ReplicationResponse.ShardInfo.Failure failure :
                    shardInfo.getFailures()) {
                String reason = failure.reason();
                //处理潜在的故障
            }
        }
    }

    /**
     * 获取文档中的数据
     */
    public MarkdownData getApi(MarkdownData markdownData) throws IOException {

        //GetRequest()方法第一个参数是索引的名字,第二个参数是文档的id
        GetRequest getRequest = new GetRequest(markdownData.getTag(), markdownData.getTag() + "_" + markdownData.getPublishTime());

        //查询特定字段,包含和不包含的字段
        String[] includes = new String[]{"*"};//查询的字段
        String[] excludes = new String[]{};//不查询的字段
        FetchSourceContext fetchSourceContext =
                new FetchSourceContext(true, includes, excludes);
        getRequest.fetchSourceContext(fetchSourceContext);


        //为特定的存储字段配置检索(要求字段在映射中单独存储)
        getRequest.storedFields("message");
        GetResponse getResponse = client.get(getRequest, RequestOptions.DEFAULT);
        log.info(getResponse.toString());
        /*System.out.println(getResponse);*/
        Map<String, Object> map = getResponse.getSource();
        MarkdownData re = (MarkdownData) BeanAndMapChange.map2Bean(map, MarkdownData.class);

        if (getResponse.isExists()) {
            return re;
        } else {
            return null;
            // 处理没有找到文档的场景。注意，虽然返回的响应有404状态代码，但是返回的是有效的GetResponse，
            // 而不是抛出异常。这样的响应不包含任何源文档，并且它的isExists方法返回     }

        }
    }

    public void deleteApi() throws IOException {

        //索引   以及id
        DeleteRequest request = new DeleteRequest("posts", "1");
        DeleteResponse deleteResponse = client.delete(request, RequestOptions.DEFAULT);

        //异步删除
        //client.deleteAsync(request, RequestOptions.DEFAULT, listener);

        String index = deleteResponse.getIndex();
        String id = deleteResponse.getId();
        long version = deleteResponse.getVersion();
        ReplicationResponse.ShardInfo shardInfo = deleteResponse.getShardInfo();
        if (shardInfo.getTotal() != shardInfo.getSuccessful()) {

        }
        if (shardInfo.getFailed() > 0) {
            for (ReplicationResponse.ShardInfo.Failure failure :
                    shardInfo.getFailures()) {
                String reason = failure.reason();
            }
        }
    }

    /**
     * 更新
     *
     * @throws IOException
     */
    public void updateApi() throws IOException {

        UpdateRequest request = new UpdateRequest("posts", "1");

        Map<String, Object> parameters = singletonMap("count", 4);

        Script inline = new Script(ScriptType.INLINE, "painless",
                "ctx._source.field += params.count", parameters);
        request.script(inline);

        //更新特定字段
        String[] includes = new String[]{"updated", "r*"};
        String[] excludes = Strings.EMPTY_ARRAY;
        request.fetchSource(
                new FetchSourceContext(true, includes, excludes));

        UpdateResponse updateResponse = client.update(
                request, RequestOptions.DEFAULT);

    }

    /**
     * 批量添加  删除
     */
    public void bulkRequest() throws IOException {
        //添加
        BulkRequest request = new BulkRequest();
        request.add(new IndexRequest("posts").id("5")
                .source(XContentType.JSON, "user", "赵琦水岸城1", "name", "赵琦水岸城1"));
        request.add(new IndexRequest("posts").id("7")
                .source(XContentType.JSON, "user", "张三红包2", "name", "马六红包2"));
        request.add(new IndexRequest("posts").id("8")
                .source(XContentType.JSON, "user", "王五红包3", "name", "王五红包3"));
        request.add(new IndexRequest("posts").id("9")
                .source(XContentType.JSON, "user", "王五", "name", "zhangsan红包4"));
        request.add(new IndexRequest("posts").id("10")
                .source(XContentType.JSON, "user", "李四红包5", "name", "李四红包5"));
        request.add(new IndexRequest("posts").id("6")
                .source(XContentType.JSON, "user", "张三红包6", "name", "张三红包6"));
//
//        删除
//        BulkRequest request1 = new BulkRequest();
//        request1.add(new DeleteRequest("posts", "3"));
//        request1.add(new UpdateRequest("posts", "2")
//                .doc(XContentType.JSON,"other", "test"));
//        request1.add(new IndexRequest("posts").id("4")
//                .source(XContentType.JSON,"field", "baz"));

        BulkResponse bulkResponse = client.bulk(request, RequestOptions.DEFAULT);
    }

    /**
     * SearchRequest用于与搜索文档、聚合、建议有关的任何操作，还提供了请求突出显示结果文档的方法。
     */
    public void SearchRequest() throws IOException {

        //创建SeachRequest。如果没有参数，则运行所有索引。
       /* SearchRequest searchRequest = new SearchRequest();

        //大多数搜索参数都添加到SearchSourceBuilder中。它为进入搜索请求体的所有内容提供setter。
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        //向SearchSourceBuilder添加一个match_all查询。
        searchSourceBuilder.query(QueryBuilders.matchAllQuery());
        searchRequest.source(searchSourceBuilder);
        */

        //查询具体得到索引下的数据
        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
        //设置查询。可以是任何类型
        /*sourceBuilder.query(QueryBuilders.termQuery("tag", "es"));*/
        sourceBuilder.query(QueryBuilders.matchAllQuery());

        //分页
        /*sourceBuilder.from(0);
        sourceBuilder.size(5);*/

        //设置一个可选的超时，控制允许搜索花费的时间。
        sourceBuilder.timeout(new TimeValue(60, TimeUnit.SECONDS));
        SearchRequest searchRequest = new SearchRequest();
        /* searchRequest.indices("es");*/
        searchRequest.source(sourceBuilder);
        SearchResponse search = client.search(searchRequest, RequestOptions.DEFAULT);
        //getProfileResults
        System.out.println(search);
        System.out.println(search.getProfileResults().get("tag"));


    }

    /**
     * 模糊查询
     *
     * @throws IOException
     */
    public void matchQueryBuilder() throws IOException {

        //QueryBuilder matchQueryBuilder = QueryBuilders.termQuery("user", "3").//也是模糊查询,但对中文不兼容
        // QueryBuilder matchQueryBuilder = QueryBuilders.matchQuery("user", "王五").//模糊查询
//                .fuzziness(Fuzziness.AUTO)
//                .prefixLength(3)
//                .maxExpansions(10);*/

        //模糊查询
        MatchQueryBuilder matchQueryBuilder = new MatchQueryBuilder("user.keyword", "李四");//加上.keyword就是精确查找
        matchQueryBuilder.fuzziness(Fuzziness.AUTO);
        matchQueryBuilder.prefixLength(0);// 在匹配查询上设置前缀长度选项
        matchQueryBuilder.maxExpansions(1);// 设置最大扩展选项以控制查询的模糊过程

        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        searchSourceBuilder.query(matchQueryBuilder);

        //排序
        //Sort descending by _score (the default)
        searchSourceBuilder.sort(new ScoreSortBuilder().order(SortOrder.DESC));//
        //Also sort ascending by _id field
        searchSourceBuilder.sort(new FieldSortBuilder("_id").order(SortOrder.ASC));


        //查询指定字段   不查询指定字段
        //该方法还接受一个由一个或多个通配符模式组成的数组，以控制以更细粒度的方式包含或排除哪些字段:
//        searchSourceBuilder.fetchSource(false);
//        String[] includeFields = new String[]{"name"};
//        String[] excludeFields = Strings.EMPTY_ARRAY;
//        searchSourceBuilder.fetchSource(includeFields, excludeFields);


        SearchRequest searchRequest = new SearchRequest();
        searchRequest.indices("posts");
        searchRequest.source(searchSourceBuilder);
        SearchResponse search = client.search(searchRequest, RequestOptions.DEFAULT);

        System.out.println(search);

    }

    /**
     * 聚合查询
     * 通过首先创建适当的AggregationBuilder，然后将其设置在SearchSourceBuilder上，
     * 可以将聚合添加到搜索中。在下面的示例中，我们创建了一个基于公司名称的术语聚合，其中包含一个关于公司员工平均年龄的子聚合
     * terms相当于是别名
     */

    public void Aggregations() throws IOException {

        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        TermsAggregationBuilder aggregation = AggregationBuilders.terms("by_company").field("company.keyword");
        aggregation.subAggregation(AggregationBuilders.avg("average_age").field("age"));
        searchSourceBuilder.aggregation(aggregation);
        //其他聚合函数可以到官网查询
        //https://www.elastic.co/guide/en/elasticsearch/client/java-rest/current/java-rest-high-aggregation-builders.html
        SearchRequest searchRequest = new SearchRequest();
        searchRequest.indices("posts");
        searchRequest.source(searchSourceBuilder);

        /**
         * 同步调用可能会抛出IOException，以防在高级REST客户机中解析REST响应失败、请求超时或类似情况下没有响应从服务器返回。
         * 在服务器返回4xx或5xx错误代码的情况下，高级客户端尝试解析响应体错误细节，然后抛出一个通用的ElasticsearchException
         * 并将原始的ResponseException作为一个被抑制的异常添加到它。
         */
        SearchResponse searchResponse = client.search(searchRequest, RequestOptions.DEFAULT);

        System.out.println(searchResponse);

        RestStatus status = searchResponse.status();
        TimeValue took = searchResponse.getTook();
        Boolean terminatedEarly = searchResponse.isTerminatedEarly();
        boolean timedOut = searchResponse.isTimedOut();
/**
 * 其次，响应还提供有关切分级别上执行的信息，方法是提供关于受搜索影响的切分总数的统计信息，
 * 以及成功和失败的切分。可能的故障也可以通过遍历shardsearchfailure数组来处理，如下面的例子所示:
 */

        int totalShards = searchResponse.getTotalShards();
        int successfulShards = searchResponse.getSuccessfulShards();//成功
        int failedShards = searchResponse.getFailedShards();//失败
        for (ShardSearchFailure failure : searchResponse.getShardFailures()) {
            // failures should be handled here //这里应该处理失败
        }

        SearchHits hits = searchResponse.getHits();

        SearchHit[] searchHits = hits.getHits();
        for (SearchHit hit : searchHits) {
            //获取结果
            String sourceAsString = hit.getSourceAsString();
            Map<String, Object> sourceAsMap = hit.getSourceAsMap();
            String documentTitle = (String) sourceAsMap.get("title");
            List<Object> users = (List<Object>) sourceAsMap.get("user");
            Map<String, Object> innerObject = (Map<String, Object>) sourceAsMap.get("innerObject");

            //结果高亮
            Map<String, HighlightField> highlightFields = hit.getHighlightFields();
            HighlightField highlight = highlightFields.get("title");
            Text[] fragments = highlight.fragments();
            String fragmentString = fragments[0].string();

        }


        //另外一种解析结果
        /**
         * 通过首先获取聚合树的根，即Aggregations对象，然后按名称获取聚合，可以从SearchResponse检索聚合。
         */
        Aggregations aggregations = searchResponse.getAggregations();
        //获取by_company术语聚合
        Terms byCompanyAggregation = aggregations.get("by_company");
        Terms.Bucket elasticBucket = byCompanyAggregation.getBucketByKey("Elastic");
        //从该bucket获取average_age子聚合
        Avg averageAge = elasticBucket.getAggregations().get("average_age");
        double avg = averageAge.getValue();


    }

    /**
     * 多个索引之间查询
     */
    public void moreIndexs() throws IOException {

        FieldCapabilitiesRequest request = new FieldCapabilitiesRequest()
                .fields("user")
                .indices("posts", "authors", "contributors");

        request.indicesOptions(IndicesOptions.lenientExpandOpen());
        FieldCapabilitiesResponse response = client.fieldCaps(request, RequestOptions.DEFAULT);
        Map<String, FieldCapabilities> userResponse = response.getField("user");
        FieldCapabilities textCapabilities = userResponse.get("keyword");

        boolean isSearchable = textCapabilities.isSearchable();
        boolean isAggregatable = textCapabilities.isAggregatable();

        String[] indices = textCapabilities.indices();
        String[] nonSearchableIndices = textCapabilities.nonSearchableIndices();
        String[] nonAggregatableIndices = textCapabilities.nonAggregatableIndices();


    }

    /**
     * 具体代码  可参考:https://blog.csdn.net/majun_guang/article/details/81103623
     * 根据多条件组合与查询
     * <p>
     * 多条件或查询
     * must 就像sql里的and   相较于sql  select * from accounts.person where title='JAVA开发工程师' and age=30
     * <p>
     * <p>
     * should 就像sql里的or  SortBuilder 的作用不言而喻就是用来排序
     * 以上代码相较于sql  select * from   accounts.person where user='kimchy14' or  user='kimchy15'   ;
     * <p>
     * <p>
     * 范围查询rangeQuery.from（30，true）方法是大于30  后面的参数是是否包含 为true的话就是大于等于30 to就相当于小于
     * 如果也有包含参数为true的话就是小于等于  gt 是大于 gte是大于等于   lt是小于 lte是小于等于  第一句的builder就相当于 select * from accounts.person where age >=30 and age<=30; 
     * <p>
     * <p>
     * 包含查询使用termsQuery 可以传列表 也可以传多个参数 或者数组 setFetchSource有两个参数
     * 第一个参数是包含哪些参数 第二个参数是排除哪些参数   
     * 以上这段代码就相当于sql  select age from accounts.person where user in ('kimchy14','kimchy15','kimchy16');
     * <p>
     * <p>
     * 通配符查询像我们sql里的like 但是还不一样 like的百分号可以加到前后   
     * elasticsearch技术解析与实战中有一句话 是这么说的 为了避免极端缓慢的通配符查询
     * 通配符索引词不应该以一个通配符开头 通配符查询应该避免以通配符开头 
     * <p>
     * <p>
     * 常见统计  统计分为指标 和 桶 桶就是我们统计的样本  指标就是我们平时所查的count  sum  与sql不一样的是 我们还可以将统计的样本拿到 就是response.getHits
     */


    public void moretermQuery() {

//        QueryBuilder qb=QueryBuilders.termQuery("user","kimchy14");
//        QueryBuilder qb1=QueryBuilders.termQuery("user","kimchy15");
//
//        SortBuilder sortBuilder= SortBuilders.fieldSort("age");
//        sortBuilder.order(SortOrder.DESC);
//        QueryBuilder s=QueryBuilders.boolQuery().should(qb).should(qb1);//.must(qb5);
//        SearchRequestBuilder sv=client.prepareSearch("accounts").setTypes("person").setQuery(s).addSort(sortBuilder).setFrom(0)
//                .setSize(100);
//        logger.log(Level.INFO,sv.toString());
//        SearchResponse response=  sv.get();
//        SearchHits searchHits =  response.getHits();
//        for(SearchHit hit:searchHits.getHits()){
//            logger.log(Level.INFO , hit.getSourceAsString());
//        }
//
//        }


        //范围查询
        // RangeQueryBuilder rangeQueryBuilder = QueryBuilders.rangeQuery("age").from(30,true).to(30,true);
//        // RangeQueryBuilder rangeQueryBuilder = QueryBuilders.rangeQuery("age").gt(30 );
//        RangeQueryBuilder rangeQueryBuilder = QueryBuilders.rangeQuery("age").gte(30 );
//        QueryBuilder s=QueryBuilders.boolQuery().must(rangeQueryBuilder);//.must(qb5);
//        SearchRequestBuilder sv=client.prepareSearch("accounts").setTypes("person").setQuery(s).setFrom(0)
//                .setSize(100);
//        logger.log(Level.INFO,sv.toString());
//        SearchResponse response=  sv.get();
//        SearchHits searchHits =  response.getHits();
//        for(SearchHit hit:searchHits.getHits()){
//            logger.log(Level.INFO , hit.getSourceAsString());
    }

}
