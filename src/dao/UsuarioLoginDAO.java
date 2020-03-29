package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.UsuarioLogin;
public class UsuarioLoginDAO {
public boolean validar(UsuarioLogin usuarioLogin) {
	String sqlSelect = "SELECT email, senha FROM usuario WHERE email = ? and senha = ?";

	try {
		ConnectionFactory conexao = new ConnectionFactory();
		Connection conn = conexao.obtemConexao();

		try (PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			stm.setString(1, usuarioLogin.getUsername());
			stm.setString(2, usuarioLogin.getPassword());
			try (ResultSet rs = stm.executeQuery();) { if (rs.next()) {
				return true;
			} else {
				return false;
			}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
	} catch (SQLException e2) {
		e2.printStackTrace();
	}
	return false;
	}
}
