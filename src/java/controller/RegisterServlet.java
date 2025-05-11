package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import dao.UserDAO;
import model.User;

import java.io.IOException;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    @Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    // Simply forward to the JSP
    req.getRequestDispatcher("registerStudent.jsp").forward(req, resp);
}

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    String name     = req.getParameter("name");
    String email    = req.getParameter("email");
    String password = req.getParameter("password");
    String role     = req.getParameter("role");

    // Basic validation
    if (name == null || email == null || password == null || role == null ||
        name.isBlank() || email.isBlank() || password.isBlank()) {
      req.setAttribute("error", "All fields are required.");
      req.getRequestDispatcher("registerStudent.jsp").forward(req, resp);
      return;
    }

    User user = new User(name, email, password, role);
    boolean success = UserDAO.registerUser(user);

    if (success) {
      resp.sendRedirect("login.jsp");
    } else {
      req.setAttribute("error", "Registration failed. Email may already exist.");
      req.getRequestDispatcher("registerStudent.jsp").forward(req, resp);
    }
  }
}
