package ttps.clasesDAOImplJdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ttps.clasesDAO.UsuarioDAO;
import ttps.clasesDeObjetosDelSistema.Usuario;
import ttps.dataSource.MiDataSource;

public class UsuarioDAOJdbc implements UsuarioDAO {

	@Override
	public Usuario recuperar(Long identificacion) {
		Usuario usuario = null;
		try {
			Connection con = MiDataSource.getDataSource().getConnection();
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("Select * from usuario where id='" + identificacion + "'");
			if (rs.next() == true) {
				usuario = new Usuario();
				usuario.setId(rs.getLong(1));
				usuario.setNombre(rs.getString(2));
			}
			rs.close();
			st.close();
			con.close();
		} catch (java.sql.SQLException e) {
			System.out.println("Error de SQL: " + e.getMessage());
		}
		return usuario;
	}

	@Override
	public List<Usuario> recuperarTodos() {
		List<Usuario> users = new ArrayList<>();
		String query = "SELECT * FROM usuario";

		try (Connection con = MiDataSource.getDataSource().getConnection();
				Statement st = con.createStatement();
				ResultSet resultSet = st.executeQuery("select * from usuario")) {

			while (resultSet.next()) {
				Usuario user = new Usuario();
				user.setId(resultSet.getLong(1));
				user.setNombre(resultSet.getString(2));
				users.add(user);
			}
			st.close();
			con.close();
		} catch (java.sql.SQLException e) {
			e.printStackTrace();
		}

		return users;
	}

	@Override
	public Usuario recuperarPorNombre(String unNombre) {
		Usuario usuario = null;
		try {
			Connection con = MiDataSource.getDataSource().getConnection();
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("Select * from usuario where nombre='" + unNombre + "'");
			if (rs.next() == true) {
				usuario = new Usuario();
				usuario.setId(rs.getLong(1));
				usuario.setNombre(rs.getString(2));
				
				rs.close();
				st.close();
				con.close();
				
				return usuario;
			} else {
				rs.close();
				st.close();
				con.close();
				
				return null;
			}
		} catch (java.sql.SQLException e) {
			System.out.println("Error de SQL: " + e.getMessage());
		}
		return usuario;
	}

	@Override
	public void guardar(Usuario user) {
		String query = "INSERT INTO usuario (nombre) VALUES (?)";

		try (Connection con = MiDataSource.getDataSource().getConnection();
				CallableStatement statement = con.prepareCall(query)) {
			statement.setString(1, user.getNombre());
			statement.executeUpdate();
			statement.close();
			con.close();
		} catch (java.sql.SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void actualizar(Usuario user) {
		String query = "UPDATE usuario SET nombre = ? WHERE id = ?";

		try (Connection con = MiDataSource.getDataSource().getConnection();
				CallableStatement statement = con.prepareCall(query)) {
			statement.setString(1, user.getNombre());
			statement.setLong(3, user.getId());
			statement.executeUpdate();
			statement.close();
			con.close();
		} catch (java.sql.SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void borrar(Usuario u) {
		String query = "DELETE FROM usuario WHERE id = ?";

		try (Connection con = MiDataSource.getDataSource().getConnection();
				CallableStatement statement = con.prepareCall(query)) {
			statement.setLong(1, u.getId());
			statement.executeUpdate();
			statement.close();
			con.close();
		} catch (java.sql.SQLException e) {
			e.printStackTrace();
		}
	}

}