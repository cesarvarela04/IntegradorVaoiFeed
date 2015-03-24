package co.edu.usbcali.dataaccess.dao;

import java.util.List;

import co.edu.usbcali.dataaccess.api.Dao;
import co.edu.usbcali.modelo.Colecciones;
import co.edu.usbcali.modelo.dto.ColeccionesDTO;

/**
* Interface for   ColeccionesDAO.
*
*/
public interface IColeccionesDAO extends Dao<Colecciones, Long> {
	
	public List<ColeccionesDTO> coleccionesUsuario(String correo) throws Exception;
	public Long existeColecciones(String nombre) throws Exception;
}
