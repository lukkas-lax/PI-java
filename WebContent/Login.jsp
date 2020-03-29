<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPEhtml>
<html lang="pt-br">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible"content="IE=edge">
<meta name="viewport"content="width=device-width, initial-scale=1">
<title>Cadastros</title>
<link href="css/bootstrap.min.css"rel="stylesheet">
<link href="css/style.css"rel="stylesheet">
</head>
<body>
<!--Barra superior comos menus denavegacao -->
<c:import url="Menu.jsp"/>
<!-- Container Principal -->
<div id="main"class="containser">
<h3 class="page-header" style="margin-left: 50px;">Tela de Login</h3>
<!--Formulario de Login -->
<form action="/Projeto_Final/"method="post">
<div class="row col-md-12"style="
    margin-left: 60px;
    margin-top: 10px;
">
<div class="form-group">
<div class="input-group col-md-4">
<div class="input-group-addon"><span class="glyphicon glyphicon-envelope"aria-hidden="true"></span></div>
<input type="email"name="username"id="username"class="formcontrol" maxlength="60"placeholder="E-mail"required style="
    border-top-width: 4px;
    border-left-width: 3px;
    border-right-width: 3px;
    padding-bottom: 3px;
    border-bottom-width: 4px;
"/>
</div>
</div>
<div class="form-group">
<div class="input-group col-md-4">
<div class="input-group-addon"><span class="glyphicon glyphicon-option-horizontal"aria-hidden="true"></span></div>
<input type="password"name="passwd"id="passwd"class="formcontrol" placeholder="Senha"required style="
    border-top-width: 4px;
    border-left-width: 3px;
    border-right-width: 3px;
    padding-bottom: 3px;
    border-bottom-width: 4px;
"/>
</div>
</div>
</div>
<div class="row col-md-12" style="
    margin-left: 60px;
">
<button type="submit"class="btn btnprimary" name="command"value="FazerLogin"><span class="glyphicon glyphiconok" aria-hidden="true" ></span>Fazer Login</button>
</div>
</form>
</div>
<script src="js/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
</body>
</html>