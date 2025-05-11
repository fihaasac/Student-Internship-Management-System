package controller;

import model.Internship;
import dao.InternshipDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/postInternship")
public class InternshipServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String title = request.getParameter("title");
        String description = request.getParameter("description");
        int companyId = Integer.parseInt(request.getParameter("company_id"));
        String deadline = request.getParameter("deadline");

        // Validate fields
        if (title != null && !title.trim().isEmpty() && description != null && !description.trim().isEmpty()) {
            Internship internship = new Internship(0, title, description, companyId, deadline);
            
            boolean success = InternshipDAO.addInternship(internship);
            
            if (success) {
                response.sendRedirect("dashboardCompany.jsp");  // Redirect after successful submission
            } else {
                request.setAttribute("error", "Failed to post internship.");
                request.getRequestDispatcher("postInternship.jsp").forward(request, response);
            }
        } else {
            request.setAttribute("error", "All fields are required.");
            request.getRequestDispatcher("postInternship.jsp").forward(request, response);
        }
    }
}
