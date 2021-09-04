package com.student.dao;

import com.student.entity.Student;

import java.util.List;

public interface IStudentDaoImpl {
    //查询该学生是否存在
    public boolean isExist(int sno);

    //增加学生信息
    public boolean addStudent(Student student);

    //根据学号删除该学生信息
    public boolean deleteStudent(int no);

    //根据学号修改学生信息
    public boolean updataStudent(int no, Student student);

    //根据学号查询
    public Student queryStudentBysno(int sno);

    //查询所有学生信息
    public List<Student> queryAllStudent();
    //查询数据库中数据总数
    public  int totalCount();
    //分页查询当前页的对象集合
    public List<Student>  queryStudentByPage(int currentPage,int pageSize);
    //模糊查询学生信息
    public List<Student> mhQueryStudent(String keyWord);
}
