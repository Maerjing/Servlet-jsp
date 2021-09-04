package com.student.service;

import com.student.entity.Student;

import java.util.List;

public interface IStudentService {
    public boolean addStudent(Student student);

    //根据学号删除学生
    public boolean delectStudentBysno(int sno);

    //根据学号修改该学生信息
    public boolean updataStudent(int no, Student student);

    //根据学号查询信息
    public Student queryStudentBySno(int no);

    //查询所有学生的信息
    public List<Student> queryAllStudent();
    //分页查询当前页的集合
    public List<Student> queryStudentByPage(int currentPage, int pageSize);
    //查询数据总量
    public int totalCount();
    //模糊查询
    public List<Student> moHuQuery(String word);
}
