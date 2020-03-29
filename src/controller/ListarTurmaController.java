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


@WebServlet("/listar_turmas.do")
public class ListarTurmaController  extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String chave = request.getParameter("data[search]2");
		String acao = request.getParameter("acao");
		TurmaService tu = new TurmaService();
		ArrayList<Turma> lista1 = null;
		HttpSession session = request.getSession();
		if (acao.equals("buscar2")) {
			if (chave != null && chave.length() > 0) {
				lista1 = tu.listarTurmas(chave);
			} else {
				lista1 = tu.listarTurmas();
			}
			session.setAttribute("lista1", lista1);
		} else if (acao.equals("reiniciar")) {
			session.setAttribute("lista1", null);
		}

		RequestDispatcher dispatcher = request
				.getRequestDispatcher("TurmaAluno.jsp");
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
