package service;

import java.util.ArrayList;

import dao.AlunoDAO;
import model.Aluno;


public class AlunoService {
	   AlunoDAO dao = new AlunoDAO();
	   Aluno to = new Aluno(0, null, null, null, 0, null);

	   public AlunoService() {
	      dao = new AlunoDAO();
	   }

	   public void criar(Aluno to) {
	      dao.incluir(to);
	   }
	   
	   public void criarUsuario(Aluno to) {
		      dao.incluirUsuario(to);
		   }
	   
	   public void atualizar(Aluno to) {
	      dao.atualizar(to);
	   }
	   public void excluir(int id){
			dao.excluir(id);
		}
	   
	   public void excluirUsuario(int id){
			dao.excluirUsuario(id);
		}
	   
	   public Aluno carregar(int id){
			return dao.carregar(id);
		}
	   
	   public Boolean carregarTurma(int id){
			return dao.carregarTurma(id);
		}
	   
	   public ArrayList<Aluno> listarAlunos(){
			return dao.listarAlunos();
		}
		public ArrayList<Aluno> listarAlunos(String chave){
			return dao.listarAlunos(chave);
		}
		
		public ArrayList<Aluno> listarAlunosG(String chave){
			return dao.listarAlunosG(chave);
		}

	}
