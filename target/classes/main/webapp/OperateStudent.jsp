<%@ page import="com.student.entity.Page" %>
<%@ page import="com.student.entity.Student" %><%--
  Created by IntelliJ IDEA.
  User: 86176
  Date: 2021/4/26
  Time: 9:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>学生信息管理系统</title>
    <link rel="stylesheet" href="./css/zhuye.css" type="text/css"/>
</head>
<body>
<%--<div class="biaoti">--%>
<%--<h1>学生信息管理系统</h1>--%>
<%--</div>--%>
<!--main_top-->
<table width="99%" border="0" cellspacing="0" cellpadding="0" id="searchmain">
    <tr>
        <td width="99%" align="left" valign="top">用户权限：管理员</td>
    </tr>
    <tr>
        <td align="left" valign="top">
            <table width="100%" border="0" cellspacing="0" cellpadding="0" id="search">
                <tr>
                    <td width="90%" align="left" valign="middle">
                        <form action="MhQueryStudentServlet" method="post"><span>查询学生：</span><input type="text"
                                                                                                   name="word"
                                                                                                   class="text-word"><input
                                type="submit" value="查询" class="text-but">
                        </form>
                    </td>
                    <td width="10%" align="center" valign="middle" style="text-align:right; width:150px;"><a
                            href="addstudent.jsp" target="mainFrame" onFocus="this.blur()" class="add">添加学生</a></td>&nbsp;&nbsp;
                    <td width="10%" align="center" valign="middle" style="text-align:right; width:150px;"><a
                            href="login.jsp" target="mainFrame" onFocus="this.blur()" class="add">退出系统</a></td>
                </tr>
            </table>
        </td>
    </tr>
    <tr>
        <td align="left" valign="top">
            <table width="100%" border="0" cellspacing="0" cellpadding="0" id="main-tab">
                <tr>
                    <th align="center" valign="middle" class="borderright">班级</th>
                    <th align="center" valign="middle" class="borderright">学号</th>
                    <th align="center" valign="middle" class="borderright">姓名</th>
                    <th align="center" valign="middle" class="borderright">成绩</th>
                    <th align="center" valign="middle" class="borderright">年龄</th>
                    <th align="center" valign="middle" class="borderright">地址</th>
                    <th align="center" valign="middle">操作</th>
                </tr>
                <%
                    Page page1 = (Page) request.getAttribute("p1");
                    for (Student student : page1.getStudents()) {
                %>
                <tr onMouseOut="this.style.backgroundColor='#ffffff'"
                    onMouseOver="this.style.backgroundColor='#edf5ff'">
                    <td align="center" valign="middle" class="borderright borderbottom"><%=student.getSclass()%>
                    </td>
                    <td align="center" valign="middle" class="borderright borderbottom"><a
                            href="QueryStudentByNoServlet?sno=<%=student.getSon()%>"><%=student.getSon()%>
                    </a></td>
                    <td align="center" valign="middle" class="borderright borderbottom"><%=student.getSname()%>
                    </td>
                    <td align="center" valign="middle" class="borderright borderbottom"><%=student.getSgrade()%>
                    </td>
                    <td align="center" valign="middle" class="borderright borderbottom"><%=student.getSage()%>
                    </td>
                    <td align="center" valign="middle" class="borderright borderbottom"><%=student.getSaddress()%>
                    </td>
                    <td align="center" valign="middle" class="borderbottom"><a
                            href="QueryStudentByNoServlet?sno=<%=student.getSon()%>"
                            target="mainFrame" onFocus="this.blur()" class="add">编辑</a><span
                            class="gray">&nbsp;|&nbsp;</span><a
                            href="DelectStudentBySonServlet?sno=<%=student.getSon()%>" target="mainFrame"
                            onFocus="this.blur()" class="add">删除</a></td>
                </tr>
                <%
                    }
                %>
            </table>
        </td>
    </tr>


    <tr>
        <td align="left" valign="top" class="fenye">总共：<%=page1.getTotalCount()%>条数据 &nbsp;&nbsp;
            <%=page1.getCurrentPage()%>/<%=page1.getTotalPage()%> 页&nbsp;&nbsp;
    <%
        if (page1.getCurrentPage() == 1) {
    %>
            <a href="QueryStudentByPageServlet?currentPage=<%=page1.getCurrentPage()+1%>" target="mainFrame" onFocus="this.blur()">下一页</a>&nbsp;&nbsp;
            <a href="QueryStudentByPageServlet?currentPage=<%=page1.getTotalCount()/page1.getPageSize()+1%>" target="mainFrame" onFocus="this.blur()">尾页</a>
            <%
            }else if (page1.getCurrentPage() == page1.getTotalCount()/page1.getPageSize()+1) {
            %>
            <a href="QueryStudentByPageServlet?currentPage=1" target="mainFrame" onFocus="this.blur()">首页</a>&nbsp;&nbsp;
            <a href="QueryStudentByPageServlet?currentPage=<%=page1.getCurrentPage()-1%>" target="mainFrame" onFocus="this.blur()">上一页</a>&nbsp;&nbsp;
            <%
            }else {
            %>
            <a href="QueryStudentByPageServlet?currentPage=1" target="mainFrame" onFocus="this.blur()">首页</a>&nbsp;&nbsp;
            <a href="QueryStudentByPageServlet?currentPage=<%=page1.getCurrentPage()-1%>" target="mainFrame" onFocus="this.blur()">上一页</a>&nbsp;&nbsp;
            <a href="QueryStudentByPageServlet?currentPage=<%=page1.getCurrentPage()+1%>" target="mainFrame" onFocus="this.blur()">下一页</a>&nbsp;&nbsp;
            <a href="QueryStudentByPageServlet?currentPage=<%=page1.getTotalCount()/page1.getPageSize()+1%>" target="mainFrame" onFocus="this.blur()">尾页</a>
            <%
                }
            %>
        </td>
    </tr>
</table>
</body>
</html>