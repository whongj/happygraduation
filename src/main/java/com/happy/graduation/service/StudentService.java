package com.happy.graduation.service;

import com.happy.graduation.dao.StudentDao;
import com.happy.graduation.pojo.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * Created by wanghongjie on 2017/5/29.
 */

@Service
public class StudentService {
    @Autowired
    StudentDao studentDao;

    /**
     * 注册
     * @param student
     * @return
     */
    public int AddUser(Student student) {
        return studentDao.addUser(student);
    }




/**
 * 查询所有学生
 * @param begin
 * @param end
 * @return
 */
    public ArrayList<Student> QueryAllStudent(int begin, int end) {
         return (ArrayList<Student>) studentDao.queryAll(begin, end);

    }

    /**
     * 查询是否有这个学生--登陆用
     * @param student
     * @return
     */
    public boolean login(Student student) {
        if(null!=(Student) studentDao.selectUser(student)){
            return true;
        }
        return false;
    }

}
