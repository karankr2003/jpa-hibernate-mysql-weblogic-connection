<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.practice.entity.SavingsAccount" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Data</title>
</head>
<body>
    <h1>Data View</h1>

    <table border="1">
        <tr>
            <th>ID</th>
            <th>Name</th>
        </tr>

        <%
            @SuppressWarnings("unchecked")
            List<SavingsAccount> accounts = (List<SavingsAccount>) request.getAttribute("accounts");

            if (accounts != null) {
                for (SavingsAccount account : accounts) {
        %>
            <tr>
                <td><%= account.getId() %></td>
                <td><%= account.getAccountNo() %></td>
            </tr>
        <%
                }
            } else {
        %>
            <tr>
                <td colspan="2">No accounts found.</td>
            </tr>
        <%
            }
        %>
    </table>
</body>
</html>
