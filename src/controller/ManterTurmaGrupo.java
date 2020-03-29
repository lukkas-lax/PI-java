package controller;


import service.TurmaService;



import java.io.IOException;

import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import model.Turma;


/**
 * Servlet implementation class ManterAluno
 */
@WebServlet("/ManterTurmaGrupo.do")
public class ManterTurmaGrupo extends HttpServlet {
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
		int pid = Integer.parseInt(request.getParameter("turma"));
		String pAcao = request.getParameter("acao");
		
	
		Turma turma = new Turma(0, 0, 0, null, 0, null);
		turma.setId(pid);
		
		
		

		//instanciar o service
		
		
		TurmaService cs = new TurmaService();

		RequestDispatcher view = null;
		HttpSession session = request.getSession();
		
		 if (pAcao.equals("SelecionarGU")) {
			turma = cs.carregar(turma.getId());
			request.setAttribute("turma", turma);
			view = request.getRequestDispatcher("AcompanhamentoAvaliacaoGrupo.jsp");		
		} 
		 
		
		
		view.forward(request, response);

	}

	public int busca(Turma professor, ArrayList<Turma> lista) {
		Turma to;
		for(int i = 0; i < lista.size(); i++){
			to = lista.get(i);
			if(to.getId() == professor.getId()){
				return i;
			}
		}
		return -1;
	}
		
	

		

		
	}



