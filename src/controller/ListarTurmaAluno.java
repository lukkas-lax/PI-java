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

import service.AlunoService;

import model.Aluno;


@WebServlet("/listar_turmaaluno.do")
public class ListarTurmaAluno  extends HttpServlet {
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
		
		AlunoService tu = new AlunoService();
		ArrayList<Aluno> listaAL = null;
		HttpSession session = request.getSession();
		
	if (acao.equals("buscar")) {
			if (chave != null && chave.length() > 0) {
				listaAL = tu.listarAlunosG(chave);
			} else {
				
			
			}
			session.setAttribute("listaAL", listaAL);
			
			
		} else if (acao.equals("reiniciar")) {
			
			session.setAttribute("listaAL", listaAL);
		}
		
		RequestDispatcher dispatcher = request
				.getRequestDispatcher("AcompanhamentoAvaliacaoAluno.jsp");
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


