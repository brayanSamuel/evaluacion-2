package cl.inacap.RegistroCivilModel.dao;

import java.util.List;

import javax.ejb.Local;

import cl.inacap.RegistroCivilModel.dto.Solicitud;

@Local
public interface solicitudesDAOLocal {
	 void save(Solicitud solicitud);
	 List<Solicitud> getAll();
	 void delete(Solicitud solicitud);
	 List<Solicitud> filterByType(String tipo);
	 List<Solicitud> filterByRut(String rut);
	 
}
