package controlador;

import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import modelo.Parcela;
import modelo.ParcelaModelo;
import modelo.Reserva;

/**
 * Servlet implementation class GuardarReservaEnCarrito
 */
@WebServlet("/GuardarReservaEnCarrito")
public class GuardarReservaEnCarrito extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GuardarReservaEnCarrito() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doPost(request,response); 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//declarear las variables de fecha
		java.util.Date fecha_inicio = null; 
		java.util.Date fecha_fin = null; 
				
		//declarar variable luz
		boolean luz = false; 
		
		//pillar los datos que se han metido en el formulario
		
		String nombre = request.getParameter("nombre"); 
		String apellido = request.getParameter("apellido"); 
		String dni = request.getParameter("dni"); 
		int numero_personas = Integer.parseInt(request.getParameter("numero_personas")); 
		
		//hacer simpledtaeformat pàra parsear
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy"); 
		
		try {
			fecha_inicio = sdf.parse(request.getParameter("fecha_inicio"));
			fecha_fin = sdf.parse(request.getParameter("fecha_fin")); 
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		if(request.getParameter("luz") == null){
			luz = false; 
		}else{
			luz = true; 
		}
		
		//crear objeto reserva
		Reserva reserva = new Reserva(); 
		
		reserva.setNombre_usuario(nombre);
		reserva.setApellido_usuario(apellido);
		reserva.setDni_usuario(dni);
		reserva.setNumero_usuarios(numero_personas);
		reserva.setInicio_reserva(fecha_inicio);
		reserva.setFin_reserva(fecha_fin);
		reserva.setLuz(luz);

		
		//pillar los datos de la parcela que se ha elegido realizando con un modelo un selectById con idParcela
		ParcelaModelo parcelaModelo = new ParcelaModelo(); 
		int idParcela = Integer.parseInt(request.getParameter("id_parcela")); 
		Parcela parcela = parcelaModelo.selectPorId(idParcela); 
		reserva.setParcela(parcela); //guardar la parcela en la reserva 
		
		//guardar session
		HttpSession session = request.getSession(); //crea la session
		session.setAttribute("reserva", reserva); //guarda la session en reserva junto con parcela 
		
		//pasar a la vista la parcela y la reserva
		
		request.getRequestDispatcher("infoReserva.jsp").forward(request, response);
		
	}

}
