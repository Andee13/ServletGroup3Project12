<%@ page import="java.util.List" %>
<%@ page import="com.berest.oleg.model.Student" %><%--
  Created by IntelliJ IDEA.
  User: Андрей
  Date: 28.03.2019
  Time: 12:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

    <%
        List<Student> listOfStudents = request.getSession().getAttribute("listOfAllStudents");
    %>
    <p>
        <% for (int i = 0; i < listOfStudents.size(); i++) {%>

            <input type="checkbox" name="students" id="<%="student" + i%>" value="<%listOfStudents.get(i).getId();%>"/>
            <%=listOfStudents.get(i).getName()%><br>
        <%        }%>
    </p>

</body>
</html>
