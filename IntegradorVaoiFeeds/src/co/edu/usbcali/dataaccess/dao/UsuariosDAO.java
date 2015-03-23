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
import co.edu.usbcali.modelo.Usuarios;
import co.edu.usbcali.modelo.dto.UsuariosDTO;


/**
 * A data access object (DAO) providing persistence and search support for
 * Usuarios entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 *
 * @see lidis.Usuarios
 */
@Scope("singleton")
@Repository("UsuariosDAO")
public class UsuariosDAO extends HibernateDaoImpl<Usuarios, Long>
    implements IUsuariosDAO {
    @SuppressWarnings("unused")
	private static final Logger log = LoggerFactory.getLogger(UsuariosDAO.class);
    @Resource
    private SessionFactory sessionFactory;

    public static IUsuariosDAO getFromApplicationContext(ApplicationContext ctx) {
        return (IUsuariosDAO) ctx.getBean("UsuariosDAO");
    }

	@SuppressWarnings("unchecked")
	@Override
	public UsuariosDTO loginUsario(String correo, String pass) throws Exception {
		   
		UsuariosDTO usuario = null;
		
		try {
			
			if(correo!=null&&correo.length()>0){
				correo=correo.toLowerCase();
			}
						
			Query query = getSession().getNamedQuery("loginUsuario");
			query.setParameter("pCorreo", correo);
			query.setParameter("pPass", pass);
			query.setResultTransformer(Transformers.aliasToBean(UsuariosDTO.class));
			List<UsuariosDTO> lista= query.list();
			
			if(lista!=null){			
				if(lista.size()>0){
					usuario=lista.get(0);
				}				
			}
			
		} catch (Exception e) {
			throw e;
		}
		return usuario;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Long existeCorreo(String correo) throws Exception {

		Long exiten = 0L;
		try {
			Query query = getSession().getNamedQuery("existeUsuarioMail");
			query.setParameter("pCorreo", correo);
			List<Long> cantA = query.list();

			if (cantA!=null) {
				exiten=cantA.get(0);
			}
			
		} catch (Exception e) {
			throw e;
		}
		return exiten;
	}

	@SuppressWarnings("unchecked")
	@Override
	public UsuariosDTO consultaUsuarioXEmail(String correo) throws Exception {
		UsuariosDTO usuario = null;
		
		try {
			
			if(correo!=null&&correo.length()>0){
				correo=correo.toLowerCase();
			}
						
			Query query = getSession().getNamedQuery("consultarUsuarioXEmail");
			query.setParameter("pCorreo", correo);
			query.setResultTransformer(Transformers.aliasToBean(UsuariosDTO.class));
			List<UsuariosDTO> lista= query.list();
			
			if(lista!=null){				
				if(lista.size()>0){
					usuario=lista.get(0);
				}				
			}
			
		} catch (Exception e) {
			throw e;
		}
		return usuario;
	}
	
}

