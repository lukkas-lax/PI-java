package dao;

import model.Avaliacao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;




public class AvaliacaoDAO {
   ConnectionFactory conexao = new ConnectionFactory();
   
   
	/*public Avaliacao carregar(int id) {
		Avaliacao avaliacao = new Avaliacao(0, 0, null, null);
		avaliacao.setId(id);
		String sqlSelect = "SELECT aluno.aluno_id, aluno.ra,usuario.nome,usuario.email,usuario.senha,usuario.id  FROM usuario INNER JOIN aluno ON usuario.id = aluno.aluno_id WHERE aluno.aluno_id = ?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = conexao.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			stm.setInt(1, avaliacao.getIdA());
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
	}*/
	
	
	
	
	public ArrayList<Avaliacao> listarAvaliacao() {
		Avaliacao avaliacao;
		ArrayList<Avaliacao> lista = new ArrayList<>();
		String sqlSelect = "SELECT * FROM avaliacao";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = conexao.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			try (ResultSet rs = stm.executeQuery();) {
				while (rs.next()) {
					avaliacao = new Avaliacao(0, 0, null, null, 0, 0, null, null, 0, 0, null, null, null, null, null);
					avaliacao.setId(rs.getInt("id"));
					avaliacao.setNota(rs.getDouble("nota"));
					avaliacao.setDt_avaliacao(rs.getDate("dt_avaliacao"));
					avaliacao.setComentarios(rs.getString("comentarios"));
					lista.add(avaliacao);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return lista;
		
	}

	public ArrayList<Avaliacao> listarAvaliacao(String chave) {
		Avaliacao avaliacao;
		ArrayList<Avaliacao> lista = new ArrayList<>();
		String sqlSelect = "SELECT atividade.numero,entrega.id, entrega.dt_cadastro,avaliacao.id,avaliacao.nota,avaliacao.dt_avaliacao,avaliacao.comentarios, usuario.nome FROM atividade INNER JOIN entrega ON atividade.id = entrega.atividade_id INNER JOIN avaliacao ON entrega.id = avaliacao.entrega_id INNER JOIN turma_aluno ON avaliacao.turma_aluno_id = turma_aluno.id INNER JOIN usuario ON turma_aluno.Aluno_id = usuario.id  INNER JOIN grupo ON turma_aluno.grupo_id = grupo.id where grupo.id = ? GROUP BY numero";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = conexao.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			stm.setString(1, chave);
			try (ResultSet rs = stm.executeQuery();) {
				while (rs.next()) {
					avaliacao = new Avaliacao(0, 0, null, null, 0, 0, null, null, 0, 0, null, null, null, null, null);
					avaliacao.setId(rs.getInt("id"));
					avaliacao.setNumero(rs.getInt("numero"));
					avaliacao.setData(rs.getDate("dt_cadastro"));
					avaliacao.setNota(rs.getDouble("nota"));
					avaliacao.setDt_avaliacao(rs.getDate("dt_avaliacao"));
					avaliacao.setComentarios(rs.getString("comentarios"));
					avaliacao.setNome_aluno(rs.getString("nome"));
					lista.add(avaliacao);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return lista;
	}
	
	
}
