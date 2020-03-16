package com.edu.web.controller;

import com.edu.cgbd.pojo.MarkdownData;
import com.edu.web.service.searchService.SearchService;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

@Controller
public class MarkdownController {

    @Autowired
    SearchService searchService;

    @GetMapping("/simple")
    public String markdown(){
        return "markdown";
    }

    /*@PostMapping("contentCommit")
    public ModelAndView contentCommit(String content){
        System.out.println("提交的内容为：" + content);
        ModelAndView modelAndView = new ModelAndView("view");
        //将内容发送至前台预览
        modelAndView.addObject("viewContent" , content);
        System.out.println("跳转至内容显示页面");
        return modelAndView;
    }*/

    @PostMapping("contentCommit")
    public String contentCommit(String content){
        MarkdownData markdownData = new MarkdownData();
        markdownData.setTag("java");
        markdownData.setTitle("java配置");
        markdownData.setDetails(content);
        markdownData.setPublishTime(String.valueOf(System.currentTimeMillis()));
        searchService.contentCommit(markdownData);
        return "resume";
    }

    /**
     * 上传文件
     * @return
     */
    @RequestMapping("uploadMdFile.json")
    @ResponseBody
    public Map<String,Object> getContent(HttpServletRequest request, @RequestParam(value = "file",required=false) MultipartFile file, String topicCode){
        Map<String,Object> resultMap = new HashMap<>();
        if(topicCode != null && !"".equals(topicCode)){
            //该CODE用于对应图片存储，实际项目中需要存储该文章与图片的关系，我这不做处理
            System.out.println("主题CODE->" + topicCode);
        }
        try {
            // 检测是不是存在上传文件
            boolean isMultipart = ServletFileUpload.isMultipartContent(request);
            if(isMultipart){
                MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
                Map<String, MultipartFile> multipartFileMap = multipartRequest.getFileMap();
                for (Map.Entry<String, MultipartFile> entryFile : multipartFileMap.entrySet()) {
                    MultipartFile value = entryFile.getValue();
                    //读取输入流
                    InputStream is = value.getInputStream();
                    //获取文件名
                    String fileName = value.getOriginalFilename();
                    //声明byte缓冲数组
                    byte[] b = new byte[(int) value.getSize()];
                    is.read(b);
                    //将文件名上传的name作为返回的key，默认为file
                    resultMap.put(entryFile.getKey() , fileName);
                    //返回接口调用状态码
                    resultMap.put("retCode" , "success");
                    //返回图片访问路径，此处可以改为OSS分布式存储，根据项目具体情况调整
                    resultMap.put("rootPath" , "http://localhost:8080/"+fileName);
                    //上传到文件服务器路径，此处我直接上传到项目部署编译路径，需要调整
                    OutputStream os = new FileOutputStream(new File("G:\\cgbd-local\\cgbd-web\\src\\main\\resources\\static" , fileName));
                    os.write(b);
                    os.flush();
                }
            }
        }catch (Exception e){
        }
        return resultMap;
    }
}
