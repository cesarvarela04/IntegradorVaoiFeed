package co.edu.usbcali.presentation.backingBeans;

import java.io.Serializable;
import java.util.List;
import java.util.TimeZone;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.primefaces.component.commandbutton.CommandButton;
import org.primefaces.component.inputtext.InputText;
import org.primefaces.event.RowEditEvent;

import co.edu.usbcali.exceptions.ZMessManager;
import co.edu.usbcali.modelo.Rss;
import co.edu.usbcali.modelo.dto.RssDTO;
import co.edu.usbcali.presentation.businessDelegate.IBusinessDelegatorView;
import co.edu.usbcali.utilities.FacesUtils;


/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 * www.zathuracode.org
 *
 */
@ManagedBean
@ViewScoped
public class RssView implements Serializable {
    private static final long serialVersionUID = 1L;
    private InputText txtUrl;
    private InputText txtCodigoRss;
    private CommandButton btnSave;
    private CommandButton btnModify;
    private CommandButton btnDelete;
    private CommandButton btnClear;
    private List<RssDTO> data;
    private RssDTO selectedRss;
    private Rss entity;
    private boolean showDialog;
    @ManagedProperty(value = "#{BusinessDelegatorView}")
    private IBusinessDelegatorView businessDelegatorView;

    public RssView() {
        super();
    }

    public void rowEventListener(RowEditEvent e) {
        try {
            RssDTO rssDTO = (RssDTO) e.getObject();

            if (txtUrl == null) {
                txtUrl = new InputText();
            }

            txtUrl.setValue(rssDTO.getUrl());

            if (txtCodigoRss == null) {
                txtCodigoRss = new InputText();
            }

            txtCodigoRss.setValue(rssDTO.getCodigoRss());

            Long codigoRss = FacesUtils.checkLong(txtCodigoRss);
            entity = businessDelegatorView.getRss(codigoRss);

            action_modify();
        } catch (Exception ex) {
        }
    }

    public String action_new() {
        action_clear();
        selectedRss = null;
        setShowDialog(true);

        return "";
    }

    public String action_clear() {
        entity = null;
        selectedRss = null;

        if (txtUrl != null) {
            txtUrl.setValue(null);
            txtUrl.setDisabled(true);
        }

        if (txtCodigoRss != null) {
            txtCodigoRss.setValue(null);
            txtCodigoRss.setDisabled(false);
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
            Long codigoRss = FacesUtils.checkLong(txtCodigoRss);
            entity = (codigoRss != null)
                ? businessDelegatorView.getRss(codigoRss) : null;
        } catch (Exception e) {
            entity = null;
        }

        if (entity == null) {
            txtUrl.setDisabled(false);
            txtCodigoRss.setDisabled(false);
            btnSave.setDisabled(false);
        } else {
            txtUrl.setValue(entity.getUrl());
            txtUrl.setDisabled(false);
            txtCodigoRss.setValue(entity.getCodigoRss());
            txtCodigoRss.setDisabled(true);
            btnSave.setDisabled(false);

            if (btnDelete != null) {
                btnDelete.setDisabled(false);
            }
        }
    }

    public String action_edit(ActionEvent evt) {
        selectedRss = (RssDTO) (evt.getComponent().getAttributes()
                                   .get("selectedRss"));
        txtUrl.setValue(selectedRss.getUrl());
        txtUrl.setDisabled(false);
        txtCodigoRss.setValue(selectedRss.getCodigoRss());
        txtCodigoRss.setDisabled(true);
        btnSave.setDisabled(false);
        setShowDialog(true);

        return "";
    }

    public String action_save() {
        try {
            if ((selectedRss == null) && (entity == null)) {
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
            entity = new Rss();

            Long codigoRss = FacesUtils.checkLong(txtCodigoRss);

            entity.setCodigoRss(codigoRss);
            entity.setUrl(FacesUtils.checkString(txtUrl));
            businessDelegatorView.saveRss(entity);
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
                Long codigoRss = new Long(selectedRss.getCodigoRss());
                entity = businessDelegatorView.getRss(codigoRss);
            }

            entity.setUrl(FacesUtils.checkString(txtUrl));
            businessDelegatorView.updateRss(entity);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
        } catch (Exception e) {
            data = null;
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_delete_datatable(ActionEvent evt) {
        try {
            selectedRss = (RssDTO) (evt.getComponent().getAttributes()
                                       .get("selectedRss"));

            Long codigoRss = new Long(selectedRss.getCodigoRss());
            entity = businessDelegatorView.getRss(codigoRss);
            action_delete();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_delete_master() {
        try {
            Long codigoRss = FacesUtils.checkLong(txtCodigoRss);
            entity = businessDelegatorView.getRss(codigoRss);
            action_delete();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public void action_delete() throws Exception {
        try {
            businessDelegatorView.deleteRss(entity);
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
            selectedRss = (RssDTO) (evt.getComponent().getAttributes()
                                       .get("selectedRss"));

            Long codigoRss = new Long(selectedRss.getCodigoRss());
            entity = businessDelegatorView.getRss(codigoRss);
            businessDelegatorView.deleteRss(entity);
            data.remove(selectedRss);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYDELETED);
            action_clear();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_modifyWitDTO(Long codigoRss, String url)
        throws Exception {
        try {
            entity.setUrl(FacesUtils.checkString(url));
            businessDelegatorView.updateRss(entity);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
        } catch (Exception e) {
            //renderManager.getOnDemandRenderer("RssView").requestRender();
            FacesUtils.addErrorMessage(e.getMessage());
            throw e;
        }

        return "";
    }

    public InputText getTxtUrl() {
        return txtUrl;
    }

    public void setTxtUrl(InputText txtUrl) {
        this.txtUrl = txtUrl;
    }

    public InputText getTxtCodigoRss() {
        return txtCodigoRss;
    }

    public void setTxtCodigoRss(InputText txtCodigoRss) {
        this.txtCodigoRss = txtCodigoRss;
    }

    public List<RssDTO> getData() {
        try {
            if (data == null) {
                data = businessDelegatorView.getDataRss();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return data;
    }

    public void setData(List<RssDTO> rssDTO) {
        this.data = rssDTO;
    }

    public RssDTO getSelectedRss() {
        return selectedRss;
    }

    public void setSelectedRss(RssDTO rss) {
        this.selectedRss = rss;
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
}
