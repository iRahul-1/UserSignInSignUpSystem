<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="com.userlogin.app.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f9f9f9;
        }
        form {
            max-width: 400px;
            margin: 0 auto;
            padding: 20px;
            background-color: #ffffff;
            border-radius: 5px;
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
        }
        input[type="text"] {
            width: 100%;
            padding: 10px;
            margin-bottom: 15px;
            border: 1px solid #ccc;
            border-radius: 3px;
        }
        input[type="submit"] {
            background-color: #007bff;
            color: #ffffff;
            border: none;
            padding: 10px 20px;
            border-radius: 3px;
            cursor: pointer;
        }
        input[type="submit"]:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>
<%
UserBean ub = (UserBean)application.getAttribute("ubean");
String fName = (String)request.getAttribute("name");
out.println("Page belongs to : "+fName+"<br>");
%>
<form action="newdata" method="post">
        <h2>Update Profile</h2>
        <label for="addr">Address:</label>
        <input type="text" name="addr" value="<%=ub.getAddress() %>">
        <br>
        <label for="mid">MailId:</label>
        <input type="text" name="mid" value="<%=ub.getEmail() %>">
        <br>
        <label for="phno">PhoneNo:</label>
        <input type="text" name="phno" value="<%=ub.getPhone() %>">
        <br>
        <input type="submit" value="Update Profile">
    </form>
</body>
</html>
