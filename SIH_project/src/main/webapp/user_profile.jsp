<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
 
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <title>User Profile</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f6f7f8;
            margin: 0;
            padding: 0;
        }
        .head{
           text-align: center;
        }

        h1, h2 {
            color: black;
        }

        ul {
            list-style-type: none;
            padding: 0;
        }

        li {
            margin-bottom: 10px;
        }

        li strong {
            font-weight: bold;
            margin-right: 5px;
        }

        .profile-container {
            max-width: 800px;
            margin: 0 auto;
            background-color: #fff;
            border-radius: 5px;
            padding: 20px;
            box-shadow: 0px 2px 5px rgba(0, 0, 0, 0.2);
        }

        /* Style for uploaded file names */
        .uploaded-file {
            background-color: #f2f2f2;
            padding: 5px 10px;
            border-radius: 5px;
            display: inline-block;
        }

        .logo-container {
            display: flex;
            align-items: center;
            margin-left: 20px;
        }

        .text-container {
            margin-left: 20px; /* Adjust the margin as needed to separate the logo and text */
        }

        .navbar-nav .nav-link {
            font-size: 18px; /* Adjust the font size as needed */
        }

        .navbar-nav .nav-item {
            margin-right: 20px; /* Adjust the margin as needed to create space between list items */
        }
    </style>
</head>
<body>
    <header>
        <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
            <a class="navbar-brand" href="#">
                <div class="logo-container">
                    <img src="Jharkhand_logo.png" alt="logo" width="90" height="90" class="d-none d-sm-block mx-auto">
                    <img src="Jharkhand_logo.png" alt="logo" width="60" height="60" class="d-sm-none mx-auto">
                    <div class="text-container">
                        <span>Government Of Jharkhand</span><br>
                        <span>Student Portal</span>
                    </div>
                </div>
            </a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav"
                aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNav">
                <ul class="navbar-nav ml-auto">
                    <li class="nav-item">
                        <a class="nav-link" href="index.html">Home</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="login.html">Sign In</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="signup.html">Sign Up</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="aboutus.html">About Us</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="help.html">Help</a>
                    </li>
                </ul>
            </div>
        </nav>
    </header>
    <br>
    <div class="profile-container">
        <h1  class="head">User Profile</h1>
        <br>
        <h2>User Details</h2>
        <ul>
            <li><strong>Name:</strong> <c:out value="${userName}" /></li>
            <li><strong>College Registration No.:</strong> <c:out value="${clgregno}" /></li>
            <li><strong>Organization:</strong> <c:out value="${org}" /></li>
            <li><strong>College Gmail:</strong> <c:out value="${clgmail}" /></li>
            <li><strong>Personal Email:</strong> <c:out value="${pmail}" /></li>
            <li><strong>Gender:</strong> <c:out value="${gender}" /></li>
            <li><strong>Date of Birth:</strong> <c:out value="${dob}" /></li>
            <li><strong>Highest Qualification:</strong> <c:out value="${hqualification}" /></li>
            <li><strong>Year of Graduation:</strong> <c:out value="${yOG}" /></li>
            <li><strong>Pincode:</strong> <c:out value="${pincode}" /></li>
            <li><strong>State:</strong> <c:out value="${state}" /></li>
            <li><strong>District:</strong> <c:out value="${district}" /></li>
            <li><strong>Current Year:</strong> <c:out value="${currentyear}" /></li>
            <li><strong>Department:</strong> <c:out value="${dep}" /></li>
            <li><strong>Degree:</strong> <c:out value="${degree}" /></li>
            <!-- Add more details as needed -->
        </ul>
        <br>
        <h2>Uploaded Files</h2>
        <ul>
            <c:forEach var="fileName" items="${fileNames}">
                <li><span class="uploaded-file"><c:out value="${fileName}" /></span></li>
            </c:forEach>
        </ul>
    </div>
</body>
</html>
