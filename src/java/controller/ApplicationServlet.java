package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import dao.ApplicationDAO;
import model.Application;

import java.io.IOException;

@WebServlet("/applyInternship")
public class ApplicationServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            // Retrieve form parameters and validate them
            String studentIdStr = request.getParameter("student_id");
            String internshipIdStr = request.getParameter("internship_id");
            String coverLetter = request.getParameter("coverLetter");

            // Validate student_id and internship_id (check if they are valid integers)
            if (studentIdStr == null || internshipIdStr == null || coverLetter == null || coverLetter.trim().isEmpty()) {
                request.setAttribute("error", "All fields are required.");
                request.getRequestDispatcher("applyInternship.jsp").forward(request, response);
                return;
            }

            int studentId = Integer.parseInt(studentIdStr);
            int internshipId = Integer.parseInt(internshipIdStr);

            // Create Application object
            Application application = new Application(studentId, internshipId, coverLetter);

            // Add the application to the database
            boolean success = ApplicationDAO.addApplication(application);

            // If successful, redirect to student dashboard, else show error
            if (success) {
                response.sendRedirect("dashboardStudent.jsp");
            } else {
                request.setAttribute("error", "Failed to apply for internship. Please try again.");
                request.getRequestDispatcher("applyInternship.jsp").forward(request, response);
            }
        } catch (NumberFormatException e) {
            // Handle invalid number format
            request.setAttribute("error", "Invalid student ID or internship ID.");
            request.getRequestDispatcher("applyInternship.jsp").forward(request, response);
        } catch (Exception e) {
            // Generic error handling
            e.printStackTrace();  // Log the error for debugging
            request.setAttribute("error", "An unexpected error occurred. Please try again.");
            request.getRequestDispatcher("applyInternship.jsp").forward(request, response);
        }
    }
}
