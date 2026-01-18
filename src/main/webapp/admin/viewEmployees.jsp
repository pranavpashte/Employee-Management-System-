<%@ page import="java.util.List" %>
<%@ page import="dao.EmployeeDAO" %>
<%@ page import="model.Employee" %>

<!DOCTYPE html>
<html>
<head>
    <title>View Employees</title>
    <link rel="stylesheet" href="../css/style.css">
</head>
<body>

<div class="table-container">
<div class="table-card">

<h2>Employee List</h2>

<table>
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Email</th>
        <th>Role</th>
        <th>Salary</th>
        <th>Action</th>
    </tr>

<%
    List<Employee> list = EmployeeDAO.getAll();
    for (Employee e : list) {
%>
    <tr>
        <td><%= e.getEmpId() %></td>
        <td><%= e.getName() %></td>
        <td><%= e.getEmail() %></td>
        <td><%= e.getRole() %></td>
        <td>₹ <%= e.getSalary() %></td>
        <td class="action-btns">
            <a href="editEmployee.jsp?id=<%= e.getEmpId() %>" class="edit-btn">Edit</a>
            <a href="../EmployeeServlet?action=delete&id=<%= e.getEmpId() %>"
               class="delete-btn"
               onclick="return confirm('Are you sure?')">Delete</a>
        </td>
    </tr>
<%
    }
%>
</table>

<a href="dashboard.jsp" class="back-link">← Back to Dashboard</a>

</div>
</div>

</body>
</html>
