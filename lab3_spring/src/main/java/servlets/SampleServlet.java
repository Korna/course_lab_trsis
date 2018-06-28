package servlets;

import listservice.BookProfile;
import listservice.LiteratureListService;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;



public class SampleServlet extends HttpServlet {

    private LiteratureListService literatureList = new LiteratureListService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setCharacterEncoding("UTF-8");
        PrintWriter writer = response.getWriter();
        writer.write(template1);
        for (BookProfile profile: literatureList.getLiteratureList()) {
            writer.write("<tr>" +
                    "               <td>"+profile.getName()+"</td>" +
                    "               <td>"+profile.getAuthor()+"</td>" +
                    "               <td>"+profile.getPublisher()+"</td>" +
                    "           </tr>");
        }
        writer.write(template2+template3);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");
        String name = request.getParameter("bookName");
        String author = request.getParameter("bookAuthor");
        String publisher = request.getParameter("bookPublisher");
        literatureList.addBook(name, author, publisher);
        doGet(request, response);
    }


    private String template1 = "<!DOCTYPE html>"
            +"<html lang='ru'>"
            +"<head>"
            +"<title>ТРСИС</title>"
            +"<style type=\"text/css\">\n" +
            "   .centerLayer {\n" +
            "    margin-left: 30%; /* Отступ слева */\n" +
            "    width: 40%; /* Ширина слоя */\n" +
            "    padding: 10px; /* Поля вокруг текста */\n" +
            "   }\n" +
            "#myDiv {" +
            "margin-top: 5%" +
            "}" +
            "  </style>"
            +"<meta charset='utf-8'>"
            +"<meta name='viewport' content='width=device-width, initial-scale=1'>"
            +"<link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css'>"
            +"<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>"
            +"<script src='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js'></script>"
            +"</head>"
            +"<body>"
            +"<div class='container centerLayer'>"
            +"<h2 align='center'>Список книг</h2>"
            +"<table class='table table-striped'>"
            +"   <thead>"
            +"   <tr>"
            +"       <th>Название</th>"
            +"       <th>Автор</th>"
            +"       <th>Издательство</th>"
            +"   </tr>"
            +"   </thead>"
            +"   <tbody>" +
            "</div'>";


    private String template2 = "   </tbody>"
            +"</table>";

    private String template3 = "<form class=\"col-sm-6\" method='POST'>\n" +
            "<h3 align='center'>Добавить книгу</h3>" +
            "  <div class=\"form-group\">\n" +
            "    <label for=\"name\">Название:</label>\n" +
            "    <input type=\"bookName\" name='bookName' class=\"form-control\" id=\"bookName\">\n" +
            "  </div>\n" +
            "  <div class=\"form-group\">\n" +
            "    <label for=\"author\">Автор:</label>\n" +
            "    <input type=\"bookAuthor\" name='bookAuthor' class=\"form-control\" id=\"bookAuthor\">\n" +
            "  </div>\n" +
            "  <div class=\"form-group\">\n" +
            "    <label for=\"publisher\">Издатель:</label>\n" +
            "    <input type='bookPublisher' name='bookPublisher' class=\"form-control\" id=\"bookPublisher\">\n" +
            "  </div>\n" +
            "  <button type=\"submit\" class=\"btn btn-default\">Добавить</button>\n" +
            "</form>"
            +"<div class=\"container\">"
            + "<form action='delete' class=\"col-sm-6\" method='POST'>\n" +
            "<h3 align='center'>Удалить книгу</h3>" +
            "  <div class=\"form-group\">\n" +
            "    <label for=\"deleteBookName\">Название книги:</label>\n" +
            "    <input type=\"deleteBookName\" name='deleteRecord' class=\"form-control\" id=\"deleteBookName\">\n" +
            "  </div>\n" +
            "  <button type=\"delete\" class=\"btn btn-default\">Удалить</button>\n" +
            "</form>"
            +"</div>"
            + "<form action='search' id='myDiv' method='GET'>\n" +
            "  <button type=\"search\" class=\"btn btn-primary btn-block\">Поиск</button>\n" +
            "</form>"+
            "</body>"
            +"</html>";

}
