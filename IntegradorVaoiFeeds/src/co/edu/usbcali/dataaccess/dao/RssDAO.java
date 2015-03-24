package co.edu.usbcali.dataaccess.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.transform.Transformers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import co.edu.usbcali.dataaccess.api.HibernateDaoImpl;
import co.edu.usbcali.modelo.Rss;
import co.edu.usbcali.modelo.dto.RssDTO;


/**
 * A data access object (DAO) providing persistence and search support for
 * Rss entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 *
 * @see lidis.Rss
 */
@Scope("singleton")
@Repository("RssDAO")
public class RssDAO extends HibernateDaoImpl<Rss, Long> implements IRssDAO {
    @SuppressWarnings("unused")
	private static final Logger log = LoggerFactory.getLogger(RssDAO.class);
    @Resource
    private SessionFactory sessionFactory;

    public static IRssDAO getFromApplicationContext(ApplicationContext ctx) {
        return (IRssDAO) ctx.getBean("RssDAO");
    }

	@SuppressWarnings("unchecked")
	@Override
	public List<RssDTO> rssColeccion(Long codigoCole)throws Exception {
				
		List<RssDTO> lista=null;
		
		try {
						
			Query query = getSession().getNamedQuery("consultarRssColeccion");
			query.setParameter("pCodigoCole", codigoCole);
			query.setResultTransformer(Transformers.aliasToBean(RssDTO.class));
			lista= query.list();
	
		} catch (Exception e) {
			throw e;
		}
		
		return lista;
	}
    
    
}
