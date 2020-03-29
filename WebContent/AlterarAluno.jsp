<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

        <!DOCTYPE html>
        <html lang="pt-br">

        <head>
            <meta charset="utf-8">
            <meta http-equiv="X-UA-Compatible" content="IE=edge">
            <meta name="viewport" content="width=device-width, initial-scale=1">
            <title>Sistema de Projetos - Alterar Aluno</title>

            <link href="css/bootstrap.min.css" rel="stylesheet">
            <link href="css/style.css" rel="stylesheet">
        </head>

        <body>
                <!-- Barra superior com os menus de navegação -->
				<c:import url="Menu.jsp"/>
                <!-- Container Principal -->
                <div id="main" class="container">
                    <h3 class="page-header">Editar dados do  Aluno ${aluno.idA }</h3>
                    <h5>- Campos com * o preenchimento é obrigatório</h5>
                    <!-- Formulario para alteração de clientes -->
                    <form action="ManterAluno.do" method="post">
                        <!-- area de campos do form -->
                        <input type="hidden" name="aluno" id="aluno" value="${aluno.idA }" />
                        <div class="row">
                            <div class="form-group col-md-4">
                                <label for="nome">Nome</label>
                                <input type="text" class="form-control" name="nome" id="nome" required maxlength="100" placeholder="Nome Completo do Aluno" value="${aluno.nome }">
                            </div>
                        </div>
                          <div class="row">
                            <div class="form-group col-md-4">
                                <label for="nome">Senha</label>
                                <input type="text" class="form-control" name="senha" id="senha" required maxlength="100" placeholder="Senha" value="${aluno.senha }">
                            </div>
                        </div>
                        <div class="row">
                            <div class="form-group col-md-4">
                                <label for="fone">RA*</label>
                                <input type="tel" class="form-control" name="ra" id="ra" maxlength="15"  placeholder="RA do Aluno" value="${aluno.ra }">
                            </div>

                            <div class="form-group col-md-4">
                                <label for="email">E-mail*</label>
                                <input type="email" class="form-control" name="email" id="email" required maxlength="60" placeholder="Email do Aluno" value="${aluno.email }">
                            </div>
                        </div>
                        <hr />
                        <div id="actions" class="row">
                            <div class="col-md-12">
                                <button type="submit" class="btn btn-primary" name="acao" value="Alterar">Salvar Alterações</button>
                                <a href="ListarAlunos.jsp" class="btn btn-default">Cancelar</a>
                            </div>
                        </div>
                    </form>
                </div>
                <script src="js/jquery.min.js"></script>
                <script src="js/bootstrap.min.js"></script>
        </body>

        </html>