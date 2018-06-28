package coma.com.Servlets;

import coma.com.Models.DBSession;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginServlet extends HttpServlet {

    private final String USER_ID = "userID";
    private final String USER_PASS = "userPass";

    private String responseTemplateStart
            = "<html>\n"
            + "<body>\n"
            + "<h2>";

    private String responseTemplate
            = "</h2>\n"
            + "<form method='post'><input name='"+USER_ID+"'>"
            + "<br><br>"
            + "<form method='post'><input name='"+USER_PASS+"'>"
            + "<br><br><input type='submit'>";

    private String responseTemplateFinish
            = "</form></body>\n"
            + "</html>";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        process(request, response, request.getParameter(USER_ID), request.getParameter(USER_PASS));
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        process(request, response, request.getParameter(USER_ID), request.getParameter(USER_PASS));
    }

    private void process(HttpServletRequest request, HttpServletResponse response, String userID, String userPass) throws IOException {
        response.setStatus(200);

        response.getWriter().write(responseTemplateStart);
        if (userID != null && !userID.equals("")) {
            DBSession session = DBSession.getInstance();
            session.setUserId(userID);

            System.out.println("Signed:" + userID + "\n");

            if(userPass.equals("123456"))
                response.getWriter().write("<br><br><input type=\"button\" class=\"button\" value=\"Continue\" onclick=\"location.href='http://localhost:8080/main'\" />");
            else
                response.getWriter().write("Incorrect password");
        }
        else {
            response.getWriter().write("Write your login and pass");
        }

        response.getWriter().write(responseTemplate);
        response.getWriter().write(responseTemplateFinish);
    }
}
