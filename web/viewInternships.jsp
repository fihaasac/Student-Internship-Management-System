<%@ page import="java.util.List, dao.InternshipDAO, model.Internship" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    // Fetch all internships
    List<Internship> internships = InternshipDAO.getAllInternships();
%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>All Internships</title>
  <link rel="stylesheet" href="css/styles.css">
</head>
<body>
  <div class="container">
    <h2>Available Internships</h2>
    <table>
      <tr>
        <th>ID</th>
        <th>Title</th>
        <th>Description</th>
        <th>Company ID</th>
        <th>Deadline</th>
      </tr>
      <% if (internships.isEmpty()) { %>
        <tr><td colspan="5">No internships found.</td></tr>
      <% } else {
           for (Internship i : internships) { %>
        <tr>
          <td><%= i.getId() %></td>
          <td><%= i.getTitle() %></td>
          <td><%= i.getDescription() %></td>
          <td><%= i.getCompanyId() %></td>
          <td><%= i.getDeadline() %></td>
        </tr>
      <%   }
         } %>
    </table>
  </div>
</body>
</html>
