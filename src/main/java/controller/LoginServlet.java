package controller;

import model.UserDAO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        // Récupérer les paramètres du formulaire
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        // Créer une instance du DAO
        UserDAO dao = new UserDAO();

        // Vérifier l'authentification
        if (dao.authenticate(username, password)) {
            // Créer une session et stocker le nom d'utilisateur
            HttpSession session = req.getSession();
            session.setAttribute("user", username);
            
            // Rediriger vers le dashboard
            resp.sendRedirect("dashboard.jsp");
        } else {
            // Stocker le message d'erreur dans la requête
            req.setAttribute("error", "Login ou mot de passe incorrect");
            
            // Retourner à la page de login avec le message d'erreur
            req.getRequestDispatcher("login.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        // Rediriger vers la page de login si accès direct
        resp.sendRedirect("login.jsp");
    }
}