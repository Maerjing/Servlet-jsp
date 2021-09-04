<%@ page import="java.util.List" %>
<%@ page import="com.student.entity.Student" %><%--
  Created by IntelliJ IDEA.
  User: 86176
  Date: 2021/4/22
  Time: 11:07
  To change this template use File | Settings | File Templates.
--%>
<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table>
    <tr>
        <th>班级</th>
        <th>学号</th>
        <th>姓名</th>
        <th>成绩</th>
        <th>年龄</th>
        <th>地址</th>
        <th>操作</th>
    </tr>
    <%
        List<Student> students = (List<Student>) request.getAttribute("students");
        for (Student student : students) {
    %>
    <tr>
        <td><%=student.getSclass()%>
        </td>
        <td><%=student.getSon()%>
        </td>
        <td><%=student.getSname()%>
        </td>
        <td><%=student.getSgrade()%>
        </td>
        <td><%=student.getSage()%>
        </td>
        <td><%=student.getSaddress()%>
        </td>
    </tr>
    <%
        }
    %>
</table>
<a href="QueryStudentByPageServlet">返回主页</a>
</body>
</html>
