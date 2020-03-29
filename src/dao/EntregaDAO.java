package dao;


import model.Entrega;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class EntregaDAO {
	
	ConnectionFactory conexao = new ConnectionFactory();
	
	public ArrayList<Entrega> listarEntrega() {
		Entrega entrega;
		ArrayList<Entrega> lista = new ArrayList<>();
		String sqlSelect = "SELECT * FROM entrega";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = conexao.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			try (ResultSet rs = stm.executeQuery();) {
				while (rs.next()) {
					entrega = new Entrega(0, 0, null, 0, null, 0, 0, sqlSelect, null, null, sqlSelect);
					entrega.setId(rs.getInt("id"));
					entrega.setData(rs.getDate("dt_cadastro"));
					lista.add(entrega);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return lista;
		
	}

	public ArrayList<Entrega> listarEntrega(String chave) {
		Entrega entrega;
		ArrayList<Entrega> lista = new ArrayList<>();
		String sqlSelect = "SELECT entrega.id, entrega.dt_cadastro,avaliacao.id,avaliacao.nota,avaliacao.dt_avaliacao,avaliacao.comentarios FROM entrega INNER JOIN avaliacao ON entrega.id = avaliacao.entrega_id INNER JOIN turma_aluno ON avaliacao.turma_aluno_id = turma_aluno.id INNER JOIN grupo ON turma_aluno.grupo_id = grupo.id where grupo.id = ?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = conexao.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			stm.setString(1, chave);
			try (ResultSet rs = stm.executeQuery();) {
				while (rs.next()) {
					entrega = new Entrega(0, 0, null, 0, null, 0, 0, sqlSelect, null, null, sqlSelect);
					entrega.setId(rs.getInt("id"));
					entrega.setData(rs.getDate("dt_cadastro"));
					lista.add(entrega);
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
