package com.example.springboot_ssm.dao;

import com.example.springboot_ssm.domain.Student;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface IStudentDao {

    //增
    @Insert("Insert into students(name,money) values(#{name},#{money})")
    void add(Student student);

    //删
    @Delete("DELETE FROM students WHERE id=#{id}")
    void delete(int id);

    //改
    @Update("UPDATE students SET name=#{name} , money=#{money} WHERE id=#{id}")
    void update(Student student);

    //查
    @Select("SELECT * FROM students where id =#{id}")
    Student query(int id);

    @Select("SELECT * FROM students")
    List<Student> queryall();


}
