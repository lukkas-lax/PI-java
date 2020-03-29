package service;

import java.util.ArrayList;


import dao.AvaliacaoDAO;
import model.Avaliacao;

public class AvaliacaoService {
	
	AvaliacaoDAO dao = new AvaliacaoDAO();
	Avaliacao tu = new Avaliacao(0, 0, null, null, 0, 0, null, null, 0, 0, null, null, null, null, null);
	

	   public AvaliacaoService() {
	      dao = new AvaliacaoDAO();
	   }
	   
	   
	 
		public ArrayList<Avaliacao> listarAvaliacao(String chave){
			return dao.listarAvaliacao(chave);
		}
		
		public ArrayList<Avaliacao> listarAvaliacao(){
			return dao.listarAvaliacao();
		}
		
		 

}
