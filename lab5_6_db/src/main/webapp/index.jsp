<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<html>
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap-theme.min.css">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>Начальная страница</title>
    <style type="text/css">
        #parent {
            width: 100%;
            height: 30%;
            position: absolute;
            top: 20%;
            left: 0;
            overflow: auto;
        }

        #block {
            width: 450px;
            height: 50px;
            position: absolute;
            top: 0;
            right: 0;
            bottom: 0;
            left: 0;
            margin: auto;
            text-align:center;
        }
    </style>
</head>
<body>
<div id="parent">
    <h1 align='center'>Добро пожаловать в систему INSave</h1>
    <div   align='center'  class="myClass">

        <button type="button" border-radius="12px"  paddin="20px 60px" width="250px" onclick="location.href='http://localhost:8080/testTomcat/my_search'">Контроль доступа</button>
    </div>
</div>
</body>
</html>

