package controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import modelo.Reserva;
import modelo.ReservaModelo;

/**
 * Servlet implementation class AlmacenarReserva
 */
@WebServlet("/AlmacenarReserva")
public class AlmacenarReserva extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AlmacenarReserva() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession(); 
		
		//coger el atributo de la session 
		
		Reserva reserva = (Reserva) session.getAttribute("reserva"); 
		
		//crear reserva modelo 
		
		ReservaModelo reservaModelo = new ReservaModelo(); 
		
		//hacer un insert de reserva
		reservaModelo.insert(reserva); 
		
		//limpiar session aka eliminar
		session.removeAttribute("reserva");
		
		//enviar pagina de confirmacion 
		request.getRequestDispatcher("confirmacion.jsp").forward(request, response);
		

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
