package model;


import java.util.Date;


public class Tema {
    
    private int id;
	private Date dt_cadastro; 
	private String titulo, introducao, requisitos;
	
	public Tema (int id, int dt_cadastro, String titulo, String introducao, String requisitos){
		super();
		this.id = id;
		this.titulo = titulo;
		this.introducao = introducao;
		this.requisitos = requisitos;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDt_cadastro() {
		return dt_cadastro;
	}

	public void setDt_cadastro(Date dt_cadastro) {
		this.dt_cadastro = dt_cadastro;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getIntroducao() {
		return introducao;
	}

	public void setIntroducao(String introducao) {
		this.introducao = introducao;
	}

	public String getRequisitos() {
		return requisitos;
	}

	public void setRequisitos(String requisitos) {
		this.requisitos = requisitos;
	}

    
}
