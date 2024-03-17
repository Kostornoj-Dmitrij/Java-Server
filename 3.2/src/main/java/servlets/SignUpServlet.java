package servlets;
import dbService.DBException;
import dbService.DBService;
import dbService.dataSets.UsersDataSet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class SignUpServlet extends HttpServlet {
    @SuppressWarnings({"FieldCanBeLocal", "UnusedDeclaration"})
    private final DBService dbService;
    public SignUpServlet(DBService dbService) {
        this.dbService = dbService;
    }

    public void doPost(HttpServletRequest request,
                       HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter("login");
        String password = request.getParameter("password");

        try {
            long userId = dbService.addUser(login, password);
            System.out.println("Added user id: " + userId);

            UsersDataSet dataSet = dbService.getUser(userId);
            System.out.println("User data set: " + dataSet);
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().println("Signed Up");
            response.setStatus(HttpServletResponse.SC_OK);

        } catch (DBException e) {
            e.printStackTrace();
        }
    }
}