package model;

public class Professor extends Usuario{
   
   private int idP;
   private int administrador;
   private String matricula;
   
   public Professor (int id, String nome, String email, String senha, int idP, int administrador, String matricula){
   
      super (id, nome, email, senha);
      this.idP = idP;
      this.administrador = administrador;
      this.matricula = matricula;
   }
   
   public int getIdP(){
      return idP;
   }
   
   public void setIdP(int idP){
      this.idP = idP;
   }
   
   public int getAdministrador(){
      return administrador;
   }
   
   public void setAdministrador(int administrador){
      this.administrador = administrador;
   }
   
   public String getMatricula(){
      return matricula;
   }
   
   public void setMatricula(String matricula){
      this.matricula = matricula;
   }
}