package com.edu.web.config;

import com.edu.cgbd.domain.account.GlobalParameter;
import com.edu.cgbd.domain.account.MenuGroup;
import com.edu.cgbd.pojo.CgbdResult;
import com.edu.cgbd.pojo.LanguageInfo;
import com.edu.web.service.accountService.GlobalParameterService;
import com.edu.web.service.accountService.LanguageService;
import com.edu.web.service.accountService.MenuService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

/**
 * 自定义拦截器
 * 实现原生拦截器的接口
 */
@Slf4j
@Component
public class Interceptor implements HandlerInterceptor {

    @Value("${languages}")
    List<String> languages;

    @Autowired
    LanguageService languageService;

    @Autowired
    GlobalParameterService globalParameterService;

    @Autowired
    MenuService menuService;

    //请求处理之前进行调用（Controller方法调用之前,返回true才会继续向下执行,返回false取消当前请求
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        if (request.getRequestURI().equals("/Monitor/") ||
                request.getRequestURI().equals("/Monitor")) {
            response.sendRedirect(request.getContextPath() + "/index");
            return false;
        }
        return true;
    }

    //请求处理之后视图被渲染之前调用,（Controller方法调用之后);
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {
        LanguageInfo languageInfo = new LanguageInfo();
        try {
            if (modelAndView != null) {
                //region 返回lang
                List<String> languages = new ArrayList<String>(
                        Arrays.asList(
                                ((String) globalParameterService.globalParameterByKey("languages").getData()).split(","))
                );
                languageInfo.setLanguages(languages);
                languageInfo.setLangDetails(getLanguageDetails());
                modelAndView.addObject("lang", languageInfo);
                // endregion
                //region 返回menu
                modelAndView.addObject("menuGroups", menuService.menuGroups().getData());
                //endregion
            }
        } catch (Exception e) {
            log.error("Interceptor.postHandle", e);
        }
    }

    //请求结束之后DispatcherServlet渲染视图之后执行被调用,（主要是用于进行资源清理工作);
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception {

    }

    // region 获取语言包 转换为HashMap
    private Map<Object, Map<Object, Object>> getLanguageDetails() throws Exception {
        Map<Object, Map<Object, Object>> langDetailsMap = new HashMap<>();
        CgbdResult cgbdResult = languageService.langDetails();
        if (cgbdResult.getCode() != 200) {
            return langDetailsMap;
        }
        List<LinkedHashMap> langDetailsList = (List<LinkedHashMap>) cgbdResult.getData();
        for (LinkedHashMap linkedHashMap : langDetailsList) {
            langDetailsMap.put(linkedHashMap.get("langKey"), linkedHashMap);
        }
        return langDetailsMap;
    }
    // endregion
}
