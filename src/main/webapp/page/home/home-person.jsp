<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home Page of Person</title>
</head>
<style>
    a{
        display: block;
        margin-bottom : 20px;
        text-decoration: none;
    }
</style>
<body>

<div>

    <%
        String pesan = (String)request.getAttribute("pesan");

        if(pesan!=null){
            response.setContentType("text/html");
            response.getWriter().write("<h2>"+pesan+"</h2>");
        }
    %>


    <a href="/arief/register/person">Registrasi Person</a>
    <a href="/arief/person/login">Login Person</a>
    <a href="/arief/person/list">List Person</a>
</div>

</body>

</html>
