package co.edu.usbcali.presentation.backingBeans;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import org.primefaces.component.calendar.Calendar;
import org.primefaces.component.commandbutton.CommandButton;
import org.primefaces.component.inputtext.InputText;
import org.primefaces.event.RowEditEvent;

import co.edu.usbcali.exceptions.ZMessManager;
import co.edu.usbcali.modelo.Roles;
import co.edu.usbcali.modelo.Usuarios;
import co.edu.usbcali.modelo.dto.UsuariosDTO;
import co.edu.usbcali.presentation.businessDelegate.IBusinessDelegatorView;
import co.edu.usbcali.utilities.FacesUtils;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
@ManagedBean
@ViewScoped
public class UsuariosView implements Serializable {
	private static final long serialVersionUID = 1L;
	private String txtClave;
	private String txtClave2;
	private String txtEmail;
	private InputText txtEstadoRegistro;
	private String txtNombre;
	private InputText txtUsuCrea;
	private InputText txtUsuModifica;
	private InputText txtCodigoRol_Roles;
	private InputText txtCodigoUsua;
	private Calendar txtFechaCreacion;
	private Calendar txtFechaModifcacion;
	private CommandButton btnSave;
	private CommandButton btnModify;
	private CommandButton btnDelete;
	private CommandButton btnClear;
	private List<UsuariosDTO> data;
	private UsuariosDTO selectedUsuarios;
	private Usuarios entity;
	private UsuariosDTO usuario;
	private boolean showDialog;
	@ManagedProperty(value = "#{BusinessDelegatorView}")
	private IBusinessDelegatorView businessDelegatorView;

	public UsuariosView() {
		super();
	}

	@PostConstruct
	public void consultarUsuario() {

		try {
			String email = FacesContext.getCurrentInstance().getExternalContext()
					.getUserPrincipal().getName();
			
			
			if(email!=null&&email.length()>1){
				usuario=businessDelegatorView.consultaUsuarioXEmail(email);	
			}else{
				usuario=new UsuariosDTO();
				usuario.setRol("No existe ninguna sesion activa");
			}

		} catch (Exception e) {
		}

	}

	public String registroAdmin() {

		try {
			Roles rol = businessDelegatorView.getRoles(1L);

			entity = new Usuarios();
			entity.setNombre(txtNombre);
			entity.setClave(txtClave);
			entity.setEmail(txtEmail);
			entity.setFechaCreacion(new Date());
			entity.setFechaModifcacion(new Date());
			entity.setUsuCrea("Registro");
			entity.setUsuModifica("Registro");
			entity.setEstadoRegistro("A");
			entity.setRoles(rol);

			if (txtClave.equals(txtClave2)) {

			} else {
				throw new Exception("No coincide la contraseña ingresada");
			}

			businessDelegatorView.saveUsuarios(entity);
			FacesUtils.addInfoMessage("Registro Exitoso");

		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String registroUsuario() {

		try {
			Roles rol = businessDelegatorView.getRoles(2L);

			entity = new Usuarios();
			entity.setNombre(txtNombre);
			entity.setClave(txtClave);
			entity.setEmail(txtEmail);
			entity.setFechaCreacion(new Date());
			entity.setFechaModifcacion(new Date());
			entity.setUsuCrea("Registro");
			entity.setUsuModifica("Registro");
			entity.setEstadoRegistro("A");
			entity.setRoles(rol);

			if (txtClave.equals(txtClave2)) {

			} else {
				throw new Exception("No coincide la contraseña ingresada");
			}

			businessDelegatorView.saveUsuarios(entity);
			FacesUtils.addInfoMessage("Registro Exitoso");

		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public void rowEventListener(RowEditEvent e) {
		try {
			UsuariosDTO usuariosDTO = (UsuariosDTO) e.getObject();

			/*
			 * if (txtClave == null) { txtClave = new InputText(); }
			 * 
			 * txtClave.setValue(usuariosDTO.getClave());
			 * 
			 * if (txtEmail == null) { txtEmail = new InputText(); }
			 * 
			 * txtEmail.setValue(usuariosDTO.getEmail());
			 */

			if (txtEstadoRegistro == null) {
				txtEstadoRegistro = new InputText();
			}

			txtEstadoRegistro.setValue(usuariosDTO.getEstadoRegistro());

			/*
			 * if (txtNombre == null) { txtNombre = new InputText(); }
			 * 
			 * txtNombre.setValue(usuariosDTO.getNombre());
			 */

			if (txtUsuCrea == null) {
				txtUsuCrea = new InputText();
			}

			txtUsuCrea.setValue(usuariosDTO.getUsuCrea());

			if (txtUsuModifica == null) {
				txtUsuModifica = new InputText();
			}

			txtUsuModifica.setValue(usuariosDTO.getUsuModifica());

			if (txtCodigoRol_Roles == null) {
				txtCodigoRol_Roles = new InputText();
			}

			txtCodigoRol_Roles.setValue(usuariosDTO.getCodigoRol_Roles());

			if (txtCodigoUsua == null) {
				txtCodigoUsua = new InputText();
			}

			txtCodigoUsua.setValue(usuariosDTO.getCodigoUsua());

			if (txtFechaCreacion == null) {
				txtFechaCreacion = new Calendar();
			}

			txtFechaCreacion.setValue(usuariosDTO.getFechaCreacion());

			if (txtFechaModifcacion == null) {
				txtFechaModifcacion = new Calendar();
			}

			txtFechaModifcacion.setValue(usuariosDTO.getFechaModifcacion());

			Long codigoUsua = FacesUtils.checkLong(txtCodigoUsua);
			entity = businessDelegatorView.getUsuarios(codigoUsua);

			action_modify();
		} catch (Exception ex) {
		}
	}

	public String action_new() {
		action_clear();
		selectedUsuarios = null;
		setShowDialog(true);

		return "";
	}

	public String action_clear() {
		entity = null;
		selectedUsuarios = null;

		/*
		 * if (txtClave != null) { txtClave.setValue(null);
		 * txtClave.setDisabled(true); }
		 * 
		 * if (txtEmail != null) { txtEmail.setValue(null);
		 * txtEmail.setDisabled(true); }
		 */

		if (txtEstadoRegistro != null) {
			txtEstadoRegistro.setValue(null);
			txtEstadoRegistro.setDisabled(true);
		}

		/*
		 * if (txtNombre != null) { txtNombre.setValue(null);
		 * txtNombre.setDisabled(true); }
		 */

		if (txtUsuCrea != null) {
			txtUsuCrea.setValue(null);
			txtUsuCrea.setDisabled(true);
		}

		if (txtUsuModifica != null) {
			txtUsuModifica.setValue(null);
			txtUsuModifica.setDisabled(true);
		}

		if (txtCodigoRol_Roles != null) {
			txtCodigoRol_Roles.setValue(null);
			txtCodigoRol_Roles.setDisabled(true);
		}

		if (txtFechaCreacion != null) {
			txtFechaCreacion.setValue(null);
			txtFechaCreacion.setDisabled(true);
		}

		if (txtFechaModifcacion != null) {
			txtFechaModifcacion.setValue(null);
			txtFechaModifcacion.setDisabled(true);
		}

		if (txtCodigoUsua != null) {
			txtCodigoUsua.setValue(null);
			txtCodigoUsua.setDisabled(false);
		}

		if (btnSave != null) {
			btnSave.setDisabled(true);
		}

		if (btnDelete != null) {
			btnDelete.setDisabled(true);
		}

		return "";
	}

	public void listener_txtFechaCreacion() {
		Date inputDate = (Date) txtFechaCreacion.getValue();
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		FacesContext.getCurrentInstance().addMessage(
				"",
				new FacesMessage("Selected Date "
						+ dateFormat.format(inputDate)));
	}

	public void listener_txtFechaModifcacion() {
		Date inputDate = (Date) txtFechaModifcacion.getValue();
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		FacesContext.getCurrentInstance().addMessage(
				"",
				new FacesMessage("Selected Date "
						+ dateFormat.format(inputDate)));
	}

	public void listener_txtId() {
		try {
			Long codigoUsua = FacesUtils.checkLong(txtCodigoUsua);
			entity = (codigoUsua != null) ? businessDelegatorView
					.getUsuarios(codigoUsua) : null;
		} catch (Exception e) {
			entity = null;
		}

		if (entity == null) {
			/*
			 * txtClave.setDisabled(false); txtEmail.setDisabled(false);
			 * txtEstadoRegistro.setDisabled(false);
			 * txtNombre.setDisabled(false);
			 */
			txtUsuCrea.setDisabled(false);
			txtUsuModifica.setDisabled(false);
			txtCodigoRol_Roles.setDisabled(false);
			txtFechaCreacion.setDisabled(false);
			txtFechaModifcacion.setDisabled(false);
			txtCodigoUsua.setDisabled(false);
			btnSave.setDisabled(false);
		} else {
			/*
			 * txtClave.setValue(entity.getClave());
			 * txtClave.setDisabled(false);
			 * txtEmail.setValue(entity.getEmail());
			 * txtEmail.setDisabled(false);
			 */
			txtEstadoRegistro.setValue(entity.getEstadoRegistro());
			txtEstadoRegistro.setDisabled(false);
			txtFechaCreacion.setValue(entity.getFechaCreacion());
			txtFechaCreacion.setDisabled(false);
			txtFechaModifcacion.setValue(entity.getFechaModifcacion());
			txtFechaModifcacion.setDisabled(false);
			/*
			 * txtNombre.setValue(entity.getNombre());
			 * txtNombre.setDisabled(false);
			 */
			txtUsuCrea.setValue(entity.getUsuCrea());
			txtUsuCrea.setDisabled(false);
			txtUsuModifica.setValue(entity.getUsuModifica());
			txtUsuModifica.setDisabled(false);
			txtCodigoRol_Roles.setValue(entity.getRoles().getCodigoRol());
			txtCodigoRol_Roles.setDisabled(false);
			txtCodigoUsua.setValue(entity.getCodigoUsua());
			txtCodigoUsua.setDisabled(true);
			btnSave.setDisabled(false);

			if (btnDelete != null) {
				btnDelete.setDisabled(false);
			}
		}
	}

	public String action_edit(ActionEvent evt) {
		selectedUsuarios = (UsuariosDTO) (evt.getComponent().getAttributes()
				.get("selectedUsuarios"));
		/*
		 * txtClave.setValue(selectedUsuarios.getClave());
		 * txtClave.setDisabled(false);
		 * txtEmail.setValue(selectedUsuarios.getEmail());
		 * txtEmail.setDisabled(false);
		 */
		txtEstadoRegistro.setValue(selectedUsuarios.getEstadoRegistro());
		txtEstadoRegistro.setDisabled(false);
		txtFechaCreacion.setValue(selectedUsuarios.getFechaCreacion());
		txtFechaCreacion.setDisabled(false);
		txtFechaModifcacion.setValue(selectedUsuarios.getFechaModifcacion());
		txtFechaModifcacion.setDisabled(false);
		/*
		 * txtNombre.setValue(selectedUsuarios.getNombre());
		 * txtNombre.setDisabled(false);
		 */
		txtUsuCrea.setValue(selectedUsuarios.getUsuCrea());
		txtUsuCrea.setDisabled(false);
		txtUsuModifica.setValue(selectedUsuarios.getUsuModifica());
		txtUsuModifica.setDisabled(false);
		txtCodigoRol_Roles.setValue(selectedUsuarios.getCodigoRol_Roles());
		txtCodigoRol_Roles.setDisabled(false);
		txtCodigoUsua.setValue(selectedUsuarios.getCodigoUsua());
		txtCodigoUsua.setDisabled(true);
		btnSave.setDisabled(false);
		setShowDialog(true);

		return "";
	}

	public String action_save() {
		try {
			if ((selectedUsuarios == null) && (entity == null)) {
				action_create();
			} else {
				action_modify();
			}

			data = null;
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_create() {
		try {
			entity = new Usuarios();

			Long codigoUsua = FacesUtils.checkLong(txtCodigoUsua);

			entity.setClave(FacesUtils.checkString(txtClave));
			entity.setCodigoUsua(codigoUsua);
			entity.setEmail(FacesUtils.checkString(txtEmail));
			entity.setEstadoRegistro(FacesUtils.checkString(txtEstadoRegistro));
			entity.setFechaCreacion(FacesUtils.checkDate(txtFechaCreacion));
			entity.setFechaModifcacion(FacesUtils
					.checkDate(txtFechaModifcacion));
			entity.setNombre(FacesUtils.checkString(txtNombre));
			entity.setUsuCrea(FacesUtils.checkString(txtUsuCrea));
			entity.setUsuModifica(FacesUtils.checkString(txtUsuModifica));
			entity.setRoles((FacesUtils.checkLong(txtCodigoRol_Roles) != null) ? businessDelegatorView
					.getRoles(FacesUtils.checkLong(txtCodigoRol_Roles)) : null);
			businessDelegatorView.saveUsuarios(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYSAVED);
			action_clear();
		} catch (Exception e) {
			entity = null;
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_modify() {
		try {
			if (entity == null) {
				Long codigoUsua = new Long(selectedUsuarios.getCodigoUsua());
				entity = businessDelegatorView.getUsuarios(codigoUsua);
			}

			entity.setClave(FacesUtils.checkString(txtClave));
			entity.setEmail(FacesUtils.checkString(txtEmail));
			entity.setEstadoRegistro(FacesUtils.checkString(txtEstadoRegistro));
			entity.setFechaCreacion(FacesUtils.checkDate(txtFechaCreacion));
			entity.setFechaModifcacion(FacesUtils
					.checkDate(txtFechaModifcacion));
			entity.setNombre(FacesUtils.checkString(txtNombre));
			entity.setUsuCrea(FacesUtils.checkString(txtUsuCrea));
			entity.setUsuModifica(FacesUtils.checkString(txtUsuModifica));
			entity.setRoles((FacesUtils.checkLong(txtCodigoRol_Roles) != null) ? businessDelegatorView
					.getRoles(FacesUtils.checkLong(txtCodigoRol_Roles)) : null);
			businessDelegatorView.updateUsuarios(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
		} catch (Exception e) {
			data = null;
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_delete_datatable(ActionEvent evt) {
		try {
			selectedUsuarios = (UsuariosDTO) (evt.getComponent()
					.getAttributes().get("selectedUsuarios"));

			Long codigoUsua = new Long(selectedUsuarios.getCodigoUsua());
			entity = businessDelegatorView.getUsuarios(codigoUsua);
			action_delete();
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_delete_master() {
		try {
			Long codigoUsua = FacesUtils.checkLong(txtCodigoUsua);
			entity = businessDelegatorView.getUsuarios(codigoUsua);
			action_delete();
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public void action_delete() throws Exception {
		try {
			businessDelegatorView.deleteUsuarios(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYDELETED);
			action_clear();
			data = null;
		} catch (Exception e) {
			throw e;
		}
	}

	public String action_closeDialog() {
		setShowDialog(false);
		action_clear();

		return "";
	}

	public String actionDeleteDataTableEditable(ActionEvent evt) {
		try {
			selectedUsuarios = (UsuariosDTO) (evt.getComponent()
					.getAttributes().get("selectedUsuarios"));

			Long codigoUsua = new Long(selectedUsuarios.getCodigoUsua());
			entity = businessDelegatorView.getUsuarios(codigoUsua);
			businessDelegatorView.deleteUsuarios(entity);
			data.remove(selectedUsuarios);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYDELETED);
			action_clear();
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_modifyWitDTO(String clave, Long codigoUsua,
			String email, String estadoRegistro, Date fechaCreacion,
			Date fechaModifcacion, String nombre, String usuCrea,
			String usuModifica, Long codigoRol_Roles) throws Exception {
		try {
			entity.setClave(FacesUtils.checkString(clave));
			entity.setEmail(FacesUtils.checkString(email));
			entity.setEstadoRegistro(FacesUtils.checkString(estadoRegistro));
			entity.setFechaCreacion(FacesUtils.checkDate(fechaCreacion));
			entity.setFechaModifcacion(FacesUtils.checkDate(fechaModifcacion));
			entity.setNombre(FacesUtils.checkString(nombre));
			entity.setUsuCrea(FacesUtils.checkString(usuCrea));
			entity.setUsuModifica(FacesUtils.checkString(usuModifica));
			businessDelegatorView.updateUsuarios(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
		} catch (Exception e) {
			// renderManager.getOnDemandRenderer("UsuariosView").requestRender();
			FacesUtils.addErrorMessage(e.getMessage());
			throw e;
		}

		return "";
	}

	public String getTxtClave() {
		return txtClave;
	}

	public void setTxtClave(String txtClave) {
		this.txtClave = txtClave;
	}

	public String getTxtEmail() {
		return txtEmail;
	}

	public void setTxtEmail(String txtEmail) {
		this.txtEmail = txtEmail;
	}

	public InputText getTxtEstadoRegistro() {
		return txtEstadoRegistro;
	}

	public void setTxtEstadoRegistro(InputText txtEstadoRegistro) {
		this.txtEstadoRegistro = txtEstadoRegistro;
	}

	public String getTxtNombre() {
		return txtNombre;
	}

	public void setTxtNombre(String txtNombre) {
		this.txtNombre = txtNombre;
	}

	public InputText getTxtUsuCrea() {
		return txtUsuCrea;
	}

	public void setTxtUsuCrea(InputText txtUsuCrea) {
		this.txtUsuCrea = txtUsuCrea;
	}

	public InputText getTxtUsuModifica() {
		return txtUsuModifica;
	}

	public void setTxtUsuModifica(InputText txtUsuModifica) {
		this.txtUsuModifica = txtUsuModifica;
	}

	public InputText getTxtCodigoRol_Roles() {
		return txtCodigoRol_Roles;
	}

	public void setTxtCodigoRol_Roles(InputText txtCodigoRol_Roles) {
		this.txtCodigoRol_Roles = txtCodigoRol_Roles;
	}

	public Calendar getTxtFechaCreacion() {
		return txtFechaCreacion;
	}

	public void setTxtFechaCreacion(Calendar txtFechaCreacion) {
		this.txtFechaCreacion = txtFechaCreacion;
	}

	public Calendar getTxtFechaModifcacion() {
		return txtFechaModifcacion;
	}

	public void setTxtFechaModifcacion(Calendar txtFechaModifcacion) {
		this.txtFechaModifcacion = txtFechaModifcacion;
	}

	public InputText getTxtCodigoUsua() {
		return txtCodigoUsua;
	}

	public void setTxtCodigoUsua(InputText txtCodigoUsua) {
		this.txtCodigoUsua = txtCodigoUsua;
	}

	public List<UsuariosDTO> getData() {
		try {
			if (data == null) {
				data = businessDelegatorView.getDataUsuarios();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return data;
	}

	public void setData(List<UsuariosDTO> usuariosDTO) {
		this.data = usuariosDTO;
	}

	public UsuariosDTO getSelectedUsuarios() {
		return selectedUsuarios;
	}

	public void setSelectedUsuarios(UsuariosDTO usuarios) {
		this.selectedUsuarios = usuarios;
	}

	public CommandButton getBtnSave() {
		return btnSave;
	}

	public void setBtnSave(CommandButton btnSave) {
		this.btnSave = btnSave;
	}

	public CommandButton getBtnModify() {
		return btnModify;
	}

	public void setBtnModify(CommandButton btnModify) {
		this.btnModify = btnModify;
	}

	public CommandButton getBtnDelete() {
		return btnDelete;
	}

	public void setBtnDelete(CommandButton btnDelete) {
		this.btnDelete = btnDelete;
	}

	public CommandButton getBtnClear() {
		return btnClear;
	}

	public void setBtnClear(CommandButton btnClear) {
		this.btnClear = btnClear;
	}

	public TimeZone getTimeZone() {
		return java.util.TimeZone.getDefault();
	}

	public IBusinessDelegatorView getBusinessDelegatorView() {
		return businessDelegatorView;
	}

	public void setBusinessDelegatorView(
			IBusinessDelegatorView businessDelegatorView) {
		this.businessDelegatorView = businessDelegatorView;
	}

	public boolean isShowDialog() {
		return showDialog;
	}

	public void setShowDialog(boolean showDialog) {
		this.showDialog = showDialog;
	}

	public String getTxtClave2() {
		return txtClave2;
	}

	public void setTxtClave2(String txtClave2) {
		this.txtClave2 = txtClave2;
	}

	public UsuariosDTO getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuariosDTO usuario) {
		this.usuario = usuario;
	}

}
