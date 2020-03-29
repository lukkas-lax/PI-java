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

import model.Aluno;
import model.Turma;


@WebServlet("/ManterTurma.do")
public class ManterTurma extends HttpServlet {
	
	/**
	 * 
	 */
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
		
		String pSigla = request.getParameter("turma");
		String pAcao = request.getParameter("acao");
		
		
		//instanciar o javabean
		Turma turma = new Turma(0, 0, 0, pSigla, 0, null);
		turma.setSigla(pSigla);
		Aluno aluno = new Aluno(0, null, null, null, pid, null);
	
		

		//instanciar o service
		
		TurmaService cs = new TurmaService();
		RequestDispatcher view = null;
		HttpSession session = request.getSession();
		
		if (pAcao.equals("Criar")) {
			turma = cs.carregarSigla(pSigla);
			cs.criar(aluno,turma);
			view = request.getRequestDispatcher("TurmaAluno.jsp");
		}  
		
	
		
		view.forward(request, response);

	}

	public int busca(Turma turma, ArrayList<Turma> lista) {
		Turma to;
		for(int i = 0; i < lista.size(); i++){
			to = lista.get(i);
			if(to.getSigla() == turma.getSigla()){
				return i;
			}
		}
		return -1;
	}
		

}
