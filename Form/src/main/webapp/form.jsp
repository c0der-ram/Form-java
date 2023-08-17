<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>form</title>
<link href="style.css" rel="stylesheet" />
</head>
<body>
<div class="container">
  <form action="client" method = "post">

    <label for="fname">First Name</label>
    <input type="text" id="fname" name="firstname" placeholder="Your name..">

    <label for="lname">Last Name</label>
    <input type="text" id="lname" name="lastname" placeholder="Your last name..">
    
    <label for="emailid">Email</label>
    <input type="text" id="email" name="email" placeholder="Your email id..">

    <label for="mnumber">Mobile</label>
    <input type="text" id="mobile" name="mobile" placeholder="Your mobile number..">

    <label for="country">Country</label>
    <select id="country" name="country">
       <option value="india">India</option>
      <option value="australia">Australia</option>
      <option value="canada">Canada</option>
      <option value="usa">USA</option>
    </select>

    <label for="subject">Subject</label>
    <textarea id="subject" name="subject" placeholder="Write something.." style="height:200px"></textarea>

    <input type="submit" value="Submit">

  </form>
</div>
</body>
</html>