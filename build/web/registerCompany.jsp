<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Register Company</title>
    <link rel="stylesheet" href="css/styles.css">
</head>
<body>
    <h2>Register Company</h2>
    <form action="register" method="post">
        <input type="hidden" name="role" value="Company">
        <label>Company Name:</label><br>
        <input type="text" name="name" required><br><br>

        <label>Email:</label><br>
        <input type="email" name="email" required><br><br>

        <label>Password:</label><br>
        <input type="password" name="password" required><br><br>

        <button type="submit">Register</button>
    </form>
</body>
</html>
