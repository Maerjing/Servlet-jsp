package com.student.service.impl;

import com.student.entity.Student;
import com.student.dao.impl.StudentDaoImpl;
import com.student.service.IStudentService;

import java.util.List;

public class StudentServiceImpl implements IStudentService {
    StudentDaoImpl studentDaoImpl = new StudentDaoImpl();
    Student student = null;

    //增加学生信息
    @Override
    public boolean addStudent(Student student) {
        if (!studentDaoImpl.isExist(student.getSon())) {
            studentDaoImpl.addStudent(student);
            return true;
        } else {
            System.out.println("此人已存在！");
            return false;
        }
    }

    //根据学号删除学生
    @Override
    public boolean delectStudentBysno(int sno) {
        if (studentDaoImpl.isExist(sno)) {
            return studentDaoImpl.deleteStudent(sno);
        } else {
            return false;
        }
    }

    //根据学号修改该学生信息
    @Override
    public boolean updataStudent(int no, Student student) {
            return studentDaoImpl.updataStudent(no, student);
    }

//    //根据学号修改该学生信息
//    @Override
//    public boolean updataStudent(int no, Student student) {
//        if (studentDaoImpl.isExist(student.getSon())) {
//            return studentDaoImpl.updataStudent(no, student);
//        } else {
//            return false;
//        }
//    }

    //根据学号查询信息
    @Override
    public Student queryStudentBySno(int no) {
        return studentDaoImpl.queryStudentBysno(no);
    }

    //查询所有学生的信息
    @Override
    public List<Student> queryAllStudent() {
        return studentDaoImpl.queryAllStudent();
    }

    //查询当前页学生集合
    @Override
    public List<Student> queryStudentByPage(int currentPage, int pageSize) {
        return studentDaoImpl.queryStudentByPage(currentPage, pageSize);
    }

    //查询总数据量
    @Override
    public int totalCount() {
        return studentDaoImpl.totalCount();
    }

    @Override
    public List<Student> moHuQuery(String word) {
        return studentDaoImpl.mhQueryStudent(word);
    }
}
