package controller.filter;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebFilter("/*")
public class AuthFilter implements Filter {
    public void doFilter(jakarta.servlet.ServletRequest request, jakarta.servlet.ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        HttpSession session = httpRequest.getSession(false);

        String path = httpRequest.getRequestURI();

        // Check if user is logged in and has the right role for the page
        if (path.contains("admin") && (session == null || !"Admin".equals(session.getAttribute("role")))) {
            httpResponse.sendRedirect("error.jsp");
            return;
        } else if (path.contains("student") && (session == null || !"Student".equals(session.getAttribute("role")))) {
            httpResponse.sendRedirect("error.jsp");
            return;
        } else if (path.contains("company") && (session == null || !"Company".equals(session.getAttribute("role")))) {
            httpResponse.sendRedirect("error.jsp");
            return;
        }

        chain.doFilter(request, response);
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {}

    @Override
    public void destroy() {}
}
