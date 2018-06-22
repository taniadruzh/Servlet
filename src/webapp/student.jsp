<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>com.DomObj.Student</title>
</head>
<body>
<br>
<form action="MainServlet" method="get">
    Male: <input type=radio name="gender" value="male"/>
    Female: <input type=radio name="gender" value="female"/>
    <input type="submit" value="Submit"/>
</form>
    <table border="2">
        <tr>
            <th>name</th>
            <th>sername</th>
            <th>gender</th>
            <th>phone</th>
        </tr>

<c:forEach var="student" items="${studList}">
    <tr>
        <td>${student.name}</td>
        <td>${student.surname}</td>
        <td>${student.gender}</td>
        <td>${student.phone}</td>
    </tr>
</c:forEach>
</table>
</br>
</br>
<table border="2">
    <tr>
        <th>name</th>
        <th>sername</th>
        <th>gender</th>
        <th>phone</th>
    </tr>
    <c:forEach var="student" items="${studentByGender}">
        <tr>
            <td>${student.name}</td>
            <td>${student.surname}</td>
            <td>${student.gender}</td>
            <td>${student.phone}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
