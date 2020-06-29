<%--
  Created by IntelliJ IDEA.
  User: suman
  Date: 6/15/2020
  Time: 1:37 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="com.mysql.cj.protocol.Resultset" %>
<%@ page import="java.sql.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>




<%

    String dbUser="root";
    String dbPass="root";
    String connString="jdbc:mysql://localhost:3306/demo_db?useSSL=false";
    String DRIVER_NAME="com.mysql.jdbc.Driver";
    Connection con= null;
    Statement stmt=null;
    try {
        Class.forName(DRIVER_NAME);
        con = DriverManager.getConnection(connString,dbUser,dbPass);
        stmt=con.createStatement();
    } catch (SQLException e) {
        e.printStackTrace();
    }


%>


<html>
<head>
    <title>Welcome!</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>
<style>
    body{
        background-image: url('https://cdn.kimkim.com/files/a/content_articles/featured_photos/050a89ea730f913b48cf7dea23719688bc3652fe/big-891ee83ca306656a3c388f949db9e72d.jpg');
        background-repeat: no-repeat;
        background-attachment: fixed;
        background-size: cover;
    }
</style>
<div class="container">
    <h1>Welcome to my website.</h1>
    <p>This is just an example page.</p>
    <p>It opens when you enter a valid login id.</p>
</div>


<table class="table">
    <thead class="thead-dark">
    <tr>
        <th scope="col">#</th>
        <th scope="col">Id</th>
        <th scope="col">Name</th>
        <th scope="col">Address</th>
    </tr>


    </thead>
    <tbody>
    <%
        int n=1;
        ResultSet rs=stmt.executeQuery("select * from demo_tbl");
        while(rs.next()) {

    %>
    <tr>
        <th scope="row"><%=n%></th>
        <td><%=rs.getString(1)%></td>
        <td><%=rs.getString("name")%></td>
        <td><%=rs.getString("address")%></td>
        <td><button type="button" class="btn btn-warning" onclick="document.location.href='edit.jsp?id='+<%=rs.getString(1)%>">EDIT</button></td>
        <td><button type="button" class="btn btn-warning" onclick="return cdocument.location.href='/deleteServlet?id='+<%=rs.getString(1)%>" >DELETE</button></td>
    </tr>

    <%
            n++;
        }
    %>


    </tbody>
</table>



</body>
</html>
