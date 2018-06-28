package coma.com.Servlets;

import coma.com.Models.DBSession;
import coma.com.Models.Record;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class ShowListServlet extends HttpServlet{

    private String responseTemplateStart
            = "<html>\n"
            + "<body><h3>All results</h3>\n";

    private String responseTemplateFinish
            = "</form></body></html>";

    private String responseTemplate
            = "</h2>\n"
            + "<form method='post'>"
            + "<input type=\"button\" class=\"button\" value=\"Back\" onclick=\"location.href='http://localhost:8080/main'\" />";

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
        String r = "";
        DBSession session = DBSession.getInstance();
        ArrayList<Record> list = session.list;

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < list.size(); ++i) {
            builder.append((i + 1) + ") Added by:" + list.get(i).getAddedByUser() + " Client:" + list.get(i).getClient());

            builder.append(" MCV:"+list.get(i).getMCV()  + " RDW:"+list.get(i).getRDW()  + " Date:"+list.get(i).getDate()+"<br>");
        }
        r = builder.toString();

        response.getWriter().write(responseTemplateStart);
        response.getWriter().write(r);
        response.getWriter().write(responseTemplate);
        response.getWriter().write(responseTemplateFinish);
    }
}
