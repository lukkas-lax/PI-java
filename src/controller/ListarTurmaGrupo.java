package controller;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.GrupoService;

import model.Grupo;


@WebServlet("/listar_turmagrupo.do")
public class ListarTurmaGrupo  extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String chave = request.getParameter("data[search]");
		String acao = request.getParameter("acao");
		
		GrupoService tu = new GrupoService();
		ArrayList<Grupo> listaGU = null;
		HttpSession session = request.getSession();
		
	if (acao.equals("buscar")) {
			if (chave != null && chave.length() > 0) {
				listaGU = tu.listarGrupos(chave);
			} else {
				listaGU = tu.listarGrupos();
			
			}
			session.setAttribute("listaGU", listaGU);
			
			
		} else if (acao.equals("reiniciar")) {
			
			session.setAttribute("listaGU", listaGU);
		}
		
		RequestDispatcher dispatcher = request
				.getRequestDispatcher("AcompanhamentoAvaliacaoGrupo.jsp");
		dispatcher.forward(request, response);

		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}


}


