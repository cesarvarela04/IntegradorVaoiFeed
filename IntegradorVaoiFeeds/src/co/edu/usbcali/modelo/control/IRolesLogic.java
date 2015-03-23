package co.edu.usbcali.modelo.control;

import java.util.List;

import co.edu.usbcali.modelo.Roles;
import co.edu.usbcali.modelo.dto.RolesDTO;


/**
* @author Zathura Code Generator http://code.google.com/p/zathura
* www.zathuracode.org
*
*/
public interface IRolesLogic {
    public List<Roles> getRoles() throws Exception;

    /**
         * Save an new Roles entity
         */
    public void saveRoles(Roles entity) throws Exception;

    /**
         * Delete an existing Roles entity
         *
         */
    public void deleteRoles(Roles entity) throws Exception;

    /**
        * Update an existing Roles entity
        *
        */
    public void updateRoles(Roles entity) throws Exception;

    /**
         * Load an existing Roles entity
         *
         */
    public Roles getRoles(Long codigoRol) throws Exception;

    public List<Roles> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<Roles> findPageRoles(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberRoles() throws Exception;

    public List<RolesDTO> getDataRoles() throws Exception;
}
