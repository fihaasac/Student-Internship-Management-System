<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Student Registration</title>
  <link rel="stylesheet" href="css/styles.css">
</head>
<body>
  <div class="container">
    <h2>Student Registration</h2>

    <% String error = (String) request.getAttribute("error");
       if (error != null) { %>
      <div class="error-message"><%= error %></div>
    <% } %>

    <form action="register" method="post">
      <input type="hidden" name="role" value="Student">

      <label for="name">Full Name</label>
      <input type="text" id="name" name="name" required>

      <label for="email">Email</label>
      <input type="email" id="email" name="email" required>

      <label for="password">Password</label>
      <input type="password" id="password" name="password" required>

      <button type="submit" class="btn">Register</button>
    </form>

    <p>Already have an account? <a href="login.jsp">Login here</a>.</p>
  </div>
</body>
</html>
