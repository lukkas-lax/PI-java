package controller;


import service.AlunoService;



import java.io.IOException;

import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import model.Aluno;


/**
 * Servlet implementation class ManterAluno
 */
@WebServlet("/ManterAvaliacaoFinal.do")
public class ManterAvaliacaoFinal extends HttpServlet {
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
		int pid = Integer.parseInt(request.getParameter("aluno"));
		String pAcao = request.getParameter("acao");
		
	
		Aluno aluno = new Aluno(0, null, null, null, 0, null);
		aluno.setId(pid);
		
		
		

		//instanciar o service
		
		
		AlunoService cs = new AlunoService();

		RequestDispatcher view = null;
		HttpSession session = request.getSession();
		
		 if (pAcao.equals("SelecionarAV")) {
			aluno = cs.carregar(aluno.getId());
			request.setAttribute("aluno", aluno);
			view = request.getRequestDispatcher("AcompanhamentoAvaliacaoFinal.jsp");		
		} 
		 
		
		
		view.forward(request, response);

	}

	public int busca(Aluno professor, ArrayList<Aluno> lista) {
		Aluno to;
		for(int i = 0; i < lista.size(); i++){
			to = lista.get(i);
			if(to.getId() == professor.getId()){
				return i;
			}
		}
		return -1;
	}
		
	

		

		
	}



