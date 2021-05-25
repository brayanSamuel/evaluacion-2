package cl.inacap.RegistroCivilModel.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import cl.inacap.RegistroCivilModel.dto.Solicitud;

/**
 * Session Bean implementation class solicitudesDAO
 */
@Stateless
@LocalBean
public class solicitudesDAO implements solicitudesDAOLocal {

	
	private static List<Solicitud> solicitudes = new ArrayList<>();
   

	@Override
	public void save(Solicitud solicitud) {
		solicitudes.add(solicitud);
	}

	@Override
	public List<Solicitud> getAll() {
		// TODO Auto-generated method stub
		return solicitudes;
	}

	@Override
	public void delete(Solicitud solicitud) {
		solicitudes.remove(solicitud);
	}

	@Override
	public List<Solicitud> filterByType(String tipo) {
		// TODO Auto-generated method stub
		return solicitudes.stream().filter(s->s.getTipo().contains(tipo)).collect(Collectors.toList());
	}

	@Override
	public List<Solicitud> filterByRut(String rut) {
		// TODO Auto-generated method stub
		return solicitudes.stream().filter(s->s.getRut().contains(rut)).collect(Collectors.toList());
	}


}
