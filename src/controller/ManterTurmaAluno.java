package controller;


import service.GrupoService;



import java.io.IOException;

import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import model.Grupo;


/**
 * Servlet implementation class ManterAluno
 */
@WebServlet("/ManterTurmaAluno.do")
public class ManterTurmaAluno extends HttpServlet {
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
		int pid = Integer.parseInt(request.getParameter("grupo"));
		String pAcao = request.getParameter("acao");
		
	
		Grupo grupo = new Grupo(0, 0, 0, null);
		grupo.setGrupo_id(pid);
		
		
		

		//instanciar o service
		
		
		GrupoService cs = new GrupoService();

		RequestDispatcher view = null;
		HttpSession session = request.getSession();
		
		 if (pAcao.equals("SelecionarAL")) {
			grupo = cs.carregar(grupo.getGrupo_id());
			request.setAttribute("grupo", grupo);
			view = request.getRequestDispatcher("AcompanhamentoAvaliacaoAluno.jsp");		
		} 
		 
		
		
		view.forward(request, response);

	}

	public int busca(Grupo professor, ArrayList<Grupo> lista) {
		Grupo to;
		for(int i = 0; i < lista.size(); i++){
			to = lista.get(i);
			if(to.getGrupo_id() == professor.getGrupo_id()){
				return i;
			}
		}
		return -1;
	}
		
	

		

		
	}



