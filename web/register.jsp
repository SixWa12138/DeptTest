<%--
  Created by IntelliJ IDEA.
  User: 88
  Date: 2022/11/28
  Time: 19:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        table td{
            color: cornflowerblue;
            text-align: center;
        }
    </style>
</head>
<body>
<form action="emp" method="post" style="color: cornflowerblue">
    <h3 style="color: cornflowerblue">注册</h3>
    <table>
        <tr>
            <td>部门编号：</td>
            <td><input type="text" name="deptno"></td>
        </tr>
        <tr>
            <td>部门名称：</td>
            <td><input type="text" name="dname"></td>
        </tr>
        <tr>
            <td>部门地址：</td>
            <td><input type="text" name="loc"></td>
        </tr>
    </table>
    <input type="submit" value="注册">
</form>
</body>
</html>
