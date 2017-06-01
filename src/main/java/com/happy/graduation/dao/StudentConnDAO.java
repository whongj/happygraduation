package com.happy.graduation.dao;

import com.happy.graduation.pojo.StudentConn;

import java.util.List;

/**
 *
 * 创建学生联系表--
 * varchar sno
 * varchar 论文Filepath
 * varchar 源码filepath
 * boolean 学费state
 * boolean 图书state
 * boolean 器材借用state
 *
 * Created by wanghongjie on 2017/5/30.
 */
public interface StudentConnDAO {
    /**
     * 增加一名用户——在注册／登陆的时候就同时增加这张表里的数据。为了提高性能，避免使用外键。-----应该看看mybatis咋使用外键了。。。好菜啊我。。。
     * @param studentConn
     * @return
     */
    public int add(StudentConn studentConn);

    /**
     * 通过ID进行修改数据
     * @param studentConn
     * @return
     */
    public int update(StudentConn studentConn);

    /**管理员需要看到所有的对象——但是要进行数据分页。。。
     * 获得所有的对象
     * @return
     */
    public List getAllObject();
    /**
     * 通过ID获得一个对象
     * @param id
     * @return
     */
    public StudentConn getAObjectById(String id);
}
