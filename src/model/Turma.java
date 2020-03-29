package model;


import java.util.ArrayList;


public class Turma {
    
    private int id;
	private int semestre_letivo;
	private int ano_letivo;
	private String sigla;
	private int tema_id;
	private ArrayList<Aluno> alunos = new ArrayList<>();
	
	
	
	public Turma(int id, int semestre_letivo, int ano_letivo, String sigla, int tema_id, ArrayList<Aluno> alunos) {
		super();
		this.id = id;
		this.semestre_letivo = semestre_letivo;
		this.ano_letivo = ano_letivo;
		this.sigla = sigla;
		this.tema_id = tema_id;
		this.alunos = alunos;
	}
	public ArrayList<Aluno> getAlunos() {
		return alunos;
	}
	public void setAlunos(ArrayList<Aluno> alunos) {
		this.alunos = alunos;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getSemestre_letivo() {
		return semestre_letivo;
	}
	public void setSemestre_letivo(int semestre_letivo) {
		this.semestre_letivo = semestre_letivo;
	}
	public int getAno_letivo() {
		return ano_letivo;
	}
	public void setAno_letivo(int ano_letivo) {
		this.ano_letivo = ano_letivo;
	}
	public String getSigla() {
		return sigla;
	}
	public void setSigla(String sigla) {
		this.sigla = sigla;
	}
	public int getTema_id() {
		return tema_id;
	}
	public void setTema_id(int tema_id) {
		this.tema_id = tema_id;
	}
    
}
