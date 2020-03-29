package model;

public class Grupo{
   
   private int grupo_id;
   private int orientador_id;
   private int numero;
   private String nome;
   
   public Grupo(int grupo_id, int orientador_id, int numero, String nome) {
		this.grupo_id = grupo_id;
		this.orientador_id = orientador_id;
		this.numero = numero;
		this.nome = nome;
	}
   
   public int getGrupo_id(){
      return grupo_id;
   }
   
   public void setGrupo_id(int id){
      this.grupo_id = id;
   }
   
   public int getOrientador_id(){
      return orientador_id;
   }
   
   public void setOrientador_id(int orientador_id){
      this.orientador_id = orientador_id;
   }
   
   public int getNumero(){
      return numero;
   }
   
   public void setNumero(int numero){
      this.numero = numero;
   }
   
   public String getNome(){
      return nome;
   }
   
   public void setNome(String nome){
      this.nome = nome;
   }
   
}