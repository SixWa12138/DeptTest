<%--
  Created by IntelliJ IDEA.
  User: 88
  Date: 2022/11/28
  Time: 19:11
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<c:forEach items="${sessionScope.queryOneList}" var="dept">
    <form action="ts?i=5&deptno=${dept.deptno}" method="post" style="color: cornflowerblue">
        <h3 style="color: cornflowerblue">修改</h3>
        <table>
            <tr>
                <td>部门编号：</td>
                <td><input type="text" name="deptno" value="${dept.deptno}" readonly></td>
            </tr>
            <tr>
                <td>部门名称：</td>
                <td><input type="text" name="dname" placeholder="${dept.dname}" value="${dept.dname}"></td>
            </tr>
            <tr>
                <td>部门地址：</td>
                <td><input type="text" name="loc" placeholder="${dept.loc}" value="${dept.loc}"></td>
            </tr>
        </table>
        <input type="submit" value="修改">
    </form>
</c:forEach>
</body>
</html>
