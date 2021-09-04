<%@ page import="com.student.entity.Student" %>
<%@ page import="java.util.List" %>
<%@ page import="javax.swing.*" %>
<%@ page import="com.student.entity.LoginUsers" %>
<%@ page import="com.student.service.ILoginService" %>
<%@ page import="com.student.service.impl.LoginServiceImpl" %><%--
  Created by IntelliJ IDEA.
  User: 86176
  Date: 2021/4/23
  Time: 19:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<html lang="en">--%>
<%--<head>--%>
<%--    <meta charset="UTF-8">--%>
<%--    <title>登录注册</title>--%>

<%--    <link rel="stylesheet" href="css/style.css" rel="stylesheet"/>--%>

<%--</head>--%>
<%--<body>--%>
<%--<div class="form-structor">--%>
<%--    <form action="AddLoginUserServlet" method="post">--%>
<%--        <div class="signup">--%>
<%--            <h2 class="form-title" id="signup"><span>或</span>新用户注册</h2>--%>
<%--            <div class="form-holder">--%>
<%--                <input type="text" class="input" placeholder="用户名" name="uname"/>--%>
<%--                <input type="password" class="input" placeholder="密码" name="upwd"/>--%>
<%--            </div>--%>
<%--            <button class="submit-btn">注册</button>--%>
<%--        </div>--%>
<%--    </form>--%>

<%--    <form action="LoginServlet" method="post">--%>
<%--        <div class="login slide-up">--%>
<%--            <div class="center">--%>
<%--                <h2 class="form-title" id="login"><span>或</span>登录</h2>--%>
<%--                <div class="form-holder">--%>
<%--                    <input type="text" class="input" placeholder="用户名" name="uname"/>--%>
<%--                    <input type="password" class="input" placeholder="密码" name="upwd"/>--%>
<%--                </div>--%>
<%--                <button class="submit-btn">登录</button>--%>
<%--            </div>--%>
<%--        </div>--%>
<%--    </form>--%>
<%--</div>--%>
<%--<script src="js/script.js"></script>--%>
<%--<script src="js/Login.js"></script>--%>
<%--</body>--%>
<%--</html>--%>


<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>学生信息管理系统</title>
    <link rel="stylesheet" href="css/style.css" rel="stylesheet" />
    <link rel="stylesheet" href="css/FirstPage.css" rel="stylesheet" />
</head>

<body>
<div class="wrapper">
    <!--背景图片-->
    <div id="web_bg" style="background-image: url(img/background.jpg);"></div>
    <!--其他代码 ... -->
    <div class="form-structor">
        <form action="LoginServlet" method="post">
            <div class="signup">
                <h2 class="form-title" id="signup"><span>或</span>登录</h2>
                <div class="form-holder">
                    <input type="text" class="input" placeholder="用户名" name="uname"/>
                    <input type="password" class="input" placeholder="密码" name="upwd"/>
                </div>
                <button class="submit-btn">登录</button>
            </div>
        </form>

        <form action="AddLoginUserServlet" method="post">
            <div class="login slide-up">
                <div class="center">
                    <h2 class="form-title" id="login"><span>或</span>新用户注册</h2>
                    <div class="form-holder">
                        <input type="text" class="input" placeholder="用户名" name="uname"/>
                        <input type="password" class="input" placeholder="密码" name="upwd"/>
                    </div>
                    <button class="submit-btn">注册</button>
                </div>
            </div>
        </form>
    </div>
</div>
<script src="js/script.js"></script>

</body>
</html>
