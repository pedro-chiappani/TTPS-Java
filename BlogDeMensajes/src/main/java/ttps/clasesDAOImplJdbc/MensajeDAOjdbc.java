package ttps.clasesDAOImplJdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ttps.clasesDAO.MensajeDAO;
import ttps.clasesDeObjetosDelSistema.Mensaje;
import ttps.dataSource.MiDataSource;

public class MensajeDAOjdbc implements MensajeDAO {
	
	public Mensaje recuperar(Long identificacion) {
		 Mensaje mensaje = null;
		 try{
		 Connection con = MiDataSource.getDataSource().getConnection(); 
		 Statement st = con.createStatement();
		 ResultSet rs= st.executeQuery("Select u from mensajes where u.id='"+identificacion+"'");
		 if (rs.next()==true) {

			 mensaje = new Mensaje();
			 mensaje.setId(rs.getLong(1));
			 mensaje.setMensaje(rs.getString(2));
			 UsuarioDAOjdbc u = new UsuarioDAOjdbc();
			 mensaje.setUsuario(u.recuperar(rs.getLong(3)));
		 }
		 rs.close();
		 st.close();
		 con.close();
		 } catch (java.sql.SQLException e) {
		 System.out.println("Error de SQL: "+e.getMessage());
		 }
		 return mensaje;
		 }
	
	@Override
   public List<Mensaje> recuperarTodos() {
       List<Mensaje> mensajes = new ArrayList<>();
       String query = "SELECT * FROM usuarios";
       
       try ( 
       		Connection con = MiDataSource.getDataSource().getConnection(); 
      		 Statement st = con.createStatement();
            ResultSet resultSet = st.executeQuery("select * from mensaje")) {
           
           while (resultSet.next()) {
               Mensaje mensaje = new Mensaje();
               mensaje.setId(resultSet.getLong(1));
               mensaje.setMensaje(resultSet.getString(2));
               UsuarioDAOjdbc u = new UsuarioDAOjdbc();
               mensaje.setUsuario(u.recuperar(resultSet.getLong(3)));
               mensajes.add(mensaje);
           }
           st.close();
  		 	con.close();
       } catch (java.sql.SQLException e) {
           e.printStackTrace();
       }
       
       return mensajes;
   }

   @Override
   public void guardar(Mensaje msj) {
       String query = "INSERT INTO mensajes (mensaje, usuario_id) VALUES (?, ?)";
       
       try (Connection con = MiDataSource.getDataSource().getConnection();
       		CallableStatement statement = con.prepareCall(query)) {
           statement.setString(1, msj.getMensaje());
           statement.setLong(2, msj.getUsuario().getId());
           statement.executeUpdate();
           statement.close();
  		 	con.close();
       } catch (java.sql.SQLException e) {
           e.printStackTrace();
       }
   }

   @Override
   public void actualizar(Mensaje msj) {
       String query = "UPDATE mensajes SET nombre = ?, dni = ? WHERE id = ?";
       
       try (Connection con = MiDataSource.getDataSource().getConnection();
       		CallableStatement statement = con.prepareCall(query)) {
           statement.setString(1, msj.getNombre());
           statement.setInt(2, msj.getDni());
           statement.setLong(3, msj.getId());
           statement.executeUpdate();
           statement.close();
  		 con.close();
       } catch (java.sql.SQLException e) {
           e.printStackTrace();
       }
   }

   @Override
   public void borrar(Usuario u) {
       String query = "DELETE FROM usuarios WHERE id = ?";
       
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
}
