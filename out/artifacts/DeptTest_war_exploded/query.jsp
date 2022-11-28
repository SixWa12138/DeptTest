<%--
  Created by IntelliJ IDEA.
  User: 88
  Date: 2022/11/28
  Time: 19:10
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
    <script type="text/javascript">
        function removeShow() {
            var boo = window.confirm("确定删除么？");
            if (boo){
                alert("删除成功");
            }else {
                alert("取消删除");
            }
            return boo;
        }
    </script>
</head>
<body>
<table>
    <tr>
        <td colspan="2">部门编号</td>
        <td colspan="2">部门名称</td>
        <td colspan="2">部门地址</td>
        <td colspan="4">操作</td>
    </tr>
    <c:forEach items="${sessionScope.queryAllList}" var="dept">
        <tr>
            <td>${dept.deptno}<td/>
            <td>${dept.dname}<td/>
            <td>${dept.loc}<td/>
            <td><a href="ts?i=4&deptno=${dept.deptno}" onclick="return removeShow();">删除<a/>&nbsp
                <a href="ts?i=6&deptno=${dept.deptno}&dname=${dept.dname}">修改<a/><td/>
        <tr/>
    </c:forEach>
</table>
</body>
</html>
