package service;

import java.util.ArrayList;

import dao.ProfessorDAO;

import model.Professor;

public class ProfessorService {
	
	ProfessorDAO dao = new ProfessorDAO();
	Professor pr = new Professor(0, null, null, null, 0, 0, null);

	   public ProfessorService() {
	      dao = new ProfessorDAO();
	   }
	   
	   
	   public ArrayList<Professor> listarProfessor(){
			return dao.listarProfessor();
		}
		public ArrayList<Professor> listarProfessor(String chave){
			return dao.listarProfessor(chave);
		}
		
		 public Professor carregar(int id){
				return dao.carregar(id);
			}

}
