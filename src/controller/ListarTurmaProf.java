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



import service.TurmaService;
import model.Turma;


@WebServlet("/listar_turmaprof.do")
public class ListarTurmaProf  extends HttpServlet {
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
		
		TurmaService tu = new TurmaService();
		ArrayList<Turma> listaTU = null;
		HttpSession session = request.getSession();
		
	if (acao.equals("buscar")) {
			if (chave != null && chave.length() > 0) {
				listaTU = tu.listarTurmasP(chave);
			} else {
				
			
			}
			session.setAttribute("listaTU", listaTU);
			
			
		} else if (acao.equals("reiniciar")) {
			
			session.setAttribute("listaTU", listaTU);
		}
		
		RequestDispatcher dispatcher = request
				.getRequestDispatcher("AcompanhamentoAvaliacaoTurma.jsp");
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

