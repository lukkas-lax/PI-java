package dao;

import model.Aluno;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;




public class AlunoDAO {
   ConnectionFactory conexao = new ConnectionFactory();
   
   public void incluir(Aluno to) {
	   String sqlInsert = "INSERT INTO aluno(aluno_id,ra) VALUES (?,?)";
	// usando o try with resources do Java 7, que fecha o que abriu
	try (Connection conn = conexao.obtemConexao();
	PreparedStatement stm = conn.prepareStatement(sqlInsert)){ 
	stm.setInt(1, to.getIdA());
	stm.setString(2, to.getRa());
	stm.execute();
	} catch (SQLException e) {
	     e.printStackTrace();
	   }
	}
   
   public void incluirUsuario(Aluno to) {
	   String sqlInsert = "INSERT INTO usuario(nome,email,senha) VALUES (?, ?,?)";
	// usando o try with resources do Java 7, que fecha o que abriu
	try (Connection conn = conexao.obtemConexao();
	PreparedStatement stm = conn.prepareStatement(sqlInsert)){ 
	stm.setString(1, to.getNome());
	stm.setString(2, to.getEmail());
	stm.setString(3, to.getSenha());
	stm.execute();
	} catch (SQLException e) {
	     e.printStackTrace();
	   }
	}
   
  
   public void atualizar(Aluno to) {
      String sqlUpdate = "UPDATE usuario A INNER JOIN aluno B ON (A.id = B.aluno_id) SET A.senha=?, A.nome = ?, A.email = ?, B.ra = ? WHERE A.id = ? AND B.aluno_id = ?";
   
      try (Connection conn = conexao.obtemConexao();
      PreparedStatement stm = conn.prepareStatement(sqlUpdate);) {
    	 stm.setString(1, to.getSenha());
    	 stm.setString(2, to.getNome());
    	 stm.setString(3, to.getEmail());
         stm.setString(4, to.getRa());
         stm.setInt(5, to.getIdA());
         stm.setInt(6, to.getIdA());
         stm.execute();
      } catch (Exception e) {
         e.printStackTrace();
      }
   }
   
   public void excluir(int id) {
		String sqlDelete = "DELETE FROM aluno WHERE aluno_id = ?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = conexao.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlDelete);) {
			stm.setInt(1, id);
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
   public void excluirUsuario(int id) {
		String sqlDelete = "DELETE FROM usuario WHERE id = ?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = conexao.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlDelete);) {
			stm.setInt(1, id);
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
   

   
   
	public Aluno carregar(int id) {
		Aluno aluno = new Aluno(id, null, null, null, id, null);
		aluno.setIdA(id);
		String sqlSelect = "SELECT aluno.aluno_id, aluno.ra,usuario.nome,usuario.email,usuario.senha,usuario.id  FROM usuario INNER JOIN aluno ON usuario.id = aluno.aluno_id WHERE aluno.aluno_id = ?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = conexao.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			stm.setInt(1, aluno.getIdA());
			try (ResultSet rs = stm.executeQuery();) {
				if (rs.next()) {
					aluno.setId(rs.getInt("id"));
					aluno.setIdA(rs.getInt("aluno_id"));
					aluno.setNome(rs.getString("nome"));
					aluno.setEmail(rs.getString("email"));
					aluno.setRa(rs.getString("ra"));
					aluno.setSenha(rs.getString("senha"));
				} else {
					
					aluno.setIdA(-1);
					aluno.setRa(null);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return aluno;
	}
	
	
	
	
	public ArrayList<Aluno> listarAlunos() {
		Aluno aluno;
		ArrayList<Aluno> lista = new ArrayList<>();
		String sqlSelect = "SELECT aluno.aluno_id, aluno.ra,usuario.nome,usuario.email,usuario.senha  FROM usuario INNER JOIN aluno ON usuario.id = aluno.aluno_id ORDER BY aluno_id";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = conexao.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			try (ResultSet rs = stm.executeQuery();) {
				while (rs.next()) {
					aluno = new Aluno(0, null, null, null, 0, null);
					aluno.setIdA(rs.getInt("aluno_id"));
					aluno.setNome(rs.getString("nome"));
					aluno.setEmail(rs.getString("email"));
					aluno.setRa(rs.getString("ra"));
					aluno.setSenha(rs.getString("senha"));
					lista.add(aluno);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return lista;
		
	}

	public ArrayList<Aluno> listarAlunos(String chave) {
		Aluno aluno;
		ArrayList<Aluno> lista = new ArrayList<>();
		String sqlSelect = "SELECT aluno.aluno_id, aluno.ra,usuario.nome,usuario.email,usuario.senha  FROM usuario INNER JOIN aluno ON usuario.id = aluno.aluno_id where upper(ra) like ?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = conexao.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			stm.setString(1, "%" + chave.toUpperCase() + "%");
			try (ResultSet rs = stm.executeQuery();) {
				while (rs.next()) {
					aluno = new Aluno(0, null, null, null, 0, null);
					aluno.setIdA(rs.getInt("aluno_id"));
					aluno.setNome(rs.getString("nome"));
					aluno.setEmail(rs.getString("email"));
					aluno.setRa(rs.getString("ra"));
					aluno.setSenha(rs.getString("senha"));
					lista.add(aluno);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return lista;
	}
	
	public ArrayList<Aluno> listarAlunosG(String chave) {
		Aluno aluno;
		ArrayList<Aluno> lista = new ArrayList<>();
		String sqlSelect = "SELECT aluno.aluno_id, aluno.ra,usuario.nome FROM usuario INNER JOIN aluno ON usuario.id = aluno.aluno_id INNER JOIN turma_aluno ON aluno.aluno_id = turma_aluno.Aluno_id INNER JOIN grupo ON turma_aluno.grupo_id = grupo.id where grupo.id = ?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = conexao.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			stm.setString(1,chave);
			try (ResultSet rs = stm.executeQuery();) {
				while (rs.next()) {
					aluno = new Aluno(0, null, null, null, 0, null);
					aluno.setId(rs.getInt("aluno_id"));
					aluno.setNome(rs.getString("nome"));
					aluno.setRa(rs.getString("ra"));
					
					lista.add(aluno);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return lista;
	}
	
	
	public Boolean carregarTurma(int id) {
		Aluno aluno = new Aluno(id, null, null, null, id, null);
		aluno.setIdA(id);
	boolean ex = false;
		String sqlSelect = "SELECT * FROM turma_Aluno where Aluno_id = ?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = conexao.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			stm.setInt(1, aluno.getIdA());
			try (ResultSet rs = stm.executeQuery();) {
				if (rs.next()) {
					aluno.setId(rs.getInt("id"));
					aluno.setIdA(rs.getInt("aluno_id"));
					aluno.setNome(rs.getString("nome"));
					aluno.setEmail(rs.getString("email"));
					aluno.setRa(rs.getString("ra"));
					aluno.setSenha(rs.getString("senha"));
					ex = true;
				} else {
					
					aluno.setIdA(-1);
				ex = false;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return ex;
	}

}


