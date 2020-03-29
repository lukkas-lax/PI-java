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
@WebServlet("/ManterAluno.do")
public class ManterAluno extends HttpServlet {
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
		String pNome = request.getParameter("nome");
		String pEmail = request.getParameter("email");
		String pRa = request.getParameter("ra");
		String pSenha = request.getParameter("senha");
		String pAcao = request.getParameter("acao");
		
		
		//instanciar o javabean
		Aluno aluno = new Aluno(pid,pNome, pEmail,pSenha, pid, pRa);
		aluno.setIdA(pid);
		aluno.setNome(pNome);
		aluno.setEmail(pEmail);
		aluno.setRa(pRa);
		aluno.setSenha(pSenha);
		

		//instanciar o service
		
		AlunoService cs = new AlunoService();
		RequestDispatcher view = null;
		HttpSession session = request.getSession();
		
		if (pAcao.equals("Criar")) {
			cs.criarUsuario(aluno);
			cs.criar(aluno);
			ArrayList<Aluno> lista = new ArrayList<>();
			lista.add(aluno);
			session.setAttribute("lista", lista);
			view = request.getRequestDispatcher("ListarAlunos.jsp");
		} else if (pAcao.equals("Excluir")) {
			boolean exists = true;
			exists = cs.carregarTurma(aluno.getIdA());
			if(exists == false){
				
				cs.excluir(aluno.getIdA());
				cs.excluirUsuario(aluno.getIdA());
				ArrayList<Aluno> lista = (ArrayList<Aluno>)session.getAttribute("lista");
				lista.remove(busca(aluno, lista));
				session.setAttribute("lista", lista);
				view = request.getRequestDispatcher("ListarAlunos.jsp");		
			}
			else {
				
				ArrayList<Aluno> lista = (ArrayList<Aluno>)session.getAttribute("lista");
				session.setAttribute("lista", lista);
				session.setAttribute("mensagem", "Esse aluno não pode ser excluido!!!");
				view = request.getRequestDispatcher("ListarAlunos.jsp");	
				
				
			}		
		} else if (pAcao.equals("Alterar")) {
			cs.atualizar(aluno);
			ArrayList<Aluno> lista = (ArrayList<Aluno>)session.getAttribute("lista");
			int pos = busca(aluno, lista);
			lista.remove(pos);
			lista.add(pos, aluno);
			session.setAttribute("lista", lista);
			request.setAttribute("aluno", aluno);
			view = request.getRequestDispatcher("VisualizarAluno.jsp");			
		} else if (pAcao.equals("Visualizar")) {
			aluno = cs.carregar(aluno.getIdA());
			request.setAttribute("aluno", aluno);
			view = request.getRequestDispatcher("VisualizarAluno.jsp");		
		} else if (pAcao.equals("Editar")) {
			aluno = cs.carregar(aluno.getIdA());
			request.setAttribute("aluno", aluno);
			view = request.getRequestDispatcher("AlterarAluno.jsp");		
		}
		
		view.forward(request, response);

	}

	public int busca(Aluno aluno, ArrayList<Aluno> lista) {
		Aluno to;
		for(int i = 0; i < lista.size(); i++){
			to = lista.get(i);
			if(to.getIdA() == aluno.getIdA()){
				return i;
			}
		}
		return -1;
	}
		
		

		
	}

