package com.hut.myblog.interceptor;

import com.hut.myblog.bean.User;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;
@Component
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object handler) throws Exception {
        HttpSession session = request.getSession();
        //这里的User是登陆时放入session的
        User user = (User) session.getAttribute("user");
        if (user == null){

            response.setCharacterEncoding("UTF-8");
            response.setContentType("text/html;charset=UTF-8");
            PrintWriter out=response.getWriter();
            out.print("<script>alert('您还未登录，即将跳转到登陆界面!');" +
                   "window.location='/admin';</script>");
            return false;
        }else {
            return true;    //如果session里有user，表示该用户已经登陆，放行，用户即可继续调用自己需要的接口
        }
    }
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {
    }

    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {
    }

}
