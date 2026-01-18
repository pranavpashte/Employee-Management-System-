<%@ page import="java.util.List" %>
<%@ page import="dao.DepartmentDAO" %>
<%@ page import="model.Department" %>

<!DOCTYPE html>
<html>
<head>
    <title>Add Employee | EMS</title>
    <link rel="stylesheet" href="../css/style.css">
</head>
<body>

<div class="form-container">
    <div class="form-card">

        <h2>Add Employee</h2>

        <form action="../EmployeeServlet" method="post">

            <input type="hidden" name="action" value="add">

            <div class="input-group">
                <input type="text" name="name" required>
                <label>Employee Name</label>
            </div>

            <div class="input-group">
                <input type="email" name="email" required>
                <label>Email</label>
            </div>

            <div class="input-group">
                <input type="number" name="salary" required>
                <label>Salary</label>
            </div>

            <div class="input-group">
                <input type="text" name="role" required>
                <label>Role</label>
            </div>

            <select name="deptId" class="select-box" required>
                <option value="">Select Department</option>
                <%
                    List<Department> list = DepartmentDAO.getAll();
                    for (Department d : list) {
                %>
                    <option value="<%= d.getDeptId() %>">
                        <%= d.getDeptName() %>
                    </option>
                <%
                    }
                %>
            </select>

            <button type="submit" class="btn">Add Employee</button>

            <a href="dashboard.jsp" class="back-link">← Back to Dashboard</a>

        </form>

    </div>
</div>

</body>
</html>
