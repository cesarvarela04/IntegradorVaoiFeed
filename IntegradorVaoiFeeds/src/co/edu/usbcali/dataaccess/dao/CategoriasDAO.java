package co.edu.usbcali.dataaccess.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import co.edu.usbcali.dataaccess.api.HibernateDaoImpl;
import co.edu.usbcali.modelo.Categorias;


/**
 * A data access object (DAO) providing persistence and search support for
 * Categorias entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 *
 * @see lidis.Categorias
 */
@Scope("singleton")
@Repository("CategoriasDAO")
public class CategoriasDAO extends HibernateDaoImpl<Categorias, Long>
    implements ICategoriasDAO {
    @SuppressWarnings("unused")
	private static final Logger log = LoggerFactory.getLogger(CategoriasDAO.class);
    @Resource
    private SessionFactory sessionFactory;

    public static ICategoriasDAO getFromApplicationContext(
        ApplicationContext ctx) {
        return (ICategoriasDAO) ctx.getBean("CategoriasDAO");
    }

	@SuppressWarnings("unchecked")
	@Override
	public Long existeCategoria(String nombre) throws Exception {
		Long exiten = 0L;
		try {
			Query query = getSession().getNamedQuery("existeCategoria");
			query.setParameter("pNombre", nombre);
			List<Long> cantA = query.list();

			if (cantA!=null) {
				exiten=cantA.get(0);
			}
			
		} catch (Exception e) {
			throw e;
		}
		return exiten;
	}
}
