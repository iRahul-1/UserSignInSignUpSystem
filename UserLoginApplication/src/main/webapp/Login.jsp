<%@page import="com.userlogin.app.UserBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>User Profile</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f2f2f2;
            margin: 0;
            padding: 0;
        }
        .container {
            max-width: 600px;
            margin: 50px auto;
            padding: 40px;
            background-color: #fff;
            border-radius: 8px;
            box-shadow: 0 0 10px 0px #04AA6D;
        }
        .welcome-msg {
            font-size: 24px;
            margin-bottom: 20px;
            color: #333;
            text-align: center;
        }
        .nav-links {
            margin-bottom: 20px;
            text-align: center;
        }
        .nav-links a {
            display: inline-block;
            margin-right: 10px;
            text-decoration: none;
            color: #333;
            padding: 10px 20px;
            border: 2px solid #04AA6D;
            border-radius: 6px;
            transition: background-color 0.3s, color 0.3s;
        }
        .nav-links a:hover {
            background-color: #04AA6D;
            color: #fff;
        }
        .profile-info {
            padding: 20px;
            background-color: #f9f9f9;
            border-radius: 6px;
            box-shadow: 0 0 5px 0px #ccc;
            margin-bottom: 20px;
        }
        .profile-info h2 {
            font-size: 20px;
            margin-bottom: 10px;
            color: #333;
        }
        .profile-info p {
            font-size: 16px;
            color: #666;
            line-height: 1.5;
        }
    </style>
</head>
<body>
    <div class="container">
     <%
            UserBean ub = (UserBean)application.getAttribute("ubean");
        %>
        <div class="welcome-msg">
            Welcome, <%= ub.getUsername() %>!
        </div>
        <div class="profile-info">
            <h2>User Profile Information</h2>
            <p><strong>Name:</strong> <%= ub.getUsername() %></p>
            <p><strong>Email:</strong> <%= ub.getEmail() %></p>
        </div>
        <div class="nav-links">
            <a href="View">View Profile</a>
            <a href="logout">Log Out</a>
        </div>
    </div>
</body>
</html>
