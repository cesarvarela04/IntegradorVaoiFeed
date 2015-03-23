package co.edu.usbcali.dataaccess.dao;

import co.edu.usbcali.dataaccess.api.Dao;
import co.edu.usbcali.modelo.Usuarios;
import co.edu.usbcali.modelo.dto.UsuariosDTO;


/**
* Interface for   UsuariosDAO.
*
*/
public interface IUsuariosDAO extends Dao<Usuarios, Long> {
	public UsuariosDTO loginUsario(String correo, String pass) throws Exception;
	public Long existeCorreo(String correo)throws Exception;
	public UsuariosDTO consultaUsuarioXEmail(String correo)throws Exception;
}
