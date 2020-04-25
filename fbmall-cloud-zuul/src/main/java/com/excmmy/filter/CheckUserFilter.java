package com.excmmy.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@Component
public class CheckUserFilter extends ZuulFilter {
    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        //获取请求URI，不需要登录的就return false;需要登录的return true
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        String uri = request.getRequestURI();
        List<String> checkUris = new ArrayList<>();
//         此处也可以从数据库中进行读取与配置
        checkUris.add("/ydma-video/chapters"); // 需要判断权限的服务, 在此处填写
        System.out.println("检查" + uri + "是否需要进行拦截检查");
        if (checkUris.contains(uri)) {
            System.out.println("请求被拦截shouldFilter");
            return true; // true调用filter
        } else {
            System.out.println("请求被放行shouldFilter");
            return false; // false不调用filter
        }
    }

    @Override
    public Object run() throws ZuulException {
        // Token检测
        RequestContext currentContext = RequestContext.getCurrentContext();
        HttpServletRequest request = currentContext.getRequest();
        String token = request.getParameter("token");
        System.out.println("==========================");
        System.out.println("token: " + token);
        if (token != null && !"".equals(token)) {
            // 放行
            System.out.println("请求被放行run");
            return true;
        }
        HttpServletResponse response = currentContext.getResponse();
        // 被拦截, 写 false
        System.out.println("请求被拦截run");
//        currentContext.setResponseBody("凉凉");
        return false;
    }
}
