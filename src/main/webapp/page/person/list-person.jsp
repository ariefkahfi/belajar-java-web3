<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List Person Data</title>
</head>
<body>




    <table>
        <tr>
            <td>Kode Person</td>
            <td>Nama Person</td>
            <td>Gender</td>
            <td>Delete</td>
            <td>Update</td>
        </tr>
        <c:forEach items="${data}" var="it">
            <tr>
                <td><c:out value="${it.kode}"></c:out></td>
                <td><c:out value="${it.nama}"></c:out></td>
                <td><c:out value="${it.gender}"></c:out></td>
                <td><a href="/arief/person/list/delete?kode=${it.kode}">Delete</a></td>
                <td><a href="/arief/person/list/update?kode=${it.kode}">Update</a></td>
            </tr>
        </c:forEach>
    </table>


</body>
</html>
