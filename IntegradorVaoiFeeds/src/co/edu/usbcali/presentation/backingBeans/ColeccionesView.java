package co.edu.usbcali.presentation.backingBeans;

import java.io.Serializable;
import java.util.List;
import java.util.TimeZone;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import org.primefaces.component.commandbutton.CommandButton;
import org.primefaces.component.inputtext.InputText;
import org.primefaces.context.RequestContext;
import org.primefaces.event.RowEditEvent;
import org.primefaces.model.DefaultTreeNode;
import org.primefaces.model.TreeNode;

import co.edu.usbcali.exceptions.ZMessManager;
import co.edu.usbcali.modelo.Colecciones;
import co.edu.usbcali.modelo.dto.ColeccionesDTO;
import co.edu.usbcali.modelo.dto.UsuariosDTO;
import co.edu.usbcali.presentation.businessDelegate.IBusinessDelegatorView;
import co.edu.usbcali.utilities.FacesUtils;


/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 * www.zathuracode.org
 *
 */
@ManagedBean
@ViewScoped
public class ColeccionesView implements Serializable {
    private static final long serialVersionUID = 1L;
    private InputText txtNombre;
    private InputText txtNombreModificar;
    private InputText txtCodigoUsua_Usuarios;
    private InputText txtCodigoCole;
    private CommandButton btnSave;
    private CommandButton btnModify;
    private CommandButton btnDelete;
    private CommandButton btnClear;
    private List<ColeccionesDTO> data;
    private ColeccionesDTO selectedColecciones;
    private Colecciones entity;
    private boolean showDialog;
    @ManagedProperty(value = "#{BusinessDelegatorView}")
    private IBusinessDelegatorView businessDelegatorView;
    private UsuariosDTO usuario;
    private TreeNode raizColecciones;
    private TreeNode seleccionColecciones;

    public ColeccionesView() {
        super();
    }
    
	@PostConstruct
    public void traerColecciones(){
		
		usuario=(UsuariosDTO) FacesUtils.getManagedBeanFromSession("usuario");

		raizColecciones=new DefaultTreeNode("Raiz", null);
		
		String email = FacesContext.getCurrentInstance().getExternalContext()
				.getUserPrincipal().getName();
		
		try {
			data=businessDelegatorView.coleccionesUsuario(email);
			for (ColeccionesDTO categorias : data) {
				 new DefaultTreeNode(categorias, raizColecciones);
				 //TreeNode nodo =
			}
		} catch (Exception e) {

		}
		
    }
	
	public String modificar(){
		
		try {
			selectedColecciones=(ColeccionesDTO) seleccionColecciones.getData();
			txtNombreModificar.setValue(selectedColecciones.getNombre());
		} catch (Exception e) {
			
		}
		
		return "";
	}
	
	public String crear(){
		
		try {
			txtNombre.setValue(null);
		} catch (Exception e) {
			
		}
		
		return "";
	}
	
	public String action_create() {
        try {
        	
        	UsuariosDTO usu=(UsuariosDTO) FacesUtils.getfromSession("usuario");
        	
            entity = new Colecciones();

            entity.setNombre(FacesUtils.checkString(txtNombre));
            entity.setUsuarios(businessDelegatorView.getUsuarios(usu.getCodigoUsua()));
            
            businessDelegatorView.saveColecciones(entity);
            FacesUtils.addInfoMessage("La Colección se creo con exito");
            
            traerColecciones();
            RequestContext.getCurrentInstance().update("form");
        	RequestContext.getCurrentInstance().execute("PF('dlgColeccion').hide()");
        } catch (Exception e) {
            entity = null;
            FacesUtils.addErrorMessage(e.getMessage());
        	RequestContext.getCurrentInstance().execute("PF('dlgColeccion').show()");
        }

        return "";
    }

    public String action_modify() {
        try {
            if (selectedColecciones == null) {
               
            }else{
                Long codigoCole = new Long(selectedColecciones.getCodigoCole());
            	entity = businessDelegatorView.getColecciones(codigoCole);
                entity.setNombre(FacesUtils.checkString(txtNombreModificar));
                entity.setUsuarios(businessDelegatorView.getUsuarios(usuario.getCodigoUsua()));
                businessDelegatorView.updateColecciones(entity);
                
                FacesUtils.addInfoMessage("La Colección se modifico con exito");
            	
                traerColecciones();
                RequestContext.getCurrentInstance().update("form");
            	RequestContext.getCurrentInstance().execute("PF('dlgModificar').hide()");
            }

        } catch (Exception e) {
            data = null;
            FacesUtils.addErrorMessage(e.getMessage());
        	RequestContext.getCurrentInstance().execute("PF('dlgModificar').show()");
        }

        return "";
    }
    
    //
	

    public void rowEventListener(RowEditEvent e) {
        try {
            ColeccionesDTO coleccionesDTO = (ColeccionesDTO) e.getObject();

            if (txtNombre == null) {
                txtNombre = new InputText();
            }

            txtNombre.setValue(coleccionesDTO.getNombre());

            if (txtCodigoUsua_Usuarios == null) {
                txtCodigoUsua_Usuarios = new InputText();
            }

            txtCodigoUsua_Usuarios.setValue(coleccionesDTO.getCodigoUsua_Usuarios());

            if (txtCodigoCole == null) {
                txtCodigoCole = new InputText();
            }

            txtCodigoCole.setValue(coleccionesDTO.getCodigoCole());

            Long codigoCole = FacesUtils.checkLong(txtCodigoCole);
            entity = businessDelegatorView.getColecciones(codigoCole);

            action_modify();
        } catch (Exception ex) {
        }
    }

    public String action_new() {
        action_clear();
        selectedColecciones = null;
        setShowDialog(true);

        return "";
    }

    public String action_clear() {
        entity = null;
        selectedColecciones = null;

        if (txtNombre != null) {
            txtNombre.setValue(null);
            txtNombre.setDisabled(true);
        }

        if (txtCodigoUsua_Usuarios != null) {
            txtCodigoUsua_Usuarios.setValue(null);
            txtCodigoUsua_Usuarios.setDisabled(true);
        }

        if (txtCodigoCole != null) {
            txtCodigoCole.setValue(null);
            txtCodigoCole.setDisabled(false);
        }

        if (btnSave != null) {
            btnSave.setDisabled(true);
        }

        if (btnDelete != null) {
            btnDelete.setDisabled(true);
        }

        return "";
    }

    public void listener_txtId() {
        try {
            Long codigoCole = FacesUtils.checkLong(txtCodigoCole);
            entity = (codigoCole != null)
                ? businessDelegatorView.getColecciones(codigoCole) : null;
        } catch (Exception e) {
            entity = null;
        }

        if (entity == null) {
            txtNombre.setDisabled(false);
            txtCodigoUsua_Usuarios.setDisabled(false);
            txtCodigoCole.setDisabled(false);
            btnSave.setDisabled(false);
        } else {
            txtNombre.setValue(entity.getNombre());
            txtNombre.setDisabled(false);
            txtCodigoUsua_Usuarios.setValue(entity.getUsuarios().getCodigoUsua());
            txtCodigoUsua_Usuarios.setDisabled(false);
            txtCodigoCole.setValue(entity.getCodigoCole());
            txtCodigoCole.setDisabled(true);
            btnSave.setDisabled(false);

            if (btnDelete != null) {
                btnDelete.setDisabled(false);
            }
        }
    }

    public String action_edit(ActionEvent evt) {
        selectedColecciones = (ColeccionesDTO) (evt.getComponent()
                                                   .getAttributes()
                                                   .get("selectedColecciones"));
        txtNombre.setValue(selectedColecciones.getNombre());
        txtNombre.setDisabled(false);
        txtCodigoUsua_Usuarios.setValue(selectedColecciones.getCodigoUsua_Usuarios());
        txtCodigoUsua_Usuarios.setDisabled(false);
        txtCodigoCole.setValue(selectedColecciones.getCodigoCole());
        txtCodigoCole.setDisabled(true);
        btnSave.setDisabled(false);
        setShowDialog(true);

        return "";
    }

    public String action_save() {
        try {
            if ((selectedColecciones == null) && (entity == null)) {
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

    

    public String action_delete_datatable(ActionEvent evt) {
        try {

            Long codigoCole = new Long(selectedColecciones.getCodigoCole());
            entity = businessDelegatorView.getColecciones(codigoCole);
            action_delete();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_delete_master() {
        try {
        	selectedColecciones=(ColeccionesDTO) seleccionColecciones.getData();
            Long codigoCole = new Long(selectedColecciones.getCodigoCole());
            entity = businessDelegatorView.getColecciones(codigoCole);
            action_delete();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public void action_delete() throws Exception {
        try {
            businessDelegatorView.deleteColecciones(entity);
            FacesUtils.addInfoMessage("Se elimino con exito la colección");
            traerColecciones();
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
            selectedColecciones = (ColeccionesDTO) (evt.getComponent()
                                                       .getAttributes()
                                                       .get("selectedColecciones"));

            Long codigoCole = new Long(selectedColecciones.getCodigoCole());
            entity = businessDelegatorView.getColecciones(codigoCole);
            businessDelegatorView.deleteColecciones(entity);
            data.remove(selectedColecciones);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYDELETED);
            action_clear();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_modifyWitDTO(Long codigoCole, String nombre,
        Long codigoUsua_Usuarios) throws Exception {
        try {
            entity.setNombre(FacesUtils.checkString(nombre));
            businessDelegatorView.updateColecciones(entity);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
        } catch (Exception e) {
            //renderManager.getOnDemandRenderer("ColeccionesView").requestRender();
            FacesUtils.addErrorMessage(e.getMessage());
            throw e;
        }

        return "";
    }

    public InputText getTxtNombre() {
        return txtNombre;
    }

    public void setTxtNombre(InputText txtNombre) {
        this.txtNombre = txtNombre;
    }

    public InputText getTxtCodigoUsua_Usuarios() {
        return txtCodigoUsua_Usuarios;
    }

    public void setTxtCodigoUsua_Usuarios(InputText txtCodigoUsua_Usuarios) {
        this.txtCodigoUsua_Usuarios = txtCodigoUsua_Usuarios;
    }

    public InputText getTxtCodigoCole() {
        return txtCodigoCole;
    }

    public void setTxtCodigoCole(InputText txtCodigoCole) {
        this.txtCodigoCole = txtCodigoCole;
    }

    public List<ColeccionesDTO> getData() {
        try {
            if (data == null) {
                data = businessDelegatorView.getDataColecciones();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return data;
    }

    public void setData(List<ColeccionesDTO> coleccionesDTO) {
        this.data = coleccionesDTO;
    }

    public ColeccionesDTO getSelectedColecciones() {
        return selectedColecciones;
    }

    public void setSelectedColecciones(ColeccionesDTO colecciones) {
        this.selectedColecciones = colecciones;
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

	public TreeNode getRaizColecciones() {
		return raizColecciones;
	}

	public void setRaizColecciones(TreeNode raizColecciones) {
		this.raizColecciones = raizColecciones;
	}

	public TreeNode getSeleccionColecciones() {
		return seleccionColecciones;
	}

	public void setSeleccionColecciones(TreeNode seleccionColecciones) {

		this.seleccionColecciones = seleccionColecciones;
	}

	public InputText getTxtNombreModificar() {
		return txtNombreModificar;
	}

	public void setTxtNombreModificar(InputText txtNombreModificar) {
		this.txtNombreModificar = txtNombreModificar;
	}
	
	
    
    
}
