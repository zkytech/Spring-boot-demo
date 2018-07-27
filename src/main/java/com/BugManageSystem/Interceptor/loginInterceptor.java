package com.BugManageSystem.Interceptor;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class loginInterceptor extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session=request.getSession();
        if (session.getAttribute("username")!=null){
            // 已登录
            System.out.println("已经登录："+session.getAttribute("username"));
            return true;
        }else {
            System.out.println("未登录");
            // 未登录，跳转到登录页面
            response.setCharacterEncoding("UTF-8");
            response.setHeader("content-type", "text/html;charset=UTF-8");
            response.getWriter().write("<html><body><br><br><h3 align='center'>请登录后进行访问!</h3><script>setTimeout(function(){window.top.location='/'},1000)</script></body></html>");
            return false;
        }
    }
}
