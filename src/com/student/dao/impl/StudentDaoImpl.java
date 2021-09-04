package com.student.dao.impl;

import com.student.dao.IStudentDaoImpl;
import com.student.entity.Student;
import com.student.util.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDaoImpl implements IStudentDaoImpl {


    //查询该学生是否存在
    @Override
    public boolean isExist(int sno) {
        return queryStudentBysno(sno) == null ? false : true;
    }

    //增加学生信息
    @Override
    public boolean addStudent(Student student) {
        String sql = "insert into student (sclass,sno,sname,sgrade,sage,saddress) values (?,?,?,?,?,?)";
        Object params[] = {student.getSclass(),student.getSon(), student.getSname(),student.getSgrade(), student.getSage(), student.getSaddress()};
        return DBUtil.executeUpdata(sql, params);

    }

    //根据学号删除该学生信息
    @Override
    public boolean deleteStudent(int no) {
        String sql = "delete from student where sno=?";
        Object params[] = {no};
        return DBUtil.executeUpdata(sql, params);
    }

    //根据学号修改学生信息
    @Override
    public boolean updataStudent(int no, Student student) {
        String sql = "update student set sclass=?, sname=?,sgrade=?,sage=?,saddress=? where sno=?";
        Object params[] = {student.getSclass(),student.getSname(), student.getSgrade(),student.getSage(), student.getSaddress(), no};
        return DBUtil.executeUpdata(sql, params);
    }

    //根据学号查询
    @Override
    public Student queryStudentBysno(int sno) {
        ResultSet resultSet = null;
        Student student = null;
        try {
            String sql = "select * from student where sno=?";
            Object params[] = {sno};
            resultSet = DBUtil.executeQuery(sql, params);
            if (resultSet.next()) {
                String sclass=resultSet.getString("sclass");
                int no = resultSet.getInt("sno");
                String name = resultSet.getString("sname");
                Double grade=resultSet.getDouble("sgrade");
                int age = resultSet.getInt("sage");
                String address = resultSet.getString("saddress");
                student=new Student(sclass,no,name,grade,age,address);
            }
            return student;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            DBUtil.closeException(DBUtil.connection, resultSet, DBUtil.preparedStatement);
        }
    }


    //查询所有学生信息
    @Override
    public List<Student> queryAllStudent() {
        Student student = null;
        ResultSet resultSet = null;
        List<Student> students = new ArrayList<>();
        try {
            String sql = "select * from student ";
            resultSet = DBUtil.executeQuery(sql, null);
            while (resultSet.next()) {
                String sclass=resultSet.getString("sclass");
                int no = resultSet.getInt("sno");
                String name = resultSet.getString("sname");
                Double grade=resultSet.getDouble("sgrade");
                int age = resultSet.getInt("sage");
                String address = resultSet.getString("saddress");
                student=new Student(sclass,no,name,grade,age,address);
                students.add(student);
            }
            return students;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            DBUtil.closeException(DBUtil.connection, resultSet, DBUtil.preparedStatement);
        }
    }

    //查询总数据量
    @Override
    public int totalCount() {
        ResultSet resultSet = null;
        try {
            String sql = "select count(*) from student";
            resultSet = DBUtil.executeQuery(sql, null);
            int count = -1;
            if (resultSet.next()) {
                count = resultSet.getInt(1);
            }
            return count;
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        } finally {
            DBUtil.closeException(DBUtil.connection, resultSet, DBUtil.preparedStatement);
        }
    }

    //查询当前页学生集合
    @Override
    public List<Student> queryStudentByPage(int currentPage, int pageSize) {
        ResultSet resultSet = null;
        Student student = null;
        try {
//          select * from student limit(curPage-1)*pageSize,pageSize;   (?-1)*
            String sql = "select * from student limit ?,?";
            Object[] params = {(currentPage-1)*pageSize,pageSize};
            resultSet = DBUtil.executeQuery(sql,params);
            List<Student> students = new ArrayList<>();
            while (resultSet.next()) {
                String sclass = resultSet.getString("sclass");
                int no = resultSet.getInt("sno");
                String name = resultSet.getString("sname");
                Double grade=resultSet.getDouble("sgrade");
                int age = resultSet.getInt("sage");
                String address = resultSet.getString("saddress");
                student=new Student(sclass,no,name,grade,age,address);
                students.add(student);
            }
            return students;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            DBUtil.closeException(DBUtil.connection, resultSet, DBUtil.preparedStatement);
        }
    }


//    public static void main(String[] args) {
//        StudentDaoImpl studentDao=new StudentDaoImpl();
//        List<Student> students=studentDao.queryStudentByPage(1,2);
//        System.out.println(students);
//    }

// 模糊查询学生信息
    public List<Student> mhQueryStudent(String keyWord){
        ResultSet resultSet=null;
        List<Student> students=new ArrayList<>();
        Student student=null;
        try {
            String sql="select * from student where sname like ?";
            Object params[]={"%"+keyWord+"%"};
            resultSet = DBUtil.executeQuery(sql, params);
            while (resultSet.next()){
                String sclass = resultSet.getString("sclass");
                int no = resultSet.getInt("sno");
                String name = resultSet.getString("sname");
                Double grade=resultSet.getDouble("sgrade");
                int age=resultSet.getInt("sage");
                String address=resultSet.getString("saddress");
                student=new Student(sclass,no,name,grade,age,address);
                students.add(student);
            }
            return students;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }finally {
            DBUtil.closeException(DBUtil.connection,resultSet,DBUtil.preparedStatement);
        }
    }
}
