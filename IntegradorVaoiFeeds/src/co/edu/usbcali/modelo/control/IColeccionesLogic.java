package co.edu.usbcali.modelo.control;

import java.util.List;

import co.edu.usbcali.modelo.Colecciones;
import co.edu.usbcali.modelo.dto.ColeccionesDTO;


/**
* @author Zathura Code Generator http://code.google.com/p/zathura
* www.zathuracode.org
*
*/
public interface IColeccionesLogic {
    public List<Colecciones> getColecciones() throws Exception;

    /**
         * Save an new Colecciones entity
         */
    public void saveColecciones(Colecciones entity) throws Exception;

    /**
         * Delete an existing Colecciones entity
         *
         */
    public void deleteColecciones(Colecciones entity) throws Exception;

    /**
        * Update an existing Colecciones entity
        *
        */
    public void updateColecciones(Colecciones entity) throws Exception;

    /**
         * Load an existing Colecciones entity
         *
         */
    public Colecciones getColecciones(Long codigoCole)
        throws Exception;

    public List<Colecciones> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<Colecciones> findPageColecciones(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberColecciones() throws Exception;

    public List<ColeccionesDTO> getDataColecciones() throws Exception;
    
    public List<ColeccionesDTO> coleccionesUsuario(String correo) throws Exception;
    
    public Long existeColecciones(String nombre) throws Exception;
}
