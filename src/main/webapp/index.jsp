<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.*,com.example.bankcrudjee.dao.UserDao" %>
<%@ page import="com.example.bankcrudjee.model.User" %>
<%@ page import="com.example.bankcrudjee.connection.connection.connect" %>
<%@ page import="java.sql.Connection" %>
<link rel="stylesheet"
      href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
      integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
      crossorigin="anonymous">



<div class="container">

    <table class="table table-striped table-dark">
        <thead >
        <tr>
            <th><a href="/contrServlet">Liste Et Suprimer</a></th>
            <th><a href="insertEntreprise.jsp">Insert Entreprise</a></th>
            <th><a href="insertPersonel.jsp">Insert Presone</a></th>
            <th><a href="update.jsp">update</a></th>
        </tr>
        </thead>
        <tbody>
        <%

            List<User> x= (List<User>) request.getAttribute("users");
        %>
        <c:forEach var="compte" items="${x}">

            <tr>
                <td><c:out value="${x.user_id}" /></td>
                <a href="delete?id=<c:out value='${x.user_id}' />">Delete</a>

            </tr>
        </c:forEach>

        </tbody>

    </table>
</div>