package controller;


import service.ProfessorService;



import java.io.IOException;

import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import model.Professor;


/**
 * Servlet implementation class ManterAluno
 */
@WebServlet("/ManterAvaliacao.do")
public class ManterAvaliacao extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String String = null;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int pid = Integer.parseInt(request.getParameter("professor"));

		String pAcao = request.getParameter("acao");
		
		
		//instanciar o javabean
		Professor professor = new Professor(pid,null, null,null, pid, 0, null);
		professor.setId(pid);
		
		
		

		//instanciar o service
		
		ProfessorService cs = new ProfessorService();

		RequestDispatcher view = null;
		HttpSession session = request.getSession();
		
		 if (pAcao.equals("SelecionarTU")) {
			professor = cs.carregar(professor.getId());
			request.setAttribute("professor", professor);
			view = request.getRequestDispatcher("AcompanhamentoAvaliacaoTurma.jsp");		
		} 
		 
		
		
		view.forward(request, response);

	}

	public int busca(Professor professor, ArrayList<Professor> lista) {
		Professor to;
		for(int i = 0; i < lista.size(); i++){
			to = lista.get(i);
			if(to.getId() == professor.getId()){
				return i;
			}
		}
		return -1;
	}
		
	

		

		
	}



