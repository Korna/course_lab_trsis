package servlets;

import listservice.BookProfile;
import listservice.LiteratureListService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class SearchServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(template1);
        LiteratureListService literatureListService = new LiteratureListService();
        PrintWriter writer = response.getWriter();
        for (BookProfile profile : literatureListService.searchBook(request.getParameter("search"))) {
            writer.write("<tr>" +
                    "               <td>"+profile.getName()+"</td>" +
                    "               <td>"+profile.getAuthor()+"</td>" +
                    "               <td>"+profile.getPublisher()+"</td>" +
                    "           </tr>");
        }
        writer.write(template2);
    }


    private String template1 = "<html>\n" +
            "<head>\n" +
            "    <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css\">\n" +
            "    <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap-theme.min.css\">\n" +
            "    <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js\"></script>\n" +
            "    <meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\">\n" +
            "    <title>Поиск</title>\n" +
            "    <style type=\"text/css\">\n" +
            "         .centerLayer {\n" +
            "            \"    margin-left: 30%; /* Отступ слева */" +
            "                  margin-top: 10%"+
            "            \"    width: 40%; /* Ширина слоя */"+
            "            \"    padding: 10px;"+
            "            \"   \n" +
            "    </style>" +
            "</head>\n" +
            "<body>\n" +
            "<form class=centerLayer method='GET'>\n" +
            "  <div class=\"input-group\">\n" +
            "    <input type=\"text\" class=\"form-control\" name='search' placeholder=\"Search\">\n" +
            "    <div class=\"input-group-btn \">\n" +
            "      <button class=\"btn btn-default\" 'type=\"submit\">\n" +
            "        <i class=\"glyphicon glyphicon-search\"></i>\n" +
            "      </button>\n" +
            "    </div>\n" +
            "  </div>\n" +
            "</form>" +
            "<table class='table table-striped'>"
            +"   <thead>"
            +"   <tr>"
            +"       <th>Название</th>"
            +"       <th>Автор</th>"
            +"       <th>Издательство</th>"
            +"   </tr>"
            +"   </thead>"
            +"   <tbody>" +
            "</div'>";

    private String template2 = "</tbody>"
            +"</table>"+
            "</body>\n" +
            "</html>";
}