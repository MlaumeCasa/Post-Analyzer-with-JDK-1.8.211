<%-- 
    Document   : analyze_post_outcome
    Created on : 09 May 2025, 12:20:06 PM
    Author     : Tk
--%>

<%@page import="za.ac.tut.entities.Post"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Analyze Post Outcome Page</title>
    </head>
    <body>
        <h1>Analyze Post Outcome</h1>
        <%
            Post post = (Post)request.getSession().getAttribute("post");
        %>
        <p>
            Post Analysis Summary: 
        </p>
        
        <table>
            <tr>
                <td>Post ID</td>
                <td><%= post.getId() %></td>
            </tr>
            
            <tr>
                <td>User ID</td>
                <td><%= post.getUserid()%></td>
            </tr>

            <tr>
                <td>Content Description</td>
                <td><%= post.getContent()%></td>
            </tr>

            <tr>
                <td>Predicated Score</td>
                <td><%= post.getPredicatedScore()%></td>
            </tr>

            <tr>
                <td>Actual Score</td>
                <td><%= post.getActualScore()%></td>
            </tr>
            
        </table>
        
    </body>
</html>
