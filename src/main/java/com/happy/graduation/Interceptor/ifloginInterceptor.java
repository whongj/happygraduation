package com.happy.graduation.Interceptor;
import com.happy.graduation.pojo.Student;
import com.happy.graduation.pojo.Teacher;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by wanghongjie on 2017/6/1.
 */
public class ifloginInterceptor implements HandlerInterceptor {
    private static final String[] IGNORE_URL={"/loginForm","/login"};

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        //flag变量用于判断用户是否登陆
        boolean flag = false;
        String servletPath = httpServletRequest.getServletPath();
        for (String s : IGNORE_URL) {
            if (servletPath.contains(s)) {
                flag = true;
                break;

            }
        }
        if (!flag) {
            //获取session中的用户
            Student student = (Student) httpServletRequest.getSession().getAttribute("student");
            Teacher teacher = (Teacher) httpServletRequest.getSession().getAttribute("teacher");

            if (null == student&&null==teacher) {
                System.out.println("拦截未登陆");
                httpServletRequest.setAttribute("message","请先登录再访问");
                httpServletRequest.getRequestDispatcher("login").forward(httpServletRequest, httpServletResponse);

            }else{
                flag = true;
            }
        }
        return flag;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
