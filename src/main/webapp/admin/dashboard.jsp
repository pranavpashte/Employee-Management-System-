<%@ page session="true" %>
<%
    if (session.getAttribute("admin") == null) {
        response.sendRedirect("../login.jsp");
    }
%>

<!DOCTYPE html>
<html>
<head>
    <title>Admin Dashboard</title>
    <link rel="stylesheet" href="../css/style.css">
</head>
<body>

<div class="dashboard">
    <h1>Admin Dashboard</h1>

    <div class="card-grid">
        <a href="addEmployee.jsp" class="dash-card">➕ Add Employee</a>
        <a href="viewEmployees.jsp" class="dash-card">👥 View Employees</a>
        <a href="../LogoutServlet" class="dash-card danger">🚪 Logout</a>
    </div>
</div>

</body>
</html>
