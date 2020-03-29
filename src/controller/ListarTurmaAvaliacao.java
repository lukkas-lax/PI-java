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


import service.ProfessorService;

import model.Professor;



@WebServlet("/listar_turmaavaliacao.do")
public class ListarTurmaAvaliacao  extends HttpServlet {
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
		
		ProfessorService pr = new ProfessorService();
		ArrayList<Professor> listaPr = null;
	
		HttpSession session = request.getSession();
		
		if (acao.equals("buscar")) {
			if (chave != null && chave.length() > 0) {
				listaPr = pr.listarProfessor(chave);
			} else {
				listaPr = pr.listarProfessor();
			}
			
			session.setAttribute("listaPr", listaPr);
			
			
		} else if (acao.equals("reiniciar")) {
			
			session.setAttribute("listaPr", null);
		
		}
		
		RequestDispatcher dispatcher = request
				.getRequestDispatcher("AcompanhamentoAvaliacao.jsp");
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

