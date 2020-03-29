package model;


import java.util.ArrayList;
import java.util.Date;


public class Avaliacao extends Entrega{
    
    private int id;
    private ArrayList<Entrega> entrega = new ArrayList<>();
    private ArrayList<Aluno> aluno = new ArrayList<>();
    private ArrayList<Turma> turma = new ArrayList<>();
    private double nota;
    private Date dt_avaliacao;
    private String comentarios;
    private String nome_aluno;

    public String getNome_aluno() {
		return nome_aluno;
	}

	public void setNome_aluno(String nome_aluno) {
		this.nome_aluno = nome_aluno;
	}

	public Avaliacao(int id, double nota, Date dt_avaliacao, String comentarios, int atividade_id, int grupo_id, Date time,Date data,int tema, int numero, String descrisao, Date dInicio, Date dFim, String fEntrega, String nome_aluno) {
    	super(atividade_id, grupo_id, data, grupo_id, time,numero,tema, descrisao, dInicio, dFim, fEntrega);
        this.id = id;
        this.nota = nota;
        this.dt_avaliacao = dt_avaliacao;
        this.comentarios = comentarios;
        this.nome_aluno = nome_aluno;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ArrayList<Entrega> getEntrega() {
        return entrega;
    }

    public void setEntrega(ArrayList<Entrega> entrega) {
        this.entrega = entrega;
    }

    public ArrayList<Aluno> getAluno() {
        return aluno;
    }

    public void setAluno(ArrayList<Aluno> aluno) {
        this.aluno = aluno;
    }

    public ArrayList<Turma> getTurma() {
        return turma;
    }

    public void setTurma(ArrayList<Turma> turma) {
        this.turma = turma;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

    public Date getDt_avaliacao() {
        return dt_avaliacao;
    }

    public void setDt_avaliacao(Date dt_avaliacao) {
        this.dt_avaliacao = dt_avaliacao;
    }

    public String getComentarios() {
        return comentarios;
    }

    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }
    
    
    
}
