<%@ page import="com.student.entity.Student" %><%--
  Created by IntelliJ IDEA.
  User: 86176
  Date: 2021/4/13
  Time: 11:09
  To change this template use File | Settings | File Templates.
--%>
<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
    <title>修改学生信息</title>
</head>
<body>
<%
    Student student =(Student) request.getAttribute("student");
%>
<form action="UpdataStudentBySnoServlet" method="post">
    班级：<input type="text" name="sclass" value="<%=student.getSclass()%>"/></br>
    学号：<input type="text" name="sno" value="<%=student.getSon()%>" readonly="readonly"/></br>
    姓名：<input type="text" name="sname" value="<%=student.getSname()%>"/></br>
    成绩：<input type="text" name="sgrade" value="<%=student.getSgrade()%>" /></br>
    年龄：<input type="text" name="sage" value="<%=student.getSage()%>"/></br>
    地址：<input type="text" name="saddress" value="<%=student.getSaddress()%>"/></br>
    <input type="submit" value="确认修改">
</form>
<form action="QueryStudentByPageServlet" method="post">
    <input type="submit" value="返回">
</form>
</body>
</html>
