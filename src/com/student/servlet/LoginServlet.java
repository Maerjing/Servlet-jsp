package com.student.servlet;

import com.student.entity.LoginUsers;
import com.student.service.impl.LoginServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "LoginServlet", value = "/LoginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String uname = req.getParameter("uname");
        String upwd = req.getParameter("upwd");
        LoginServiceImpl loginServiceImpl = new LoginServiceImpl();
        LoginUsers loginUsers=new LoginUsers(uname,upwd);
        boolean result = loginServiceImpl.queryLogin(loginUsers.getUname(),loginUsers.getUpwd());
        resp.setContentType("text/html;charset=utf-8");
        resp.setCharacterEncoding("utf-8");
        if (result) {
            resp.sendRedirect("QueryStudentByPageServlet");
        } else {
            resp.sendRedirect("login.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
