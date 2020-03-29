package model;


import java.util.Date;


public class Atividade {

   private int id;    
   private int tema;
	private int numero;
	private String descrisao;
	private String fEntrega;
	private Date dInicio;
	private Date dFim;
	
	public Atividade(int id,int tema, int numero, String descrisao, Date dInicio, Date dFim, String fEntrega) {
		super();
      this.id = id;
		this.tema = tema;
		this.numero = numero;
		this.descrisao = descrisao;
		this.dInicio = dInicio;
	    this.dFim = dFim;
	}
	
	public String getfEntrega() {
		return fEntrega;
	}

	public void setfEntrega(String fEntrega) {
		this.fEntrega = fEntrega;
	}

	public Date getdInicio() {
		return dInicio;
	}

	public void setdInicio(Date dInicio) {
		this.dInicio = dInicio;
	}

	public Date getdFim() {
		return dFim;
	}

	public void setdFim(Date dFim) {
		this.dFim = dFim;
	}

	public int getTema() {
		return tema;
	}


	public void setTema(int tema) {
		this.tema = tema;
	}
   
   public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}



	public int getNumero() {
		return numero;
	}


	public void setNumero(int numero) {
		this.numero = numero;
	}


	public String getDescrisao() {
		return descrisao;
	}


	public void setDescrisao(String descrisao) {
		this.descrisao = descrisao;
	}

    
}
