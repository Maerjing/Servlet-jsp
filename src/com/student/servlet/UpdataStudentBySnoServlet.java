package com.student.servlet;

import com.student.entity.Student;
import com.student.service.IStudentService;
import com.student.service.impl.StudentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "UpdataStudentBySnoServlet", value = "/UpdataStudentBySnoServlet")
public class UpdataStudentBySnoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        req.setCharacterEncoding("utf-8");
        String sclass=req.getParameter("sclass");
        int no = Integer.parseInt(req.getParameter("sno"));
        String name = req.getParameter("sname");
        Double grade=Double.parseDouble(req.getParameter("sgrade"));
        int age = Integer.parseInt(req.getParameter("sage"));
        String address = req.getParameter("saddress");
        Student student = new Student(sclass,no,name, grade,age, address);
        IStudentService studentService = new StudentServiceImpl();
        boolean result = studentService.updataStudent(no,student);
//        resp.setContentType("text/html;charset=utf-8");
//        req.setCharacterEncoding("utf-8");
        PrintWriter out = resp.getWriter();
        if (result){
            resp.sendRedirect("QueryStudentByPageServlet");
        }else {
            out.println("修改失败!");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
