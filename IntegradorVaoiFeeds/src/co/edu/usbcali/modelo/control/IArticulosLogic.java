package co.edu.usbcali.modelo.control;

import java.util.List;

import co.edu.usbcali.modelo.Articulos;
import co.edu.usbcali.modelo.dto.ArticulosDTO;


/**
* @author Zathura Code Generator http://code.google.com/p/zathura
* www.zathuracode.org
*
*/
public interface IArticulosLogic {
    public List<Articulos> getArticulos() throws Exception;

    /**
         * Save an new Articulos entity
         */
    public void saveArticulos(Articulos entity) throws Exception;

    /**
         * Delete an existing Articulos entity
         *
         */
    public void deleteArticulos(Articulos entity) throws Exception;

    /**
        * Update an existing Articulos entity
        *
        */
    public void updateArticulos(Articulos entity) throws Exception;

    /**
         * Load an existing Articulos entity
         *
         */
    public Articulos getArticulos(Long codigoArti) throws Exception;

    public List<Articulos> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<Articulos> findPageArticulos(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberArticulos() throws Exception;

    public List<ArticulosDTO> getDataArticulos() throws Exception;
}
