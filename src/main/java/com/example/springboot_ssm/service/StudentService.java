package com.example.springboot_ssm.service;

import com.example.springboot_ssm.domain.Student;

import java.util.List;


public interface StudentService {

    void add(Student student);

    void delete(int id);

    Student query(int id);

    List<Student> queryall();

    void update(Student student);

    boolean transfer_accounts(int from,int to,int money);

    boolean transfer_accounts2(int from,int to,int money);
}
