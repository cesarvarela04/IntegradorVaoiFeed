package co.edu.usbcali.modelo.control;

import java.util.List;

import co.edu.usbcali.modelo.Usuarios;
import co.edu.usbcali.modelo.dto.UsuariosDTO;


/**
* @author Zathura Code Generator http://code.google.com/p/zathura
* www.zathuracode.org
*
*/
public interface IUsuariosLogic {
    public List<Usuarios> getUsuarios() throws Exception;

    /**
         * Save an new Usuarios entity
         */
    public void saveUsuarios(Usuarios entity) throws Exception;

    /**
         * Delete an existing Usuarios entity
         *
         */
    public void deleteUsuarios(Usuarios entity) throws Exception;

    /**
        * Update an existing Usuarios entity
        *
        */
    public void updateUsuarios(Usuarios entity) throws Exception;

    /**
         * Load an existing Usuarios entity
         *
         */
    public Usuarios getUsuarios(Long codigoUsua) throws Exception;

    public List<Usuarios> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<Usuarios> findPageUsuarios(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberUsuarios() throws Exception;

    public List<UsuariosDTO> getDataUsuarios() throws Exception;
    
    public UsuariosDTO loginUsario(String correo, String pass) throws Exception;
    
    public Long existeCorreo(String correo) throws Exception;
    
	public UsuariosDTO consultaUsuarioXEmail(String correo)throws Exception;
}
