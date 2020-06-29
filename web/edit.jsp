<%--
  Created by IntelliJ IDEA.
  User: suman
  Date: 6/17/2020
  Time: 11:32 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ page import="Employee.sqlcommands" %>
<%@ page import="Employee.Employee" %>

<%
    String id=request.getParameter("id");
    Employee e=new sqlcommands().getEmployeebyid(Integer.parseInt(id));
    System.out.println(e.getName());
%>

<html>
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <title>IT SUTRA</title>
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
    <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
</head>
<body>
<h1>   Welcome to my website</h1>

<style>
    body{
        background-image: url('https://cdn.kimkim.com/files/a/content_articles/featured_photos/050a89ea730f913b48cf7dea23719688bc3652fe/big-891ee83ca306656a3c388f949db9e72d.jpg');
        background-repeat: no-repeat;
        background-attachment: fixed;
        background-size: cover;
    }
    h1{text-align: center}


</style>

<form method="post" action="/editServlet" >
    <div class="sidenav">
        <div class="login-main-text">
            <h2>Edit Page</h2>
            <p>Please change the entry as you like.</p>
        </div>
    </div>

    <div align="center">
        <div class="main" >
            <div class="col-md-6 col-sm-12">
                <div class="edit-form">
                    <form>
                        <div class="form-group1">
                            <label>Id</label>
                            <input type="text" class="form-control" name="Id" placeholder="User id" readonly value=<%=e.getId()%>>
                        </div>
                        <div  class="form-group">
                            <label>Name </label>
                            <input type="text" class="form-control" name="Name" placeholder="Name" value="<%=e.getName()%>">
                        </div>
                        <div  class="form-group">
                            <label>address </label>
                            <input type="text" class="form-control" name="address" placeholder="address" value="<%=e.getAddress()%>">
                        </div>
                        <button type="submit" class="btn btn-black">Edit</button>
                    </form>
                </div>
            </div>
        </div>
    </div>

</form>
</body>

</html>
