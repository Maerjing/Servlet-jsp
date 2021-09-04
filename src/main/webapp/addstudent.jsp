<%--
  Created by IntelliJ IDEA.
  User: 86176
  Date: 2021/4/13
  Time: 10:55
  To change this template use File | Settings | File Templates.
--%>
<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
    <title>添加学生</title>
</head>
<body>
<form action="AddStudentServlet" method="post">
    班级：<input type="text" name="sclass"/></br>
    学号：<input type="text" name="sno"/></br>
    姓名：<input type="text" name="sname" /></br>
    成绩：<input type="text" name="sgrade"/></br>
    年龄：<input type="text" name="sage" /></br>
    地址：<input type="text" name="saddress" /></br>
    <input type="submit" value="提交">
</form>
</body>
</html>
