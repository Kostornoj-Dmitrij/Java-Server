package servlets;

import resourcesServices.ResourceServer;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ResourcePageServlet extends HttpServlet {

    public static final String PAGE_URL = "/resources";
    private final ResourceServer resourceServer;

    public ResourcePageServlet(ResourceServer resourceServer) {
        this.resourceServer = resourceServer;
    }

    public void doPost(HttpServletRequest request,
                       HttpServletResponse response) throws ServletException, IOException {
        String path = request.getParameter("path");
        response.setContentType("text/html;charset=utf-8");
        resourceServer.readResource(path);
        response.getWriter().println("Resource loaded from path: " + path);
        response.setStatus(HttpServletResponse.SC_OK);
    }

    public void doGet(HttpServletRequest request,
                      HttpServletResponse response) throws ServletException, IOException {

        doPost(request,response);

    }
}