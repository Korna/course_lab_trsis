package f_samp.servlets;

/*
import f_samp.listservice.Security;
import f_samp.listservice.LiteratureListService;
*/

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;



public class InsertServlet extends HttpServlet {

   // private LiteratureListService literatureList = new LiteratureListService();

/*    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setCharacterEncoding("UTF-8");
        PrintWriter writer = response.getWriter();
        writer.write(template1);
        for (Security profile: literatureList.getPersonList()) {
            writer.write("<tr>" +
                    "               <td>"+profile.getSurname()+"</td>" +
                    "               <td>"+profile.getName()+"</td>" +
                    "               <td>"+profile.getPatronymic()+"</td>" +
                    "               <td>"+profile.getPassport()+"</td>" +
                    "               <td>"+profile.getPosition()+"</td>" +
                    "               <td>"+profile.getTolerance_level()+"</td>" +
                    "           </tr>");
        }
       writer.write(template2);
        if (request.getParameter("my")!=null)
        {
            writer.write(template3);
        }
        else
        {
            writer.write(template4);
        }
        writer.write(template5);
    }*/

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");
        String name = request.getParameter("Name");
        String sername = request.getParameter("Sername");
        String patronymic = request.getParameter("Patronymic");
        String passport = request.getParameter("Passport");
        String position = request.getParameter("Position");
        String tolerance_level = request.getParameter("Tolerance_level");
     String butt =request.getParameter("my");
     //   literatureList.addPerson(name, sername, patronymic, passport, position, tolerance_level);

    //    doGet(request, response);


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
            +"<h2 align='center'>Сотрудники</h2>"
            +"<table class='table table-striped'>"
            +"   <thead>"
            +"   <tr>"
            +"       <th>Фамилия</th>"
            +"       <th>Имя</th>"
            +"       <th>Отчество</th>"
            +"       <th>Номер пасспорта</th>"
            +"       <th>Должность</th>"
            +"       <th>Уровень доступа</th>"
            +"   </tr>"
            +"   </thead>"
            +"   <tbody>" +
            "</div'>";


    private String template2 = "   </tbody>"
            +"</table>";

          //       <p><%if (request.getAttribute("str") != null) {
      //  out.println("<p>" + request.getAttribute("str") + "</p>");
  //  }%></p>


    private String template3 = "<form  + name=\"formAdd\" class=\"col-sm-6\" method='POST'>\n" +
            "<h3 align='center'>Добавить сотрудника</h3>" +
            "  <div class=\"form-group\">\n" +
            "    <label for=\"sername\">Фамилия:</label>\n" +
            "    <input type=\"Sername\" name='Sername' class=\"form-control\" id=\"Sername\">\n" +
            "  </div>\n" +
            "  <div class=\"form-group\">\n" +
            "    <label for=\"name\">Имя:</label>\n" +
            "    <input type=\"Name\" name='Name' class=\"form-control\" id=\"Name\">\n" +
            "  </div>\n" +
            "  <div class=\"form-group\">\n" +
            "    <label for=\"patronymic\">Отчество:</label>\n" +
            "    <input type=\"Patronymic\" name='Patronymic' class=\"form-control\" id=\"Patronymic\">\n" +
            "  </div>\n" +
            "  <div class=\"form-group\">\n" +
            "    <label for=\"Passport\">Номер паспорта:</label>\n" +
            "    <input type=\"Passport\" name='Passport' class=\"form-control\" id=\"Passport\">\n" +
            "  </div>\n" +
            "  <div class=\"form-group\">\n" +
            "    <label for=\"position\">Должность:</label>\n" +
            "    <input type=\"Position\" name='Position' class=\"form-control\" id=\"Position\">\n" +
            "  </div>\n" +
            "  <div class=\"form-group\">\n" +
            "    <label for=\"tolerance_level\">Уровень доступа:</label>\n" +
            "    <input type='Tolerance_level' name='Tolerance_level' class=\"form-control\" id=\"Tolerance_level\">\n" +
            "  </div>\n" +
            "  <button type=\"submit\" >Добавить</button>\n"+
            "</form>\n";

    private String template4 =  "<form action='my_delete' class=\"col-sm-6\" method='POST'>\n" +
            "<h3 align='center'>Удалить сотрудника</h3>" +
            "  <div class=\"my_form-group\">\n" +
            "    <label for=\"passport\">Номер паспорта:</label>\n" +
            "    <input type=\"passport\" name='del_passport' class=\"form-control\" id=\"passport\">\n" +
            "  <button type=\"my_delete\"  >Удалить данные сотрудника</button>\n" +
            "  </div>\n" +

            "</form>\n" ;

    private String template5 =   "<form action='my_search' width=\"50px\" id='myDiv' class=\"col-sm-6\" method='GET'>\n" +
            "  <button type=\"my_search\" >Вернуться к списку</button>\n" +

            "</body>"
            +"</html>";

}
