<%@ page import="java.util.List" %>
<%@ page import="model.Application" %>
<%@ page import="dao.ApplicationDAO" %>
<%
    // Get the list of applications from the database
    List<Application> applications = ApplicationDAO.getApplications();
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>View Applications</title>
    <link rel="stylesheet" href="css/styles.css">
</head>
<body>
    <div class="container">
        <h2>Applications for Internships</h2>
        <table>
            <tr>
                <th>Student Name</th>
                <th>Internship Title</th>
                <th>Status</th>
            </tr>
            <%-- Loop through the applications and display them --%>
            <% for (Application app : applications) { %>
                <tr>
                    <td><%= app.getStudentName() %></td>
                    <td><%= app.getInternshipTitle() %></td>
                    <td><%= app.getStatus() %></td>
                </tr>
            <% } %>
        </table>
    </div>
</body>
</html>
