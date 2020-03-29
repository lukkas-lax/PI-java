package dao;



import model.Professor;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProfessorDAO {
	
	ConnectionFactory conexao = new ConnectionFactory();
	   
	
	
	   
	
	
	
	
	
	public ArrayList<Professor> listarProfessor() {
		Professor professor;
		ArrayList<Professor> listaPr = new ArrayList<>();
		String sqlSelect = "SELECT usuario.nome, usuario.id, professor.matricula FROM usuario INNER JOIN professor ON usuario.id = professor.professor_id";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = conexao.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			try (ResultSet rs = stm.executeQuery();) {
				while (rs.next()) {
					professor = new Professor(0, null, null, null, 0, 0, null);
					professor.setIdP(rs.getInt("id"));
					professor.setId(rs.getInt("id"));
					professor.setNome(rs.getString("nome"));
					professor.setMatricula(rs.getString("matricula"));
					listaPr.add(professor);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return listaPr;
	}

	public ArrayList<Professor> listarProfessor(String chave) {
		Professor professor;
		ArrayList<Professor> listaPr = new ArrayList<>();
		String sqlSelect =  "SELECT usuario.nome, usuario.id, professor.matricula  FROM usuario INNER JOIN professor ON usuario.id = professor.professor_id where usuario.nome like ?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = conexao.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			stm.setString(1, "%" + chave.toUpperCase() + "%");
			try (ResultSet rs = stm.executeQuery();) {
				while (rs.next()) {
					professor = new Professor(0, null, null, null, 0, 0, null);
					professor.setIdP(rs.getInt("id"));
					professor.setId(rs.getInt("id"));
					professor.setNome(rs.getString("nome"));
					professor.setMatricula(rs.getString("matricula"));
					listaPr.add(professor);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return listaPr;
	}
	
	public Professor carregar(int id) {
		Professor professor = new Professor(id, null, null, null, id, 0, null);
		professor.setId(id);
		String sqlSelect = "SELECT usuario.nome, usuario.id, professor.matricula  FROM usuario INNER JOIN professor ON usuario.id = professor.professor_id where usuario.id = ?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = conexao.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			stm.setInt(1, professor.getId());
			try (ResultSet rs = stm.executeQuery();) {
				if (rs.next()) {
					professor.setId(rs.getInt("id"));					
					professor.setNome(rs.getString("nome"));
					
				} else {
					
					professor.setId(-1);
					professor.setNome(null);
					
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return professor;
	}

}
