package co.edu.usbcali.modelo.control;

import java.util.List;

import co.edu.usbcali.modelo.ColeccionesRss;
import co.edu.usbcali.modelo.dto.ColeccionesRssDTO;


/**
* @author Zathura Code Generator http://code.google.com/p/zathura
* www.zathuracode.org
*
*/
public interface IColeccionesRssLogic {
    public List<ColeccionesRss> getColeccionesRss() throws Exception;

    /**
         * Save an new ColeccionesRss entity
         */
    public void saveColeccionesRss(ColeccionesRss entity)
        throws Exception;

    /**
         * Delete an existing ColeccionesRss entity
         *
         */
    public void deleteColeccionesRss(ColeccionesRss entity)
        throws Exception;

    /**
        * Update an existing ColeccionesRss entity
        *
        */
    public void updateColeccionesRss(ColeccionesRss entity)
        throws Exception;

    /**
         * Load an existing ColeccionesRss entity
         *
         */
    public ColeccionesRss getColeccionesRss(Long codigoColRss)
        throws Exception;

    public List<ColeccionesRss> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<ColeccionesRss> findPageColeccionesRss(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberColeccionesRss() throws Exception;

    public List<ColeccionesRssDTO> getDataColeccionesRss()
        throws Exception;
}
