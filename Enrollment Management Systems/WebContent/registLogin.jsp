<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script>
function validateForm() {
    var ssn = document.getElementById("ssn").value;
    if (ssn.trim() == "") {
        alert("Please enter your SSN.");
        return false; // Prevent form submission
    }
    return true; // Allow form submission
}
</script>
</head>
<body>

<!-- regisLogin.jsp -->
<form action="validateLogin" method="post" onsubmit="return validateForm()">
  <label for="ssn">Enter your SSN:</label>
  <input type="text" id="ssn" name="ssn"><br><br>
  <input type="submit" value="Login">
</form>

</body>
</html>
