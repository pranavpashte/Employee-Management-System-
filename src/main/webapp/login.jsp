<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Admin Login | EMS</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>

<div class="auth-container">
    <div class="auth-card">
        <div class="auth-left">
            <h1>WELCOME BACK</h1>
            <p>Employee Management System</p>
        </div>

        <div class="auth-right">
            <h2>Admin Login</h2>

            <form action="AdminLoginServlet" method="post">
                <div class="input-group">
                    <input type="email" name="email" required>
                    <label>Email</label>
                </div>

                <div class="input-group">
                    <input type="password" name="password" required>
                    <label>Password</label>
                </div>

                <button class="btn">Login</button>
            </form>

            <p class="small-text">
                © 2026 Employee Management System
            </p>
        </div>
    </div>
</div>

</body>
</html>
