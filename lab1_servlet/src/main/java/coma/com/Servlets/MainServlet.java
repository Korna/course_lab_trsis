package coma.com.Servlets;


import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class MainServlet extends HttpServlet {

    private String responseTemplateStart
            = "<html>\n"
            + "<body><h3>Main menu</h3>\n";

    private String responseTemplateFinish
            = "</form></body></html>";

    private String responseTemplate
            = "</h2>\n"
            + "<form method='post'>"
            + "<input type=\"button\" class=\"button\" value=\"Add\" onclick=\"location.href='http://localhost:8080/add'\" />"
            + "<br><br>"
            + "<input type=\"button\" class=\"button\" value=\"Search\" onclick=\"location.href='http://localhost:8080/search'\" />"
            + "<br><br>"
            + "<input type=\"button\" class=\"button\" value=\"List\" onclick=\"location.href='http://localhost:8080/list'\" />"
            + "<br><br>"
            + "<input type=\"button\" class=\"button\" value=\"Delete\" onclick=\"location.href='http://localhost:8080/delete'\" />";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        process(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        process(request, response);
    }

    private void process(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setStatus(200);

        response.getWriter().write(responseTemplateStart);

        response.getWriter().write(responseTemplate);
        response.getWriter().write(responseTemplateFinish);
    }
}
