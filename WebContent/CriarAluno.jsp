<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="pt-br">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Sistema de Projetos - Criar Alunos</title>

    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/style.css" rel="stylesheet">
</head>

<body>
    <!-- Barra superior com os menus de navegação -->
	<c:import url="Menu.jsp"/>
    <!-- Container Principal -->
    <div id="main" class="container">
        <h3 class="page-header">Adicionar Registro do Aluno</h3>
        <!-- Formulario para inclusao de clientes -->
        <form action="ManterAluno.do" method="post">
        
          <div class="row">
                <div class="form-group col-md-2">
                    <label for="nome">ID:</label>
                    <input type="text" class="form-control" name="aluno" id="aluno" required maxlength="100" placeholder="ID do Aluno">
                </div>
                <div class="form-group col-md-2">
                    <label for="fone">RA:</label>
                    <input type="tel" class="form-control" name="ra" id="ra" placeholder="RA do Aluno"maxlength="15">
                </div>
            </div>
            <!-- area de campos do form -->
            <div class="row">
                <div class="form-group col-md-4">
                    <label for="nome">NOME:</label>
                    <input type="text" class="form-control" name="nome" id="nome" required maxlength="100" placeholder="Nome do Aluno">
                </div>
            </div>
            <div class="row">
                <div class="form-group col-md-4">
                    <label for="nome">SENHA:</label>
                    <input type="text" class="form-control" name="senha" id="senha" required maxlength="100" placeholder="Senha do Aluno">
                </div>
            </div>
            <div class="row">
                <div class="form-group col-md-4">
                    <label for="nome">EMAIL:</label>
                    <input type="text" class="form-control" name="email" id="email" required maxlength="100" placeholder="Email do Aluno">
                </div>
            </div>
            <hr />
            <div id="actions" class="row">
                <div class="col-md-12">
                    <button type="submit" class="btn btn-primary" name="acao" value="Criar">Cadastrar Aluno</button>
                    <a href="index.jsp" class="btn btn-default">Cancelar</a>
                </div>
            </div>
        </form>
    </div>
    <script src="js/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
</body>

</html>