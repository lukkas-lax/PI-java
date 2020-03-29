<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="pt-br">

<head >
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Acompanhamento de Avaliações</title>

<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/style.css" rel="stylesheet">

</head>


<body>

	<!-- Barra superior com os menus de navegação -->
	<c:import url="Menu.jsp" />
	<!-- Container Principal -->
	<div id="main" class="container">
		<form action="listar_turmagrupo.do" method="post">
			<div id="top" class="row">
				<div class="col-md-4">
					<h5 class="page-header">Sigla da Turma: ${turma.sigla }</h5>
				</div>

				<div class="col-md-5"  style="padding-top: 12px;">
					<div class="input-group h2">
						 
						<input type="hidden" name="data[search]" class="form-control" id="search" value="${turma.id }" />
						<span class="input-group-btn">
							<button class="btn btn-primary" type="submit" name="acao"
								value="buscar" id="teste">CONFIRMAR
								
							</button>
						</span>
						&nbsp<a href="AcompanhamentoAvaliacaoTurma.jsp" class="btn btn-default">Voltar</a>
					</div>
				</div>


			</div>
			<!-- /#top -->
		</form>
		<hr />
		
		
		
			<div id="list" class="row">

                    <div class="table-responsive col-md-12">
                        <table class="table table-striped" cellspacing="0" cellpadding="0">
                            <thead>
                                <tr>
                                    <th>ID</th>
                                    <th>NOME</th>
                                     <th>NUMERO</th>
                                    <th class="actions">Ações</th>
                                </tr>
                            </thead>
                            <tbody>
          					<c:forEach var="grupo" items="${listaGU }">
                                       <tr>
                                       		<td>
                                               ${grupo.grupo_id }
                                            </td>
                                            <td>
                                               ${grupo.nome }
                                            </td>
                                            <td>
                                               ${grupo.numero }
                                            </td>
                
                                            <td class="actions">
                                                <a class="btn btn-success btn-xs" href="ManterTurmaAluno.do?acao=SelecionarAL&grupo=${grupo.grupo_id }">Selecionar</a>
                                             
                                           
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
						<li class="disabled"><a>&lt; Anterior</a></li>
						<li class="disabled"><a>1</a></li>
						<li><a href="#">2</a></li>
						<li><a href="#">3</a></li>
						<li class="next"><a href="#" rel="next">Próximo &gt;</a></li>
					</ul>
					<!-- /.pagination -->
				</div>
			</div>

		<!-- /#bottom -->
	</div>
	<!-- /#main -->
	<script  src="js/jquery.min.js"></script>
	<script src="js/bootstrap.min.js"></script>

</body>

</html>