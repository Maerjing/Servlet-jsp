package com.student.servlet;

import com.student.entity.LoginUsers;
import com.student.service.ILoginService;
import com.student.service.impl.LoginServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "QueryAllLoginUsersServlet", value = "/QueryAllLoginUsersServlet")
public class QueryAllLoginUsersServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=UTF-8");
        resp.setCharacterEncoding("utf-8");
        ILoginService loginService=new LoginServiceImpl();
        List<LoginUsers> loginUsers = loginService.queryAllLoginusers();
        req.setAttribute("loginUsers",loginUsers);
        req.getRequestDispatcher("AddLoginUserServlet").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
