package co.edu.usbcali.dataaccess.dao;

import java.util.List;

import co.edu.usbcali.dataaccess.api.Dao;
import co.edu.usbcali.modelo.Rss;
import co.edu.usbcali.modelo.dto.RssDTO;


/**
* Interface for   RssDAO.
*
*/
public interface IRssDAO extends Dao<Rss, Long> {
	public List<RssDTO> rssColeccion(Long codigoCole)throws Exception;
}
