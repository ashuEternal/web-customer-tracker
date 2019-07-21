<%--
  Created by IntelliJ IDEA.
  User: Ashu
  Date: 26-06-2019
  Time: 23:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>List Customers</title>
    <link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">

</head>
<body>

    <div id="wrapper">
        <div id="header">
            <h2>Customer Relationship Manager</h2>
        </div>
    </div>

    <div id="container">
        <div id="content">

            <input type="button" value="Add Customer" onclick="window.location.href='showFormForAdd';return false" class="add-button"/>
        <table>
            <tr>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Email</th>
                <th>Action</th>
            </tr>
            <c:forEach var="cust" items="${customers}">

                <c:url value="/customer/showFormForUpdate" var="updateLinnk">
                    <c:param name="customerId" value="${cust.id}"/>
                </c:url>
                <c:url value="/customer/delete" var="deleteLink">
                    <c:param name="customerId" value="${cust.id}"/>
                </c:url>
                
                <tr>
                    <td>${cust.firstName}</td>
                    <td>${cust.lastName}</td>
                    <td>${cust.email}</td>

                    <td>
                        <a href="${updateLinnk}">Update</a>
                        |
                        <a href="${deleteLink}" onclick="if (!(confirm('Are you sure you want to delete this Customer?'))) return false">Delete</a>
                    </td>
                </tr>

            </c:forEach>


        </table>
        </div>
    </div>

</body>
</html>
