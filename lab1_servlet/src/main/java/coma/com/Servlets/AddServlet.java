package coma.com.Servlets;

import coma.com.Models.DBSession;
import coma.com.Models.Record;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import javax.servlet.http.HttpServlet;
import java.util.Date;

public class AddServlet extends HttpServlet{
    private final String CLIENT = "client";
    private final String MCV = "mcv";
    private final String RDW = "rdw";

    private String responseTemplateStart
            = "<html>\n"
            + "<body>\n"
            + "<h2>";

    private String responseTemplate
            = "</h2>\n"
            + "<form method='post'><input name='"+CLIENT+"'>"
            + "<br><br>"
            + "<form method='post'><input name='"+MCV+"'>"
            + "<br><br>"
            + "<form method='post'><input name='"+RDW+"'>"
            + "<br><br><input type='submit'>"
            + "<br><br><input type=\"button\" class=\"button\" value=\"Back\" onclick=\"location.href='http://localhost:8080/main'\" />";

    private String responseTemplateFinish
            = "</form></body>\n"
            + "</html>";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        process(request, response, request.getParameter(CLIENT), request.getParameter(MCV), request.getParameter(RDW));
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        process(request, response, request.getParameter(CLIENT), request.getParameter(MCV), request.getParameter(RDW));
    }

    private void process(HttpServletRequest request, HttpServletResponse response, String client, String mcv, String rdw) throws IOException {
        response.setStatus(200);
        response.getWriter().write(responseTemplateStart);

        DBSession session = DBSession.getInstance();
        Date date = new Date();
        if(client!=null && !client.equals("")){
            session.list.add(new Record(session.getUserId(), client, mcv, rdw, date.toString()));
            response.getWriter().write("Record added");
        }else
            response.getWriter().write("Write info about client!");


        response.getWriter().write(responseTemplate);

        response.getWriter().write(responseTemplateFinish);
    }
}
