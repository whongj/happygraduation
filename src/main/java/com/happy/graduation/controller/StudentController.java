package com.happy.graduation.controller;

import com.happy.graduation.pojo.Student;
import com.happy.graduation.pojo.StudentConn;
import com.happy.graduation.service.StudentConnService;
import com.happy.graduation.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by wanghongjie on 2017/5/29.
 */
@Controller
@RequestMapping(value = "/stu")
public class StudentController {

    @Autowired
    StudentService studentService;
    @Autowired
    StudentConnService studentConnService;
    /**
     * 用户登录功能
     * @param request
     * @param response
     * @param student
     * @return
     */
    @RequestMapping("/user/login")
    public String userLogin(HttpServletRequest request,
                            HttpServletResponse response, Student student) {
        HttpSession session=request.getSession();
        if (studentService.login(student)) {
            session.setAttribute("student", student);
            StudentConn studentConn = studentConnService.get

            session.setAttribute("allprice", allprice);
            return "forward:/showindex";
        }
        return "forward:/showUserlogin";
    }

//登陆成功返回首页
        return "index";
    }
    /**
     * 学生注册
     * @param request
     * @param response
     * @param student
     * @return
     */
    @RequestMapping("/register")
    public String userRegister(HttpServletRequest request,
                               HttpServletResponse response, Student student) {

        int judge = studentService.AddUser(student);

        if (judge == 1) {
            return "forward:/showUserlogin";
        }
        else
        {
            request.setAttribute("message", student.getSno()+"已经存在了");
            return "forward:/showUserregist";
        }
    }

}
