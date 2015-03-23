package co.edu.usbcali.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import co.edu.usbcali.modelo.Roles;
import co.edu.usbcali.modelo.control.IRolesLogic;
import co.edu.usbcali.modelo.control.IUsuariosLogic;
import co.edu.usbcali.modelo.dto.UsuariosDTO;

@Component("VortexAuthenticationProvider")
public class VortexAuthenticationProvider implements AuthenticationProvider {
	
	@Autowired
	private IUsuariosLogic usuariosLogic;
	@Autowired
    private IRolesLogic rolesLogic;
	
	/**
     * Implementacion de la seguridad propia
     */   
	@Override
	    public Authentication authenticate(Authentication authentication)throws AuthenticationException {
	         
	        String name = authentication.getName();
	        String password = authentication.getCredentials().toString();
	        
			try {
				UsuariosDTO usuariosDTO = usuariosLogic.loginUsario(name, password);
				
				if(usuariosDTO!=null){
			        	
			       Roles Rol= rolesLogic.getRoles(usuariosDTO.getCodigoRol_Roles());
			       final List<GrantedAuthority> grantedAuths = new ArrayList<GrantedAuthority>();
			       grantedAuths.add(new SimpleGrantedAuthority(Rol.getNombreRol()));
			       final UserDetails principal = new User(usuariosDTO.getEmail(), password, grantedAuths);
			       final Authentication auth = new UsernamePasswordAuthenticationToken(principal, password, grantedAuths);
			       return auth;
			            			            					
				}
				
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			
	        return null;
	    }
	 
	    /**
	     * Este metodo se llama primero cuando se autentica un usuario
	     */
	    @Override
	    public boolean supports(Class<?> authentication) {
	         return authentication.equals(UsernamePasswordAuthenticationToken.class);
	    }

}