package com.BugManageSystem.Interceptor;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class adminInterceptor extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        Integer identity = (Integer)session.getAttribute("identity");
        if (identity == 1){return true;}else{
            response.setHeader("content-type", "text/html;charset=UTF-8");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write("<html><body><br><br><h3 align='center'>非法访问！</h3><script>setTimeout(function(){window.top.location='/'},1000)</script></body></html>");
            return false;
        }
    }
}
