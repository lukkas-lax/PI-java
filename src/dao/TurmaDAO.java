package dao;


import model.Aluno;
import model.Turma;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class TurmaDAO {
	
	ConnectionFactory conexao = new ConnectionFactory();
	   
	
	 public void incluir(Aluno to,Turma tu) {
		   String sqlInsert = "INSERT INTO turma_aluno(aluno_id,turma_id) VALUES (?,?)";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = conexao.obtemConexao();
		PreparedStatement stm = conn.prepareStatement(sqlInsert)){ 
		stm.setInt(1, to.getIdA());
		stm.setInt(2, tu.getId());
		stm.execute();
		} catch (SQLException e) {
		     e.printStackTrace();
		   }
		}
	
	   
		public Turma carregar(int id) {
			Turma turma = new Turma(0, 0, 0, null, 0, null);
			turma.setId(id);
			String sqlSelect = "SELECT * FROM turma WHERE id = ?";
			// usando o try with resources do Java 7, que fecha o que abriu
			try (Connection conn = conexao.obtemConexao();
					PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
				stm.setInt(1, turma.getId());
				try (ResultSet rs = stm.executeQuery();) {
					if (rs.next()) {
						turma.setId(rs.getInt("id"));
						turma.setSemestre_letivo(rs.getInt("semestre_letivo"));
						turma.setAno_letivo(rs.getInt("ano_letivo"));
						turma.setSigla(rs.getString("sigla"));
						turma.setTema_id(rs.getInt("tema_id"));
				
					} else {
						
						turma.setId(-1);
						turma.setSemestre_letivo(-1);
						turma.setAno_letivo(-1);
						turma.setSigla(null);
						turma.setTema_id(-1);
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			} catch (SQLException e1) {
				System.out.print(e1.getStackTrace());
			}
			return turma;
		}
		
		
		public Turma carregarSigla(String sig) {
			Turma turma = new Turma(0, 0, 0, null, 0, null);
			turma.setSigla(sig);
			String sqlSelect = "SELECT * FROM turma WHERE sigla like ?";
			// usando o try with resources do Java 7, que fecha o que abriu
			try (Connection conn = conexao.obtemConexao();
					PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
				stm.setString(1, turma.getSigla());
				try (ResultSet rs = stm.executeQuery();) {
					if (rs.next()) {
						turma.setId(rs.getInt("id"));
						turma.setSemestre_letivo(rs.getInt("semestre_letivo"));
						turma.setAno_letivo(rs.getInt("ano_letivo"));
						turma.setSigla(rs.getString("sigla"));
						turma.setTema_id(rs.getInt("tema_id"));
				
					} else {
						
						turma.setId(-1);
						turma.setSemestre_letivo(-1);
						turma.setAno_letivo(-1);
						turma.setSigla(null);
						turma.setTema_id(-1);
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			} catch (SQLException e1) {
				System.out.print(e1.getStackTrace());
			}
			return turma;
		}
		
		
		
		
		public ArrayList<Turma> listarTurmas() {
			Turma turma;
			ArrayList<Turma> lista1 = new ArrayList<>();
			String sqlSelect = "SELECT * FROM turma";
			// usando o try with resources do Java 7, que fecha o que abriu
			try (Connection conn = conexao.obtemConexao();
					PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
				try (ResultSet rs = stm.executeQuery();) {
					while (rs.next()) {
						turma = new Turma(0, 0, 0, null, 0, null);
						turma.setId(rs.getInt("id"));
						turma.setSemestre_letivo(rs.getInt("semestre_letivo"));
						turma.setAno_letivo(rs.getInt("ano_letivo"));
						turma.setSigla(rs.getString("sigla"));
						turma.setTema_id(rs.getInt("tema_id"));
						lista1.add(turma);
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			} catch (SQLException e1) {
				System.out.print(e1.getStackTrace());
			}
			return lista1;
		}

		public ArrayList<Turma> listarTurmas(String chave) {
			Turma turma;
			ArrayList<Turma> lista1 = new ArrayList<>();
			String sqlSelect = "SELECT * FROM turma WHERE semestre_letivo = ?";
			// usando o try with resources do Java 7, que fecha o que abriu
			try (Connection conn = conexao.obtemConexao();
					PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
				stm.setString(1, "%" + chave.toUpperCase() + "%");
				try (ResultSet rs = stm.executeQuery();) {
					while (rs.next()) {
						turma = new Turma(0, 0, 0, null, 0, null);
						turma.setId(rs.getInt("id"));
						turma.setSemestre_letivo(rs.getInt("semestre_letivo"));
						turma.setAno_letivo(rs.getInt("ano_letivo"));
						turma.setSigla(rs.getString("sigla"));
						turma.setTema_id(rs.getInt("tema_id"));
						lista1.add(turma);
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			} catch (SQLException e1) {
				System.out.print(e1.getStackTrace());
			}
			return lista1;
		}
		
		
		public ArrayList<Turma> listarTurmasProf(String chave) {
			Turma turma;
			ArrayList<Turma> lista1 = new ArrayList<>();
			String sqlSelect = "SELECT * FROM turma INNER JOIN turma_aluno ON turma.id = turma_aluno.turma_id INNER JOIN grupo ON turma_aluno.grupo_id = grupo.id INNER JOIN professor ON grupo.orientador_id = professor.professor_id INNER JOIN usuario ON professor.professor_id = usuario.id WHERE usuario.id = ?";
			// usando o try with resources do Java 7, que fecha o que abriu
			try (Connection conn = conexao.obtemConexao();
					PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
				stm.setString(1,chave);
				try (ResultSet rs = stm.executeQuery();) {
					while (rs.next()) {
						turma = new Turma(0, 0, 0, null, 0, null);
						turma.setId(rs.getInt("id"));
						turma.setSemestre_letivo(rs.getInt("semestre_letivo"));
						turma.setAno_letivo(rs.getInt("ano_letivo"));
						turma.setSigla(rs.getString("sigla"));
						turma.setTema_id(rs.getInt("tema_id"));
						lista1.add(turma);
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			} catch (SQLException e1) {
				System.out.print(e1.getStackTrace());
			}
			return lista1;
		}
		
		public ArrayList<Turma> listarTurmasP(String chave) {
			Turma turma;
			ArrayList<Turma> lista1 = new ArrayList<>();
			String sqlSelect = "SELECT turma.id,turma.sigla,turma.ano_letivo,turma.semestre_letivo FROM turma INNER JOIN turma_aluno ON turma.id = turma_aluno.turma_id INNER JOIN grupo ON turma_aluno.grupo_id = grupo.id INNER JOIN professor ON grupo.orientador_id = professor.professor_id INNER JOIN usuario ON professor.professor_id = usuario.id WHERE usuario.nome like ? GROUP BY sigla";
			// usando o try with resources do Java 7, que fecha o que abriu
			try (Connection conn = conexao.obtemConexao();
					PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
				stm.setString(1, "%" + chave.toUpperCase() + "%");
				try (ResultSet rs = stm.executeQuery();) {
					while (rs.next()) {
						turma = new Turma(0, 0, 0, null, 0, null);
						turma.setId(rs.getInt("id"));
						turma.setSemestre_letivo(rs.getInt("semestre_letivo"));
						turma.setAno_letivo(rs.getInt("ano_letivo"));
						turma.setSigla(rs.getString("sigla"));
						lista1.add(turma);
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			} catch (SQLException e1) {
				System.out.print(e1.getStackTrace());
			}
			return lista1;
		}
		
		public ArrayList<Turma> listarTurmasP() {
			Turma turma;
			ArrayList<Turma> lista1 = new ArrayList<>();
			String sqlSelect = "SELECT * FROM turma INNER JOIN turma_aluno ON turma.id = turma_aluno.turma_id INNER JOIN grupo ON turma_aluno.grupo_id = grupo.id INNER JOIN professor ON grupo.orientador_id = professor.professor_id INNER JOIN usuario ON professor.professor_id = usuario.id GROUP BY sigla";
			// usando o try with resources do Java 7, que fecha o que abriu
			try (Connection conn = conexao.obtemConexao();
					PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
				
				try (ResultSet rs = stm.executeQuery();) {
					while (rs.next()) {
						turma = new Turma(0, 0, 0, null, 0, null);
						turma.setId(rs.getInt("id"));
						turma.setSemestre_letivo(rs.getInt("semestre_letivo"));
						turma.setAno_letivo(rs.getInt("ano_letivo"));
						turma.setSigla(rs.getString("sigla"));
						turma.setTema_id(rs.getInt("tema_id"));
						lista1.add(turma);
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			} catch (SQLException e1) {
				System.out.print(e1.getStackTrace());
			}
			return lista1;
		}

}
