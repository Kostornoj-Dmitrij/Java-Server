package servlets;

import dbService.DBException;
import dbService.DBService;
import dbService.dataSets.UsersDataSet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SignInServlet extends HttpServlet {
    private final DBService dbService;

    public SignInServlet(DBService dbService) {
        this.dbService = dbService;
    }

    public void doPost(HttpServletRequest request,
                       HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter("login");
        String password = request.getParameter("password");

        if (login == null || login.isEmpty() || password == null || password.isEmpty()) {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            return;
        }

        try {
            if (dbService.isRegistered(login) && dbService.checkCredentials(login, password)) {
                response.setStatus(HttpServletResponse.SC_OK);
                response.getWriter().println("Authorized: " + login);
            } else {
                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                response.getWriter().println("Unauthorized");
            }
        } catch (DBException e) {
            throw new RuntimeException(e);
        }
    }
}