package com.example.springboot_ssm.controller;

import com.example.springboot_ssm.domain.Student;
import com.example.springboot_ssm.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    @RequestMapping("test")
    public String test(){
        return "测试成功";
    }

    @RequestMapping("add")
    public String add(){
        Student student = new Student();

        student.setName("新添加");
        student.setMoney(200);

        studentService.add(student);
        return "添加成功";
    }

    @RequestMapping("delete")
    public String delete(int id){
        studentService.delete(id);
        return "删除成功";
    }

    @RequestMapping("query")
    public Student query(int id){
        Student query = studentService.query(id);
        return query;
    }

    @RequestMapping("queryall")
    public List<Student> queryall(){
        List<Student> queryall = studentService.queryall();
        return queryall;
    }

    @RequestMapping("update")
    public String update(){
        Student student = new Student();
        student.setId(3);
        student.setName("更改为3");
        studentService.update(student);
        return "更新成功";
    }

    @RequestMapping("t_a")  //模拟正常
    public boolean transfer_accounts(int from,int to,int money){
        boolean b = studentService.transfer_accounts(from, to, money);
        return b;
    }

    @RequestMapping("t_a2")   //模拟异常
    public boolean transfer_accounts2(int from,int to,int money){
        boolean b = studentService.transfer_accounts2(from, to, money);
        return b;
    }
}
