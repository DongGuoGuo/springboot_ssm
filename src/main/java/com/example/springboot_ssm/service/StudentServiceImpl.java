package com.example.springboot_ssm.service;

import com.example.springboot_ssm.dao.IStudentDao;
import com.example.springboot_ssm.domain.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional   //申明要用事务   也可以写在方法上
public class StudentServiceImpl implements StudentService {

    @Autowired
    private IStudentDao iStudentDao;


    @Override
    public void add(Student student) {
        iStudentDao.add(student);
    }

    @Override
    public void delete(int id) {
        iStudentDao.delete(id);
    }

    @Override
    public Student query(int id) {
        Student query = iStudentDao.query(id);
        return query;
    }

    @Override
    public List<Student> queryall() {
        List<Student> queryall = iStudentDao.queryall();
        return queryall;
    }

    @Override
    public void update(Student student) {
        iStudentDao.update(student);
    }

    /**
     * 模拟正常转账
     * @param from
     * @param to
     * @param money
     * @return
     */
    @Override
    public boolean transfer_accounts(int from,int to,int money) {
        Student query_from = iStudentDao.query(from);
        Student query_to = iStudentDao.query(to);
        query_from.setMoney(query_from.getMoney() - money);
        query_to.setMoney(query_to.getMoney()+money);
        iStudentDao.update(query_from);
        iStudentDao.update(query_to);

        return true;
    }

    /**
     * 模拟异常转账
     * @param from
     * @param to
     * @param money
     * @return
     */
    @Override
    public boolean transfer_accounts2(int from, int to, int money) {
            Student query_from = iStudentDao.query(from);
            Student query_to = iStudentDao.query(to);
            query_from.setMoney(query_from.getMoney() - money);
            query_to.setMoney(query_to.getMoney()+money);
            iStudentDao.update(query_to);
            iStudentDao.update(query_from);
            int i=1/0;
        return true;
    }
}
