package service;

import java.util.ArrayList;


import dao.EntregaDAO;
import model.Entrega;

public class EntregaService {
	
	EntregaDAO dao = new EntregaDAO();
	Entrega tu = new Entrega(0, 0, null, 0, null, 0, 0, null, null, null, null);
	
	public EntregaService() {
	      dao = new EntregaDAO();
	   }
	
	public ArrayList<Entrega> listarEntrega(){
		return dao.listarEntrega();
	}
	
	public ArrayList<Entrega> listarEntrega(String chave){
		return dao.listarEntrega(chave);
	}

}
