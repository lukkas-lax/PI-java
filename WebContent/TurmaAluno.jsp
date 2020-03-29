<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="pt-br">

<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Cadastro de Aluno-Turma</title>

<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/style.css" rel="stylesheet">

</head>



<body >



	<!-- Barra superior com os menus de navegação -->
	<c:import url="Menu.jsp" />
	<!-- Container Principal -->
	<div id="main" class="container">
		<form action="listar_turmas.do" method="post">
			<div id="top" class="row">
				<div class="col-md-6">
					<h2>Cadastro de Aluno nas Turmas</h2>
				</div>
				<div class="col-md-6" style="
				    border-top-width: 15px;
				    margin-top: 18px;
				    margin-left: -;
				    width: 230px;
			    	margin-left: 250px;">
					<div class="input-group h4">
						<input name="data[search]2" class="form-control" id="search2"
							type="hidden" placeholder="Sigla">
					
								</div>
				</div><br><br><br>
				<div id="top" class="row">
				<div class="col-md-6" style="margin-left: 20px; background-color: #f3eeee; width: 440px;">
					<div class="input-group h4" style="width: 411px;">
					<label style="padding-top: 10px;">Sigla da Turma:  </label>
						<select name="sigla" id="sigla">
											<c:forEach var="turma" items="${lista1}">
												<option value="${turma.sigla}">${turma.sigla}</option>
											</c:forEach>
									</select>
									<span
							class="input-group-btn">
							<button  <%String siglas = request.getParameter("sigla");%>id="teste"  class="btn btn-primary" type="submit" name="acao"
								value="buscar2" >Confirmar Turma</button>
						</span>
									
								
									

									
									
									
					</div>
				</div>


			</div>
			

			<!-- /#top -->
		</form>
		 <form action="listar_turmaalunos.do" method="post">
                    <div id="top" class="row">
                        <div class="col-md-5"style="margin-top: 20px;">
                            <h2 style="margin-left: 6px;">Pesquisar Alunos:</h2>
                        </div>

                        <div class="col-md-6"style="margin-top: 20px;">
                            <div class="input-group h2">
                                <input name="data[search]" class="form-control" id="search" type="text" placeholder="Pesquisar Alunos (deixe vazio para trazer todos)">
                                <span class="input-group-btn">
                <button class="btn btn-primary" type="submit" name="acao" value="buscar">
                    <span class="glyphicon glyphicon-search"></span>
                                </button>
                                </span>
                            </div>
                        </div>

                   
                    </div>
                    <!-- /#top -->
                </form>
		<hr />
		<c:if test="${not empty lista}">
                <div id="list" class="row">

                    <div class="table-responsive col-md-12">
                        <table class="table table-striped" cellspacing="0" cellpadding="0">
                            <thead>
                                <tr>
                                    <th>ID</th>
                                    <th>NOME</th>
                                    <th>EMAIL</th>
                                    <th>RA</th>
                                    <th class="actions">Ações</th>
                                
                                </tr>
                            </thead>
                            <tbody>
          					<c:forEach var="aluno" items="${lista }">
                                       <tr>
                                            <td>
                                               ${aluno.idA }
                                            </td>
                                            <td>
                                               ${aluno.nome }
                                            </td>
                                            <td>
                                               ${aluno.email }
                                            </td>
                                            <td>
                                                ${aluno.ra }
                                            </td>
                                            <td class="actions">
                                               <a class="btn btn-success btn-xs" href="ManterTurma.do?acao=Criar&aluno=${aluno.idA }&turma=<%= siglas %>">Cadastrar</a>
                                              
                                                
                                                
                                            </td>
                                        </tr>
                            </c:forEach>

                            </tbody>
                        </table>

                    </div>
                </div>
                <!-- /#list -->

                <div id="bottom" class="row">
                    <div class="col-md-12">
                        <!-- paginação ainda não foi implementada -->
                        <ul class="pagination">
                            <li class="disabled"><a>&lt; Anterior</a>
                            </li>
                            <li class="disabled"><a>1</a>
                            </li>
                            <li><a href="#">2</a>
                            </li>
                            <li><a href="#">3</a>
                            </li>
                            <li class="next"><a href="#" rel="next">Próximo &gt;</a>
                            </li>
                        </ul>
                        <!-- /.pagination -->
                    </div>
                </div>
                </c:if>
			<!-- /#list -->

		<!-- /#bottom -->
	</div>
	<!-- /#main -->
	<script src="js/jquery.min.js"></script>
	<script src="js/bootstrap.min.js"></script>

</body>

</html>