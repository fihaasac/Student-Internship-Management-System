<%@ page import="java.util.List, dao.InternshipDAO, model.Internship" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    List<Internship> list = InternshipDAO.getAllInternships();
    out.println("<!-- count=" + list.size() + " -->");  // debug: shows how many were fetched
    for (Internship i : list) {
%>
    <option value="<%= i.getId() %>"><%= i.getTitle() %></option>
<%
    }
%>
