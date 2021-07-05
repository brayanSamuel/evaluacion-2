package cl.inacap.registroCivilApp.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cl.inacap.RegistroCivilModel.dao.solicitudesDAOLocal;
import cl.inacap.RegistroCivilModel.dto.Solicitud;


/**
 * Servlet implementation class IngresarSolicitudController
 */
@WebServlet("/IngresarSolicitudController.do")
public class IngresarSolicitudController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Inject
	private solicitudesDAOLocal solicitudesDAO;
	private AtomicInteger id= new AtomicInteger(0);
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public IngresarSolicitudController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("WEB-INF/vistas/ingresarSolicitud.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List<String> errores = new ArrayList<>();

		String rut = request.getParameter("rut-txt").trim();
		if (rut.isEmpty()) {
			errores.add("Debe ingresar un rut");
		}else {
			List<Solicitud> p = solicitudesDAO.getAll();
			int n,m,v=2,s=0,rutAux;
			String d1;
			
				try {
					rutAux = Integer.parseInt(rut.substring(0,rut.length()-1));
					n = rut.length()-1;
					
					while(n>=1) {
						m= Integer.parseInt(rut.substring(n-1,n))*v;
						s=s+m;
						++v;
						if(v>7) {
							v=2;
						}
						--n;
					}
					d1 = Integer.toString(11-(s%11)).toLowerCase();
					switch(d1) {
					case "10": d1="k";
					break;
					case "11": d1="0";
					break;
					
					}
					if(rutAux != 0) {
						boolean contiene =false;

						if(rut.substring(rut.length()-1).equals(d1)) {
								contiene = true;
							}
						if(!contiene) {
							errores.add("Digito verificador inválido");
						}
					}
					
					
					for(Solicitud i: p) {
						if(i.getRut().equalsIgnoreCase(rut)) {
							errores.add("Ya hay un cliente con ese rut");
						}
					}
					
				}catch(Exception ex) {
					errores.add("Rut inválido");
				}
		}
		
		
		String nombre = request.getParameter("nombre-txt").trim();
		String[] palabras=nombre.split(" ");
		if (nombre.isEmpty()) {
			errores.add("Debe ingresar un Nombre y Apellido");
		}else {
			
			if(palabras.length< 2) {
				errores.add("ingrese nombre y apellido separado por un espacio");
			}
		}
		String tipo = request.getParameter("tipo-select").trim();
		if (tipo.isEmpty()) {
			errores.add("Debe ingresar un tipo de solicitud");
		}
		if (tipo.contains("Retiro de cedula de identidad")) {
//			request.setAttribute("condicion", "en el caso de retiro de cedula de identidad, ingrese numero de solicitud original");

			String condicion = request.getParameter("condicion-txt").trim();
			if (condicion.isEmpty() || ((Integer.parseInt(condicion)) <= 0)) {
				errores.add("Debe ingresar un numero valido de Solicitud de cedula de identitad");
			}
		}
		if (errores.isEmpty()) {
			Solicitud solicitud = new Solicitud();
			solicitud.setRut(rut);
			solicitud.setNombre(nombre);
			solicitud.setTipo(tipo);
			solicitud.setId(id.incrementAndGet());
			solicitudesDAO.save(solicitud);
			request.setAttribute("mensaje", "solicitud ingresada exitosamente -->N° de solicitud: "+id);
			request.getRequestDispatcher("WEB-INF/vistas/atenderSolicitud.jsp").forward(request, response);
			
		} else {
			request.setAttribute("errores", errores);
		}
		doGet(request, response);
		
		

	}

}
