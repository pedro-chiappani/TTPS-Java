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
			 mensaje.setUsuario((rs.getLong(3)));
		 }
		 rs.close();
		 st.close();
		 con.commit();
		 con.close();
		 } catch (java.sql.SQLException e) {
		 System.out.println("Error de SQL: "+e.getMessage());
		 }
		 return mensaje;
		 }
	
	@Override
   public List<Mensaje> recuperarTodos() {
       List<Mensaje> mensajes = new ArrayList<>();
       String query = "SELECT * FROM mensajes";
       
       try ( 
       		Connection con = MiDataSource.getDataSource().getConnection(); 
      		 Statement st = con.createStatement();
            ResultSet resultSet = st.executeQuery("select * from mensajes")) {
           
           while (resultSet.next()) {
               Mensaje mensaje = new Mensaje();
               mensaje.setId(resultSet.getLong(1));
               mensaje.setMensaje(resultSet.getString(2));
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
       String query = "INSERT INTO mensajes (mensaje, usuario) VALUES (?, ?)";
       
       try (Connection con = MiDataSource.getDataSource().getConnection();
       		CallableStatement statement = con.prepareCall(query)) {
           statement.setString(1, msj.getMensaje());
           statement.setLong(2, msj.getUsuario());
           statement.executeUpdate();
           statement.close();
           con.commit();
  		 con.close();
       } catch (java.sql.SQLException e) {
           e.printStackTrace();
       }
   }

   @Override
   public void actualizar(Mensaje msj) {
       String query = "UPDATE mensajes SET mensaje = ?, usuario_id = ? WHERE id = ?";
       
       try (Connection con = MiDataSource.getDataSource().getConnection();
       		CallableStatement statement = con.prepareCall(query)) {
           statement.setString(1, msj.getMensaje());
           statement.setLong(2, msj.getUsuario());
           statement.setLong(3, msj.getId());
           statement.executeUpdate();
           statement.close();
  		 con.close();
       } catch (java.sql.SQLException e) {
           e.printStackTrace();
       }
   }

   @Override
   public void borrar(Mensaje msj) {
       String query = "DELETE FROM mensajes WHERE id = ?";
       
       try (Connection con = MiDataSource.getDataSource().getConnection();
       		CallableStatement statement = con.prepareCall(query)) {
           statement.setLong(1, msj.getId());
           statement.executeUpdate();
           statement.close();
  		 con.close();
       } catch (java.sql.SQLException e) {
           e.printStackTrace();
       }
   }


}
