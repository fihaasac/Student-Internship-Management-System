<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="jakarta.servlet.http.*, jakarta.servlet.*" %>
<%@ page import="java.util.List, dao.InternshipDAO, model.Internship" %>
<%
    List<Internship> internships = InternshipDAO.getAllInternships();
%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Apply for Internship</title>
  <link rel="stylesheet" href="css/styles.css">
  <script>
    function loadInternships() {
      // Use JSP expression so the context path is always correct:
      const ctx = '<%= request.getContextPath() %>';
      fetch(ctx + '/ajax/internshipList.jsp')
        .then(r => {
          if (!r.ok) throw new Error('Status ' + r.status);
          return r.text();
        })
        .then(html => {
          console.log('AJAX response:', html);  // open console to see debug
          document.getElementById("internshipDropdown").innerHTML = html;
        })
        .catch(err => {
          console.error('Fetch error:', err);
          document.getElementById("internshipDropdown").innerHTML =
            '<option disabled>Error loading internships</option>';
        });
    }
    window.onload = loadInternships;
  </script>
</head>
<body>
  <div class="container">
    <h2>Apply for Internship</h2>
    <form method="post" action="applyInternship">
        <!-- Hidden field for student ID (assume set from session or manually) -->
        <input type="hidden" name="student_id" value="1" />

        <label for="internship_id">Select Internship:</label>
        <select name="internship_id" id="internship_id" required>
            <% for (Internship i : internships) { %>
                <option value="<%= i.getId() %>"><%= i.getTitle() %></option>
            <% } %>
        </select>
        <br><br>

        <label for="coverLetter">Cover Letter:</label><br>
        <textarea name="coverLetter" id="coverLetter" rows="6" cols="50" required></textarea>
        <br><br>

        <input type="submit" value="Apply">
    </form>

    <%
        String error = (String) request.getAttribute("error");
        if (error != null) {
    %>
        <p style="color:red;"><%= error %></p>
    <%
        }
    %>
</body>
</html>

