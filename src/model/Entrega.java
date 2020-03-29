package model;


import java.util.Date;


public class Entrega extends Atividade {
    
    private int atividade_id;
	private int grupo_id;
	private int id;
	private Date time;
	private Date data;
	
	public Entrega(int id, int grupo_id, Date time, int atividade_id,Date data,int tema, int numero, String descrisao, Date dInicio, Date dFim, String fEntrega) {
		super(tema, numero, id, descrisao, dInicio, dFim, fEntrega);
        this.id = id;
        this.grupo_id = grupo_id;
        this.atividade_id = atividade_id;
        this.time = time;
        this.data = data;
    }
	
	
	public int getAtividade_id() {
		return atividade_id;
	}
	public void setAtividade_id(int atividade_id) {
		this.atividade_id = atividade_id;
	}
	public int getGrupo_id() {
		return grupo_id;
	}
	public void setGrupo_id(int grupo_id) {
		this.grupo_id = grupo_id;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
    
}
