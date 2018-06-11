package modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.PreparedStatement;

public class ParcelaModelo extends Conector {

	public ArrayList<Parcela> selectAll(){
		
			ArrayList<Parcela> parcelas = new ArrayList<Parcela>(); 
			
		try {
			
			PreparedStatement pst = (PreparedStatement) super.conexion.prepareStatement("select * from parcelas");
			
			ResultSet rs = pst.executeQuery(); 
			
			while(rs.next()){
				Parcela parcela = new Parcela(); 
				parcela.setId(rs.getInt("id"));
				parcela.setNumero(rs.getString("numero"));
				parcela.setM_cuadrados(rs.getInt("m_cuadrados"));
				parcela.setPrecio_dia(rs.getDouble("precio_dia"));
				parcelas.add(parcela); 
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return parcelas; 
		
	}
	
	public Parcela selectPorId(int idParcela){
		
		try {
			
			PreparedStatement pst = (PreparedStatement) super.conexion.prepareStatement("select * from parcelas where id=?");
			pst.setInt(1, idParcela);
			ResultSet rs = pst.executeQuery(); 
			
			if(rs.next()){
				Parcela parcela = new Parcela(); 
				parcela.setId(rs.getInt("id"));
				parcela.setNumero(rs.getString("numero"));
				parcela.setM_cuadrados(rs.getInt("m_cuadrados"));
				parcela.setPrecio_dia(rs.getDouble("precio_dia"));
				
				return parcela; 
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null; 
		
	}
}
