package cl.inacap.registroCivilApp.controllers;

import java.io.IOException;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cl.inacap.RegistroCivilModel.dao.solicitudesDAOLocal;
import cl.inacap.RegistroCivilModel.dto.Solicitud;

/**
 * Servlet implementation class AtenderSolicitudController
 */
@WebServlet("/AtenderSolicitudController.do")
public class AtenderSolicitudController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Inject
	private solicitudesDAOLocal solicitudesDAO;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AtenderSolicitudController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		if(request.getParameter("atencionEliminar") != null) {
			String rut = request.getParameter("atencionEliminar").trim();
			List<Solicitud> busqueda = solicitudesDAO.filterByRut(rut);
			Solicitud atencionAEliminar = busqueda.isEmpty()? null:busqueda.get(0);
			if(atencionAEliminar != null) {
				solicitudesDAO.delete(atencionAEliminar);
			}
			
			}
		
		//List<Solicitud> solicitudes = solicitudesDAO.getAll();
		//request.setAttribute("solicitudes", solicitudes);
		
		request.getRequestDispatcher("WEB-INF/vistas/atenderSolicitud.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String tipo = request.getParameter("filtro-select").trim();
		List<Solicitud> solicitudes = solicitudesDAO.filterByType(tipo);
		request.setAttribute("solicitudes", solicitudes);
		doGet(request, response);
		
	}

}
