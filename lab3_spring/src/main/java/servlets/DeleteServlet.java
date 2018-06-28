package servlets;

import listservice.LiteratureListService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DeleteServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LiteratureListService literatureList = new LiteratureListService();
        request.setCharacterEncoding("UTF-8");
        literatureList.deleteBook(request.getParameter("deleteRecord"));
        response.sendRedirect("sample");
    }

}
