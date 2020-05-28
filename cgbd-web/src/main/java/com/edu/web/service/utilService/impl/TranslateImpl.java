package com.edu.web.service.utilService.impl;

import com.edu.cgbd.utils.MD5Util;
import com.edu.cgbd.utils.UnicodeUtil;
import com.edu.cgbd.utils.UrlUtil;
import com.edu.web.service.utilService.TranslateService;
import com.edu.web.utils.*;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.jsoup.nodes.Element;

import java.io.*;
import java.lang.reflect.Field;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Service
public class TranslateImpl extends JDBCUtils implements TranslateService {

    @Value("${baiduLangKey}")
    List<String> langs;

    private String txtFilePath = "C:/Users/ASUS/Desktop/test.txt";

    private String htmlFilePath = "C:/Users/ASUS/Desktop/test.html";

    private String[] attrs = {"title", "placeholder"};

    private String url = "jdbc:mysql://192.168.1.111:3306/iccmaccount?useSSL=false&allowMultiQueries=true";

    private String className = "com.mysql.jdbc.Driver";

    private String username = "root";

    private String password = "root";

    @Override
    public Translate getTranslateValue(String translateValue, String from) {
        //region 百度翻译，每月200万字翻译免费
        String appId = "20190614000307442";
        String key = "1Q04gvACtOULn9I5JBNz";
        String salt = "35296";
        Translate translate = new Translate();
        BufferedReader in = null;
        try {
            /*查询参数*/
            Map<String, Object> param = new HashMap<>();
            param.put("q", translateValue);
            param.put("appid", appId);
            param.put("salt", salt);
            param.put("from", from);
            param.put("sign", MD5Util.MD5(appId + translateValue + salt + key));
            for (String value : langs) {
                String result = "";
                param.put("to", value);
                String strUrl = UrlUtil.appendUrl("http://api.fanyi.baidu.com/api/trans/vip/translate", param);
                URL url = new URL(strUrl);
                URLConnection connection = url.openConnection();
                connection.connect();

                /*
                 *基础版 每个id 每秒限定1个请求，所以要做睡眠
                 *2019.9月升级为 标准版 每秒10个请求
                 * */
                //Thread.sleep(1000);
                // 获取所有响应头字段
                Map<String, List<String>> map = connection.getHeaderFields();

                // 定义 BufferedReader输入流来读取URL的响应
                in = new BufferedReader(new InputStreamReader(
                        connection.getInputStream()));
                String line;
                while ((line = in.readLine()) != null) {
                    result += line;
                }
                String lang = result.split("dst\":\"")[1].split("\"")[0];

                Field[] declaredFields = Translate.class.getDeclaredFields();

                for (Field field : declaredFields) {
                    field.setAccessible(true);
                    String name = field.getName();
                    if (name.equals(value)) {
                        if (value.equals("en")) field.set(translate, lang);
                        else field.set(translate, UnicodeUtil.unicodeToString(lang));
                    }
                }
            }
            return translate;
        } catch (Exception e) {
            System.err.println(e);
            return null;
        }
        // endregion
    }

    @Override
    public boolean exportInit(TranslateInfo translateInfo) {
        String str = null;
        try {
            File file = new File(txtFilePath);
            if (!file.exists()) {
                file.createNewFile();
            }
            ArrayList<String> ReaderList = new ArrayList<>();
            FileInputStream inputStream = new FileInputStream(file);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            while ((str = bufferedReader.readLine()) != null) {
                //如果不是空串、添加到list、然后提交
                if (!str.equals("")) {
                    System.out.println(str);
                    ReaderList.add(str);
                }
            }
            bufferedReader.close();
            inputStream.close();

            //如果最后一行是COMMINT则删除,isCommit变量判断最后是否加上COMMIT
            Boolean isCommit = false;
            if (ReaderList.size() != 0) {
                if (ReaderList.get(ReaderList.size() - 1).equals("COMMIT")) {
                    ReaderList.remove(ReaderList.size() - 1);
                    isCommit = true;
                }
            }
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream);
            BufferedWriter bw = new BufferedWriter(outputStreamWriter);

            if (ReaderList.size() != 0) {
                for (String string : ReaderList) {
                    bw.write(string);
                    bw.newLine();
                    System.out.println(string);
                }
            } else if (ReaderList.size() == 0) {
                bw.write("");
            }
            for (LangDetail langDetail : translateInfo.getLangDetails()) {
                String sql = "INSERT INTO LANG_DETAIL (LANG_ID, LANG_KEY, LANG_VALUE, UPDATE_BY, UPDATE_ON) VALUES (" + langDetail.getLangId() + ",\'" + langDetail.getLangKey() + "\',\'" + langDetail.getLangDetail() + "\',null,null);";
                System.out.println(sql);
                bw.write(sql);
                bw.newLine();
                System.out.println("Done");
            }
            if (isCommit) {
                bw.write("COMMIT");
            }
            bw.flush();
            bw.close();
            return true;
        } catch (Exception e) {
            System.err.println(e.toString());
            return false;
        }
    }

    @Override
    public boolean exportSql(TranslateInfo translateInfo) {
        SetConnection(className, url, username, password);
        String sql = "INSERT INTO LANG_DETAIL (LANG_ID, LANG_KEY, LANG_VALUE) VALUES ";
        for (LangDetail langDetail : translateInfo.getLangDetails()) {
            sql += "(" + langDetail.getLangId() + ",\'" + langDetail.getLangKey() + "\',\'" + langDetail.getLangDetail() + "\'),";
        }
        String subSql = sql.substring(0, sql.length() - 1);
        System.out.println(subSql);
        try {
            ps = con.prepareStatement(subSql);
            ps.executeUpdate();
        } catch (Exception e) {
            System.err.println(e);
        }
        CloseAll();
        return false;
    }

//    @Override
//    public boolean exportHtml(TranslateInfo translateInfo) {
//        /*通过id:value键值对对dom对象进行修改，在这里没用到这个功能，所以传个空的map进去*/
//        Map<String, String> map = new HashMap<>();
//        try {
//            Document document = DocumentUtil.getDocument(htmlFilePath, map);
//            /*获取全部节点，更改含有text的节点*/
//            Elements allElements = document.getAllElements();
//            for(Element element : allElements){
//                if(!element.html().contains("</") && !element.text().equals("")){
//                    for(LangDetail langDetail : translateInfo.getLangDetails()){
//                        if(langDetail.getLangDetail().equals(element.text())&&element.attr("th:text").equals("")){
//                            element.attr("th:text",langDetail.getLangKey());
//                        }
//                    }
//                }
//            }
//
//            /*修改含有指定属性的文本*/
//            for(String attr : attrs){
//                setTitleAndMore(document,translateInfo.getLangDetails(),attr);
//            }
//
//            DocumentUtil.write("C:/Users/ASUS/Desktop/test1.html",document);
//            return true;
//        }catch (Exception e){
//            System.err.println(e.toString());
//            return false;
//        }
//    }

    @Override
    public boolean exportHtml(TranslateInfo translateInfo) {
        /*通过id:value键值对对dom对象进行修改，在这里没用到这个功能，所以传个空的map进去*/
        Map<String, String> map = new HashMap<>();
        File file = null;
        try {
            file = File.createTempFile("tmp", null);
            translateInfo.getImportFile().transferTo(file);

            Document document = DocumentUtil.getDocument(file, map);
            file.deleteOnExit();
            /*获取全部节点，更改含有text的节点*/
            Elements allElements = document.getAllElements();
            for (Element element : allElements) {
                if (!element.html().contains("</") && !element.text().equals("")) {
                    for (LangDetail langDetail : translateInfo.getLangDetails()) {
                        if (langDetail.getLangDetail().equals(element.text()) && element.attr("th:text").equals("")) {
                            element.attr("th:text", langDetail.getLangKey());
                        }
                    }
                }
            }

            /*修改含有指定属性的文本*/
            for (String attr : attrs) {
                setTitleAndMore(document, translateInfo.getLangDetails(), attr);
            }

            DocumentUtil.write("C:/Users/ASUS/Desktop/test1.html", document);
            return true;
        } catch (Exception e) {
            System.err.println(e.toString());
            return false;
        }
    }

    public static void setTitleAndMore(Document document, List<LangDetail> langDetails, String attr) {
        Elements valueElements = document.getElementsByAttribute(attr);
        for (Element element : valueElements) {
            for (LangDetail langDetail : langDetails) {
                if (element.attr(attr).equals(langDetail.getLangDetail()) && element.attr("th" + attr).equals("")) {
                    element.attr("th:" + attr, langDetail.getLangKey());
                }
            }
        }
    }
}
