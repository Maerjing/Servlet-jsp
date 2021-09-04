package com.student.servlet;

import com.student.entity.Keyword;
import com.student.entity.Student;
import com.student.service.IStudentService;
import com.student.service.impl.StudentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "MhQueryStudentServlet",value = "/MhQueryStudentServlet")
public class MhQueryStudentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        req.setCharacterEncoding("utf-8");
        String word = req.getParameter("word");
        Keyword keyword=new Keyword(word);
        IStudentService iStudentService=new StudentServiceImpl();
        List<Student> students = iStudentService.moHuQuery(keyword.getKeyword());
//        System.out.println(students);
        req.setAttribute("students",students);
        req.getRequestDispatcher("queryStudentInfo.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
