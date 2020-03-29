package service;

import java.util.ArrayList;


import dao.GrupoDAO;
import model.Grupo;

public class GrupoService {
	
	GrupoDAO dao = new GrupoDAO();
	Grupo gr = new Grupo(0, 0, 0, null);

	   public GrupoService() {
	      dao = new GrupoDAO();
	   }
	   
	   public Grupo carregar(int id){
			return dao.carregar(id);
		}
	   
	   public ArrayList<Grupo> listarGrupos(){
			return dao.listarGrupos();
		}
		public ArrayList<Grupo> listarGrupos(String chave){
			return dao.listarGrupos(chave);
		}

}
