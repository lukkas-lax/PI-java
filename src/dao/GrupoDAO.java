package dao;

import model.Grupo;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class GrupoDAO {
	
	ConnectionFactory conexao = new ConnectionFactory();
	   
	
	
	   
		public Grupo carregar(int id) {
			Grupo grupo = new Grupo (0, 0, 0, null);
			grupo.setGrupo_id(id);
			String sqlSelect = "SELECT * FROM grupo WHERE id = ?";
			// usando o try with resources do Java 7, que fecha o que abriu
			try (Connection conn = conexao.obtemConexao();
					PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
				stm.setInt(1, grupo.getGrupo_id());
				try (ResultSet rs = stm.executeQuery();) {
					if (rs.next()) {
						grupo.setGrupo_id(rs.getInt("id"));
						grupo.setOrientador_id(rs.getInt("orientador_id"));
						grupo.setNumero(rs.getInt("numero"));
						grupo.setNome(rs.getString("nome"));
						
					} else {
						
						grupo.setGrupo_id(-1);
						grupo.setOrientador_id(-1);
						grupo.setNumero(-1);
						grupo.setNome(null);
						
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			} catch (SQLException e1) {
				System.out.print(e1.getStackTrace());
			}
			return grupo;
		}
		
		
		
		
		public ArrayList<Grupo> listarGrupos() {
			Grupo grupo;
			ArrayList<Grupo> listaGr = new ArrayList<>();
			String sqlSelect = "SELECT * FROM grupo GROUP BY nome";
			// usando o try with resources do Java 7, que fecha o que abriu
			try (Connection conn = conexao.obtemConexao();
					PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
				try (ResultSet rs = stm.executeQuery();) {
					while (rs.next()) {
						grupo = new Grupo(0, 0, 0, null);
						grupo.setGrupo_id(rs.getInt("id"));
						grupo.setNumero(rs.getInt("numero"));
						grupo.setNome(rs.getString("nome"));
						listaGr.add(grupo);
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			} catch (SQLException e1) {
				System.out.print(e1.getStackTrace());
			}
			return listaGr;
		}

		public ArrayList<Grupo> listarGrupos(String chave) {
			Grupo grupo;
			ArrayList<Grupo> listaGr = new ArrayList<>();
			String sqlSelect =  "SELECT grupo.numero, grupo.nome, grupo.id FROM grupo INNER JOIN turma_aluno ON grupo.id = turma_aluno.grupo_id INNER JOIN turma ON turma_aluno.turma_id = turma.id where turma.id = ? GROUP BY nome";
			// usando o try with resources do Java 7, que fecha o que abriu
			try (Connection conn = conexao.obtemConexao();
					PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
				stm.setString(1, chave);
				try (ResultSet rs = stm.executeQuery();) {
					while (rs.next()) {
						grupo = new Grupo(0, 0, 0, null);
						grupo.setGrupo_id(rs.getInt("id"));
						grupo.setNumero(rs.getInt("numero"));
						grupo.setNome(rs.getString("nome"));
						listaGr.add(grupo);
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			} catch (SQLException e1) {
				System.out.print(e1.getStackTrace());
			}
			return listaGr;
		}

}
