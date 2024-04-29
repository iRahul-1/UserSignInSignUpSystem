<%@page import="com.userlogin.app.UserBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>View User</title>
    <style>
        .container {
            margin: 20px;
        }
        table {
            border-collapse: collapse;
            width: 100%;
            box-shadow: 1px 1px 5px rgba(0, 0, 0, 0.2);
        }
        th, td {
            border: 1px solid #dddddd;
            text-align: left;
            padding: 8px;
        }
        th {
            background-color: #f2f2f2;
        }
        tr:nth-child(even) {
            background-color: #f9f9f9; 
        }
        .nav-links {
            margin-top: 20px;
        }
        .nav-links a {
            margin-right: 10px;
            text-decoration: none;
            color: black;
            font-weight: bold; 
            transition: color 0.3s ease; 
        }
        .nav-links a:hover {
            color: white; 
        }
        .button {
            display: inline-block;
            padding: 10px 20px;
            background-color: green;
            color: white;
            text-decoration: none;
            border-radius: 5px;
            font-weight: bold;
            transition: opacity 0.3s ease; 
        }
        
    </style>
</head>
<body>
<div class="container">
    <%
        UserBean ub = (UserBean)application.getAttribute("ubean");
        String uname = (String)request.getAttribute("msg");
        out.println("User: " + uname + "<br>");
    %>
    <table border="1">
        <tr>
            <th>User Name</th>
            <th>Phone Number</th>
            <th>Mail ID</th>
            <th>Address</th>
        </tr>
        <tr>
            <td><%= ub.getUsername() %></td>
            <td><%= ub.getPhone() %></td>
            <td><%= ub.getEmail() %></td>
            <td><%= ub.getAddress() %></td>
        </tr>
    </table>
    <div class="nav-links">
        <a href="edit" class="button">Update Profile</a>
        <a href="logout" class="button">Log Out</a>
    </div>
</div>
</body>
</html>
