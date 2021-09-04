package com.student.servlet;

import com.student.entity.Page;
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
@WebServlet(name = "QueryStudentByPageServlet",value = "/QueryStudentByPageServlet")
public class QueryStudentByPageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        IStudentService iStudentService=new StudentServiceImpl();
        Page p=new Page();
//        当前页
//        private int currentPage;
        String cPage=req.getParameter("currentPage");
        if (cPage==null){
            cPage="1";
        }
        int currentPage = Integer.parseInt(cPage);
        p.setCurrentPage(currentPage);
//        总数据数
//        private int totalCount;
        int totalCount=iStudentService.totalCount();
        p.setTotalCount(totalCount);
//        页面大小
//        private int pageSize;
        int pageSize=15;
        p.setPageSize(pageSize);

//        当前页的数据集合
//        private List<Student> students;
        List<Student> students = iStudentService.queryStudentByPage(currentPage, pageSize);
        p.setStudents(students);
        req.setAttribute("p1",p);
        req.getRequestDispatcher("OperateStudent.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
