<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="javax.servlet.RequestDispatcher" %>
<%@ page import="Beans.Student" %>
<%@ page import="Beans.EnrollBean" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Student Information</title>
</head>
<body>
   <h1>Student Information</h1>
    <%
        ArrayList<Student> std = (ArrayList<Student>) session.getAttribute("stuInfo");
        if (std != null && !std.isEmpty()) {
            for (Student student : std) {
    %>
            <p>Name: <%= student.getFname() %> <%= student.getLname() %></p>
            <p>Phone: <%= student.getPhone() %></p>
                <hr>
    <%
            }
        } else {
    %>
            <p>No student information found.</p>
    <%
        }
    %>
    
    
    <h1>My Classes</h1>
<table border="1">
    <tr>
        <th>Course ID</th>
        <th>Title</th>
        <th>Grade</th>
    </tr>
    <% 
        ArrayList<EnrollBean> enrollments = (ArrayList<EnrollBean>) session.getAttribute("enrInfo");
        if (enrollments != null) {
            for (EnrollBean enrollment : enrollments) {
    %>
                <tr>
                    <td><%= enrollment.getCourseID() %></td>
                    <td><%= enrollment.getTitle() %></td>
                    <td><%= enrollment.getGrade() %></td>
                </tr>
    <% 
            }
        }
    %>
</table>

    <table>
        <tr>
            <td>
                <form action="registLogin.jsp" method="post">
                    <button type="submit">Exit</button>
                </form>
            </td>
            <td>
                <form action="Exit" method="post">
                    <input type="hidden" name="redirect" name="redirect">
                    <button type="submit">Enroll</button>
                </form>
            </td>
        </tr>
    </table>
    
    
</body>
</html>
