<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Login</title>
  <link rel="stylesheet" href="css/styles.css">
</head>
<body>
  <div class="container">
    <h2>Login</h2>

    <% String error = (String) request.getAttribute("error");
       if (error != null) { %>
      <div class="error-message"><%= error %></div>
    <% } %>

    <form action="login" method="post">
      <label>Email:</label>
      <input type="email" name="email" required>
      <label>Password:</label>
      <input type="password" name="password" required>
      <button type="submit" class="btn">Login</button>
    </form>

    <p>
      Don't have an account?
      <a href="registerStudent.jsp">Register as Student</a> |
      <a href="registerCompany.jsp">Register as Company</a>
    </p>
  </div>
</body>
</html>
