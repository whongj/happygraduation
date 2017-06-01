package com.happy.graduation.controller;

import com.happy.graduation.pojo.Student;
import com.happy.graduation.pojo.StudentConn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;

/**
 * Created by wanghongjie on 2017/5/30.
 */
@Controller
public class GeneralObjectController {

    @Autowired
    private KindsService ks;
    @Autowired
    private CartsService cartsservice;

    @Autowired
    private ProductService ps;

    /**
     * 显示之前的index界面
     * @return
     */
    @RequestMapping("/showbeforeindex")
    public String showBeforeIndex()
    {
        return "index";
    }


    /**
     * 显示首页
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("/showindex")
    public String showIndex(HttpServletRequest request, HttpServletResponse response)
    {
        ArrayList<Kinds> allkinds=ks.getAllKindsInstate();
        request.setAttribute("allkinds", allkinds);
        return "toyindex";
    }

    /**
     * 显示用户管理员登录
     * @return
     */
    @RequestMapping("/showadminlogin")
    public String showAdminLogin()
    {
        return "/admin/login";
    }

    /**
     * 显示用户注册界面
     * @return
     */
    @RequestMapping("/showUserregist")
    public String showUserregist()
    {
        return "/register";
    }

    /**
     * 显示用户登录界面
     * @return
     */
    @RequestMapping("/showUserlogin")
    public String showUserlogin()
    {
        return "login";
    }

//    /**
//     * 显示所有对应类型的产品
//     * @param request
//     * @param response
//     * @param kindsid
//     * @return
//     */
//    @RequestMapping("/showproducts")
//    public String shwoproducts(HttpServletRequest request,HttpServletResponse response,String kindsid)
//    {
//        ArrayList<Product> allkinds=ps.getProductByKindsID(kindsid);
//        request.setAttribute("allproduct", allkinds);
//        return "products";
//    }


    /**
     * 显示某用户的购物车
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("/showstuinfo")
    public String showcart(HttpServletRequest request,
                           HttpServletResponse response)
    {
        HttpSession session = request.getSession();
        Student user = (Student) session.getAttribute("user");

        if (user != null) {
            ArrayList<StudentConn> conns = cartsservice.getACartsByUserID(user.getId());
            request.setAttribute("carts", conns);

            return "cart";
        }
        request.setAttribute("message", "您没有登陆，没有办法操作");
        return "forward:/showUserlogin";

    }

    /**
     * 显示联系表
     * @return
     */
    @RequestMapping("/showcontact")
    public String showcontact()
    {
        return "contact";
    }
}
