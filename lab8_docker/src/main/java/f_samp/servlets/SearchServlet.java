package f_samp.servlets;
/*

import f_samp.listservice.Security;
import f_samp.listservice.LiteratureListService;
*/

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class SearchServlet extends HttpServlet {


/*    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(template1);
        LiteratureListService literatureListService = new LiteratureListService();
        PrintWriter writer = response.getWriter();
        writer.write(template2);
        for (Security profile : literatureListService.searchPerson(request.getParameter("searchPerson"))) {
            writer.write("<tr>" +
                    "               <td>"+profile.getSurname()+"</td>" +
                    "               <td>"+profile.getName()+"</td>" +
                    "               <td>"+profile.getPatronymic()+"</td>" +
                    "               <td>"+profile.getPassport()+"</td>" +
                    "               <td>"+profile.getPosition()+"</td>" +
                    "               <td>"+profile.getTolerance_level()+"</td>" +
                    "           </tr>");
        }
        writer.write(template3);
    }*/


    private String template1 = "<html>\n" +
            "<head>\n" +
            "    <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css\">\n" +
            "    <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap-theme.min.css\">\n" +
            "    <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js\"></script>\n" +
            "    <meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\">\n" +
            "    <title>Поиск</title>\n" +
            "    <style type=\"text/css\">\n" +
            "         .centerLayer {\n" +
            "            \"    margin-left: 20%; /* Отступ слева */" +
            "                  margin-top: 10%"+
            "            \"    width: 40%; /* Ширина слоя */"+
            "            \"    padding: 10px;"+
            "            \"   \n" +
            "    </style>" +
            "</head>\n" +
            "<body>\n" +
         //   "<form class=centerLayer method='GET'>\n" +
         //   "  <div class=\"input-group\">\n" +
           // "    <input type=\"text\" class=\"form-control\" name='search' placeholder=\"Search\">\n" +
          //  "    <div class=\"input-group-btn \">\n" +
           // "      <button class=\"btn btn-default\" 'type=\"submit\">\n" +
           // "        <i class=\"glyphicon glyphicon-search\"></i>\n" +
            //"      </button>\n" +
           // "    </div>\n" +
         //   "  </div>\n" +
        //    "</form>" +
             "<form margin-left='100px' action='my_insert'  class=\"col-sm-6\" id='myDiv''>\n" +
            "  <div   class=\"form-group\">\n" +
            "<h3 align='left'>Управление списком сотрудников</h3>\n" +
            "  <button type=\"my_insert\" name=\"my\" class=\"btn btn-default\">Добавить нового сотрудника</button>\n" +
            "  <button type=\"my_delete\" class=\"btn btn-default\">Удалить данные сотрудника</button>\n" +
            "</div>\n"
            +            "</form> "
            + "<form   margin-left: 20%; action='my_search' class=\"col-sm-6\" method='GET'>\n" +

            "  <div  class=\"form-group\" method='POST'>\n" +
            "<h3 '>Поиск сотрудника</h3>" +
            "    <label for=\"searchPerson\">Поиск сотрудника по Фамилии:</label>\n" +
            "    <input type=\"searchPerson\" name='searchPerson' class=\"form-control\" id=\"searchPerson\">" +
            "  <button type=\"submit\"  btn btn-default\">Поиск</button>\n" +
            "  <button type=\"submit\" btn btn-default\" >Показать полный псисок</button>\n" +
            "  </div>\n" +
            "</form>";

    private String template2 =
            "<table class='table table-striped'>"
                    +"   <thead>"
                    +"   <tr>"
                    +"       <th>Фамилия</th>"
                    +"       <th>Имя</th>"
                    +"       <th>Отчество</th>"
                    +"       <th>Номер паспорта</th>"
                    +"       <th>Должность</th>"
                    +"       <th>Уровень доступа</th>"
                    +"   </tr>"
                    +"   </thead>"
                    +"   <tbody   background: #f3bd48; /* Цвет фона при наведении */>" +
                    "</div'>";



    private String template3 =
            "</tbody>"
                    +"</table>"
                    +
                    "</body>\n" +
                    "</html>";
}