<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <meta charset="utf-8">

    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/main.css" type="text/css">

    <title>
        Phones Book
    </title>
</head>
<body>
<table>
    <tr>
        <td>
            <table>
                <div class="dataFrame shortFrame">
                    <h1>
                        Save Contact
                    </h1>

                    <spring:form action="save-phones-book.html" method="post" modelAttribute="contact">

                        Name:
                        <br/>
                        <spring:input path="name"/>
                        <br/>
                        <br/>
                        Number:
                        <br/>
                        <spring:input path="number"/>
                        <br/>
                        <br/>
                        <input type="submit" name="save_btn" value="Save"/>

                    </spring:form>
                </div>
            </table>
        </td>
    </tr>
</table>

<div class="dataFrame largeFrame">
    <h1>
        Contacts List
    </h1>

    <table border="1" class="dataTable">
        <tr>
            <th class="dataColl">
                Name
            </th>
            <th class="dataColl">
                Number
            </th>
        </tr>

        <c:forEach items="${contactList}" var="contact">
            <tr>
                <td class="dataColl">
                        ${contact.name}
                </td>
                <td class="dataColl">
                        ${contact.number}
                </td>
            </tr>
        </c:forEach>
    </table>

    <br/>
    <hr/>
    <br/>


</div>
</body>
</html>
