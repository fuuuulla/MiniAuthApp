<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    // Vérifier si l'utilisateur est connecté
    if (session.getAttribute("user") == null) {
        response.sendRedirect("login.jsp");
        return;
    }
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Dashboard</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background: linear-gradient(135deg, #667eea 0%, #764ba2 100%);
            margin: 0;
            padding: 20px;
        }
        .dashboard-container {
            background: white;
            max-width: 800px;
            margin: 50px auto;
            padding: 40px;
            border-radius: 10px;
            box-shadow: 0 10px 25px rgba(0,0,0,0.2);
        }
        h1 {
            color: #333;
            text-align: center;
        }
        .welcome {
            font-size: 18px;
            color: #555;
            text-align: center;
            margin: 20px 0;
        }
        .user-info {
            background: #f5f5f5;
            padding: 20px;
            border-radius: 5px;
            margin: 20px 0;
        }
        
        .logout-btn:hover {
            background: #c0392b;
        }
    </style>
</head>
<body>
    <div class="dashboard-container">
        <h1>✅ Tableau de bord</h1>
        
        <div class="welcome">
            Bienvenue, <strong>${user}</strong> ! 🎉
        </div>
        
        <div class="user-info">
            <h3>Informations de session :</h3>
            <p><strong>Utilisateur connecté :</strong> ${user}</p>
            <p><strong>Session ID :</strong> <%= session.getId() %></p>
            <p><strong>Date de connexion :</strong> <%= new java.util.Date() %></p>
        </div>
        
        
    </div>
</body>
</html>