<%--
  Created by IntelliJ IDEA.
  User: Андрей
  Date: 04.04.2019
  Time: 12:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isErrorPage="true" %>
<html>
<head>
    <title>Error page</title>
</head>
<body>
<%
    exception.printStackTrace(response.getWriter());
%>

</body>
</html>
