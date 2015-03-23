package co.edu.usbcali.dataaccess.dao;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import co.edu.usbcali.dataaccess.api.HibernateDaoImpl;
import co.edu.usbcali.modelo.Colecciones;


/**
 * A data access object (DAO) providing persistence and search support for
 * Colecciones entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 *
 * @see lidis.Colecciones
 */
@Scope("singleton")
@Repository("ColeccionesDAO")
public class ColeccionesDAO extends HibernateDaoImpl<Colecciones, Long>
    implements IColeccionesDAO {
    @SuppressWarnings("unused")
	private static final Logger log = LoggerFactory.getLogger(ColeccionesDAO.class);
    @Resource
    private SessionFactory sessionFactory;

    public static IColeccionesDAO getFromApplicationContext(
        ApplicationContext ctx) {
        return (IColeccionesDAO) ctx.getBean("ColeccionesDAO");
    }
}
