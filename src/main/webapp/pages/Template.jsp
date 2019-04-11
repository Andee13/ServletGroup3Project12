<%--
  Created by IntelliJ IDEA.
  User: Андрей
  Date: 28.03.2019
  Time: 11:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>SumDU university</title>
</head>
<body>
    <div>Header
    Welcome, <%=request.getSession().getAttribute("username")%>!
        <a href="/dispatcher?action= logout">Exit</a>
    </div>
    <div>Menu:
    <a href="/dispatcher?action=showAllStudents"></a>
    </div>
    <div>Body
    <% String includedJspPage = (String) request.getSession().getAttribute("username");
    %>
        <%
        if(includedJspPage != null){


        %>
        <jsp:include page=""></jsp:include>
        <%}%>
    </div>
    <div>Footer</div>


</body>
</html>
