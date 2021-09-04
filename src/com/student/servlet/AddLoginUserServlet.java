package com.student.servlet;

import com.student.entity.LoginUsers;
import com.student.service.ILoginService;
import com.student.service.impl.LoginServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.*;
import java.io.IOException;

@WebServlet(name = "AddLoginUserServlet", value = "/AddLoginUserServlet")
public class AddLoginUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=UTF-8");

        String name = req.getParameter("uname");
        String pwd = req.getParameter("upwd");
        LoginUsers loginUsers = new LoginUsers(name, pwd);
        ILoginService loginService = new LoginServiceImpl();
        boolean isHave = loginService.queryLogin(loginUsers.getUname(), loginUsers.getUpwd());
        req.setAttribute("isHave", isHave);
        req.getRequestDispatcher("login.jsp").forward(req, resp);
        if (!isHave) {
            loginService.addLoginUser(loginUsers);
            JOptionPane.showMessageDialog(null, "注册成功！o(*￣▽￣*)ブ");
        } else {
            JOptionPane.showMessageDialog(null, "用户名和密码已存在！~~>_<~~");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
