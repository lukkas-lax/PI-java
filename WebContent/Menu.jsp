<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <nav class="navbar navbar-inverse navbar-fixed-top">
        <div class="container-fluid">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                 <div class="divNavBar">
                <a class="navbar-brand" href="index.jsp">Sistema de Projetos</a>
                <Label class="labelBemVindo">Bem vindo Aluno! &nbsp; &nbsp; - &nbsp; &nbsp; Semestre Letivo: <select name="periodo" id="periodo">
											<c:forEach var="turma" items="${lista1}">
												<option value="${turma.semestre_letivo}">${turma.semestre_letivo}/${turma.ano_letivo}</option>
											</c:forEach>
									</select></Label>
                </div>
            </div>
            <div id="navbar" class="navbar-collapse collapse">
                <ul class="nav navbar-nav navbar-right">
                    <li><a href="listar_alunos.do?acao=reiniciar">Pesquisar Alunos</a>
                    </li>
                    <li><a href="listar_turmas.do?acao=reiniciar">Cadastro de Alunos em Turmas</a>
                    </li>
                    <li><a href="listar_turmaavaliacao.do?acao=reiniciar">Acompanhar Avaliações</a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>