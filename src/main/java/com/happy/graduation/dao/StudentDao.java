package com.happy.graduation.dao;

import com.happy.graduation.pojo.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by wanghongjie on 2017/5/29.
 */
public interface StudentDao {
    /**
     * 增加用户
     * @param student
     * @return 如果不为0，则增加成功
     */
    public int addUser(Student student);

    /**
     * 查询用户--登陆使用
     * @param student
     * @return 如果不为null，则说明有该用户
     */
    public Student selectUser(Student student);


    /**
     * 根据偏移量查询用户列表
     *
     * 列出学生的列表--没什么用，需要
     * @param offset
     * @param limit
     * @return
     */
    List<Student> queryAll(@Param("offset") int offset, @Param("limit") int limit);

}
