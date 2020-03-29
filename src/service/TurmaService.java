package service;

import java.util.ArrayList;


import dao.TurmaDAO;
import model.Aluno;
import model.Turma;

public class TurmaService {
	
	TurmaDAO dao = new TurmaDAO();
	 Turma tu = new Turma(0, 0, 0, null, 0, null);
	 Aluno to = new Aluno(0, null, null, null, 0, null);

	   public TurmaService() {
	      dao = new TurmaDAO();
	   }
	   
	   public Turma carregar(int id){
			return dao.carregar(id);
		}
	   
	   public Turma carregarSigla(String sig){
			return dao.carregarSigla(sig);
		}
	   
	   public ArrayList<Turma> listarTurmas(){
			return dao.listarTurmas();
		}
		public ArrayList<Turma> listarTurmas(String chave){
			return dao.listarTurmas(chave);
		}
		
		public ArrayList<Turma> listarTurmasProf(String chave){
			return dao.listarTurmasProf(chave);
		}
		public ArrayList<Turma> listarTurmasP(String chave){
			return dao.listarTurmasP(chave);
		}
		
		public ArrayList<Turma> listarTurmasP(){
			return dao.listarTurmasP();
		}
		
		 public void criar(Aluno to, Turma tu) {
		      dao.incluir(to,tu);
		   }

}
