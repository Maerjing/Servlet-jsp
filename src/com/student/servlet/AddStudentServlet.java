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

@WebServlet(name = "AddStudentServlet", value = "/AddStudentServlet")
public class AddStudentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("utf-8");
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        String sclass = request.getParameter("sclass");
        int no = Integer.parseInt(request.getParameter("sno"));
        String name = request.getParameter("sname");
        Double grade = Double.parseDouble(request.getParameter("sgrade"));
        int age = Integer.parseInt(request.getParameter("sage"));
        String address = request.getParameter("saddress");
        Student student = new Student(sclass, no, name, grade, age, address);
        IStudentService iStudentService = new StudentServiceImpl();
        boolean result = iStudentService.addStudent(student);
//        response.setContentType("text/html;charset=UTF-8");
//        response.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();
        response.sendRedirect("QueryStudentByPageServlet");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
