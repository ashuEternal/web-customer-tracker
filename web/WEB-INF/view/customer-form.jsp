<%--
  Created by IntelliJ IDEA.
  User: Ashu
  Date: 27-06-2019
  Time: 13:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
    <title>Customer Form</title>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/add-customer-style.css">
</head>
<body>
       <div id="wrapper">
           <div id="header">

               <h2>CRM - Customer Relationship Manager</h2>

           </div>

       </div>

        <div id="container">
            <h3>Save Customer</h3>
            <form:form action="saveCustomer" modelAttribute="customer" method="POST">
                <form:hidden path="id"/>
                <table>
                    <tbody>
                        <tr>
                            <td><label>First Name:</label></td>
                            <td><form:input path="firstName"></form:input></td>
                        </tr>
                        <tr>
                            <td><label>Last Name:</label></td>
                            <td><form:input path="lastName"></form:input></td>
                        </tr>
                        <tr>
                            <td><label>Email:</label></td>
                            <td><form:input path="email"></form:input></td>
                        </tr>

                        <tr>
                            <td><label></label></td>
                            <td><input type="submit" value="Save" class="save"/> </td>
                        </tr>
                    </tbody>
                </table>
            </form:form>
            <a href="${pageContext.request.contextPath}/customer/list">Back to List</a>
        </div>

</body>
</html>
