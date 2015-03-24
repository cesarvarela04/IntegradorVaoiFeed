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
import co.edu.usbcali.modelo.Colecciones;
import co.edu.usbcali.modelo.dto.ColeccionesDTO;

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

	@SuppressWarnings("unchecked")
	@Override
	public List<ColeccionesDTO> coleccionesUsuario(String correo) throws Exception {
		
		List<ColeccionesDTO> lista=null;
		
		try {
			
			if(correo!=null&&correo.length()>0){
				correo=correo.toLowerCase();
			}
						
			Query query = getSession().getNamedQuery("consultarColeccionesUsuario");
			query.setParameter("pCorreo", correo);
			query.setResultTransformer(Transformers.aliasToBean(ColeccionesDTO.class));
			lista= query.list();
	
		} catch (Exception e) {
			throw e;
		}
		
		return lista;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Long existeColecciones(String nombre) throws Exception {
		Long exiten = 0L;
		try {
			Query query = getSession().getNamedQuery("existeColecciones");
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
