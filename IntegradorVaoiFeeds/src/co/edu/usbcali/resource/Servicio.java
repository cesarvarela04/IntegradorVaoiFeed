package co.edu.usbcali.resource;

import java.util.Date;

import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.springframework.stereotype.Controller;

import co.edu.usbcali.correo.EmailController;
import co.edu.usbcali.modelo.Roles;
import co.edu.usbcali.modelo.Usuarios;
import co.edu.usbcali.modelo.dto.UsuariosDTO;
import co.edu.usbcali.presentation.businessDelegate.IBusinessDelegatorView;
 

@Path("servicio")
@Controller
public class Servicio {
	
	@PUT
	@Path("/login/{nombre}/{clave}/{email}/{rol}/")
	public void crearUsuario(
			@PathParam("nombre") String nombre,
					@PathParam("clave") String clave,
							@PathParam("email") String email,
									@PathParam("rol") Long rol){
		
		try {

			IBusinessDelegatorView businessDelegatorView=ApplicationContextHolder.getContext().getBean(IBusinessDelegatorView.class);
			UsuariosDTO usuariosDTO=businessDelegatorView.consultaUsuarioXEmail(email);
			if(usuariosDTO!=null){
				
			       /*Roles Rol= businessDelegatorView.getRoles(usuariosDTO.getCodigoRol_Roles());
			       final List<GrantedAuthority> grantedAuths = new ArrayList<GrantedAuthority>();
			       grantedAuths.add(new SimpleGrantedAuthority(Rol.getNombreRol()));
			       final UserDetails principal = new User(usuariosDTO.getEmail(), usuariosDTO.getClave(), grantedAuths);
			       final Authentication auth = new UsernamePasswordAuthenticationToken(principal, usuariosDTO.getClave(), grantedAuths);
				   auth.setAuthenticated(true);
				   SecurityContextHolder.getContext().setAuthentication(auth);*/
				
			}else{
				
				Roles codRol=businessDelegatorView.getRoles(rol);
				
				Usuarios usu=new Usuarios();
				usu.setClave(clave);
				usu.setNombre(nombre);
				usu.setEmail(email);
				usu.setEstadoRegistro("A");
				usu.setFechaCreacion(new Date());
				usu.setFechaModifcacion(new Date());
				usu.setUsuCrea("Registro");
				usu.setUsuModifica("Registro");
				usu.setRoles(codRol);
				businessDelegatorView.saveUsuarios(usu);
				EmailController mail=new EmailController();
				String subject="Registro Exitoso en el sistema VAOI";
				String messageBody="Bienvenido User <br>  Usuario: " + email ;
				mail.performTask(email, subject, messageBody, null);

			}
			
		} catch (Exception e) {
			
			System.out.println(e.getMessage());
			//return e.getMessage();

		}
		//return "Se creo el Usuario con exito";
	}

}