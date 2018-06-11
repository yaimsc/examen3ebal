package modelo;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.PreparedStatement;

public class ReservaModelo extends Conector{

		public Reserva select(String nombre){
			
			ParcelaModelo parcelaModelo = new ParcelaModelo(); 
			
			try {
				PreparedStatement pst = (PreparedStatement) super.conexion.prepareStatement("select nombre from parcelas where nombre = ?");
				pst.setString(1, nombre);
				ResultSet rs = pst.executeQuery(); 
				
				if(rs.next()){
					Reserva reserva = new Reserva(); 
					reserva.setId(rs.getInt("id"));
					reserva.setNombre_usuario(rs.getString("nombre_usuario"));
					reserva.setApellido_usuario(rs.getString("apellido_usuario"));
					reserva.setDni_usuario(rs.getString("dni_usuario"));
					reserva.setFecha_reserva(rs.getDate("fecha_reserva"));
					reserva.setFin_reserva(rs.getDate("fin_reserva"));
					reserva.setLuz(rs.getBoolean("luz")); 
					
					return reserva; 
					
				}
				
			
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			
			return null;
			
		}
		
		
		public void insert(Reserva reserva){
			PreparedStatement pst;
			try {
				pst = (PreparedStatement) super.conexion.prepareStatement("insert into reservas (nombre_usuario, apellido_usuario, dni_usuario, numero_usuarios, inicio_reserva, fin_reserva, luz, id_parcela) values (?,?,?,?,?,?,?,?)");
			
			pst.setString(1, reserva.getNombre_usuario());
			pst.setString(2, reserva.getApellido_usuario());
			pst.setString(3, reserva.getDni_usuario());
			pst.setInt(4, reserva.getNumero_usuarios());
			pst.setDate(5, new java.sql.Date( reserva.getInicio_reserva().getTime())); //para pasar la fecha de java.util a java.sql 
			pst.setDate(6, new java.sql.Date (reserva.getFin_reserva().getTime()));
			pst.setBoolean(7, reserva.getLuz());
			pst.setInt(8, reserva.getParcela().getId());
			
			pst.execute(); 
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
			
	}
}
