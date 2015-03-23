package co.edu.usbcali.presentation.businessDelegate;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import co.edu.usbcali.modelo.Anexos;
import co.edu.usbcali.modelo.Articulos;
import co.edu.usbcali.modelo.Categorias;
import co.edu.usbcali.modelo.CategoriasArticulos;
import co.edu.usbcali.modelo.Colecciones;
import co.edu.usbcali.modelo.ColeccionesRss;
import co.edu.usbcali.modelo.Entradas;
import co.edu.usbcali.modelo.EventosArticulos;
import co.edu.usbcali.modelo.Roles;
import co.edu.usbcali.modelo.Rss;
import co.edu.usbcali.modelo.Usuarios;
import co.edu.usbcali.modelo.control.IAnexosLogic;
import co.edu.usbcali.modelo.control.IArticulosLogic;
import co.edu.usbcali.modelo.control.ICategoriasArticulosLogic;
import co.edu.usbcali.modelo.control.ICategoriasLogic;
import co.edu.usbcali.modelo.control.IColeccionesLogic;
import co.edu.usbcali.modelo.control.IColeccionesRssLogic;
import co.edu.usbcali.modelo.control.IEntradasLogic;
import co.edu.usbcali.modelo.control.IEventosArticulosLogic;
import co.edu.usbcali.modelo.control.IRolesLogic;
import co.edu.usbcali.modelo.control.IRssLogic;
import co.edu.usbcali.modelo.control.IUsuariosLogic;
import co.edu.usbcali.modelo.dto.AnexosDTO;
import co.edu.usbcali.modelo.dto.ArticulosDTO;
import co.edu.usbcali.modelo.dto.CategoriasArticulosDTO;
import co.edu.usbcali.modelo.dto.CategoriasDTO;
import co.edu.usbcali.modelo.dto.ColeccionesDTO;
import co.edu.usbcali.modelo.dto.ColeccionesRssDTO;
import co.edu.usbcali.modelo.dto.EntradasDTO;
import co.edu.usbcali.modelo.dto.EventosArticulosDTO;
import co.edu.usbcali.modelo.dto.RolesDTO;
import co.edu.usbcali.modelo.dto.RssDTO;
import co.edu.usbcali.modelo.dto.UsuariosDTO;


@Scope("singleton")
@Service("BusinessDelegatorView")
public class BusinessDelegatorView implements IBusinessDelegatorView {
    @Autowired
    private IAnexosLogic anexosLogic;
    @Autowired
    private IArticulosLogic articulosLogic;
    @Autowired
    private ICategoriasLogic categoriasLogic;
    @Autowired
    private ICategoriasArticulosLogic categoriasArticulosLogic;
    @Autowired
    private IColeccionesLogic coleccionesLogic;
    @Autowired
    private IColeccionesRssLogic coleccionesRssLogic;
    @Autowired
    private IEntradasLogic entradasLogic;
    @Autowired
    private IEventosArticulosLogic eventosArticulosLogic;
    @Autowired
    private IRolesLogic rolesLogic;
    @Autowired
    private IRssLogic rssLogic;
    @Autowired
    private IUsuariosLogic usuariosLogic;

    public List<Anexos> getAnexos() throws Exception {
        return anexosLogic.getAnexos();
    }

    public void saveAnexos(Anexos entity) throws Exception {
        anexosLogic.saveAnexos(entity);
    }

    public void deleteAnexos(Anexos entity) throws Exception {
        anexosLogic.deleteAnexos(entity);
    }

    public void updateAnexos(Anexos entity) throws Exception {
        anexosLogic.updateAnexos(entity);
    }

    public Anexos getAnexos(Long codigoAnexo) throws Exception {
        Anexos anexos = null;

        try {
            anexos = anexosLogic.getAnexos(codigoAnexo);
        } catch (Exception e) {
            throw e;
        }

        return anexos;
    }

    public List<Anexos> findByCriteriaInAnexos(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception {
        return anexosLogic.findByCriteria(variables, variablesBetween,
            variablesBetweenDates);
    }

    public List<Anexos> findPageAnexos(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception {
        return anexosLogic.findPageAnexos(sortColumnName, sortAscending,
            startRow, maxResults);
    }

    public Long findTotalNumberAnexos() throws Exception {
        return anexosLogic.findTotalNumberAnexos();
    }

    public List<AnexosDTO> getDataAnexos() throws Exception {
        return anexosLogic.getDataAnexos();
    }

    public List<Articulos> getArticulos() throws Exception {
        return articulosLogic.getArticulos();
    }

    public void saveArticulos(Articulos entity) throws Exception {
        articulosLogic.saveArticulos(entity);
    }

    public void deleteArticulos(Articulos entity) throws Exception {
        articulosLogic.deleteArticulos(entity);
    }

    public void updateArticulos(Articulos entity) throws Exception {
        articulosLogic.updateArticulos(entity);
    }

    public Articulos getArticulos(Long codigoArti) throws Exception {
        Articulos articulos = null;

        try {
            articulos = articulosLogic.getArticulos(codigoArti);
        } catch (Exception e) {
            throw e;
        }

        return articulos;
    }

    public List<Articulos> findByCriteriaInArticulos(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception {
        return articulosLogic.findByCriteria(variables, variablesBetween,
            variablesBetweenDates);
    }

    public List<Articulos> findPageArticulos(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception {
        return articulosLogic.findPageArticulos(sortColumnName, sortAscending,
            startRow, maxResults);
    }

    public Long findTotalNumberArticulos() throws Exception {
        return articulosLogic.findTotalNumberArticulos();
    }

    public List<ArticulosDTO> getDataArticulos() throws Exception {
        return articulosLogic.getDataArticulos();
    }

    public List<Categorias> getCategorias() throws Exception {
        return categoriasLogic.getCategorias();
    }

    public void saveCategorias(Categorias entity) throws Exception {
        categoriasLogic.saveCategorias(entity);
    }

    public void deleteCategorias(Categorias entity) throws Exception {
        categoriasLogic.deleteCategorias(entity);
    }

    public void updateCategorias(Categorias entity) throws Exception {
        categoriasLogic.updateCategorias(entity);
    }

    public Categorias getCategorias(Long codigoCate) throws Exception {
        Categorias categorias = null;

        try {
            categorias = categoriasLogic.getCategorias(codigoCate);
        } catch (Exception e) {
            throw e;
        }

        return categorias;
    }

    public List<Categorias> findByCriteriaInCategorias(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception {
        return categoriasLogic.findByCriteria(variables, variablesBetween,
            variablesBetweenDates);
    }

    public List<Categorias> findPageCategorias(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception {
        return categoriasLogic.findPageCategorias(sortColumnName,
            sortAscending, startRow, maxResults);
    }

    public Long findTotalNumberCategorias() throws Exception {
        return categoriasLogic.findTotalNumberCategorias();
    }

    public List<CategoriasDTO> getDataCategorias() throws Exception {
        return categoriasLogic.getDataCategorias();
    }

    public List<CategoriasArticulos> getCategoriasArticulos()
        throws Exception {
        return categoriasArticulosLogic.getCategoriasArticulos();
    }

    public void saveCategoriasArticulos(CategoriasArticulos entity)
        throws Exception {
        categoriasArticulosLogic.saveCategoriasArticulos(entity);
    }

    public void deleteCategoriasArticulos(CategoriasArticulos entity)
        throws Exception {
        categoriasArticulosLogic.deleteCategoriasArticulos(entity);
    }

    public void updateCategoriasArticulos(CategoriasArticulos entity)
        throws Exception {
        categoriasArticulosLogic.updateCategoriasArticulos(entity);
    }

    public CategoriasArticulos getCategoriasArticulos(Long codigoCateArti)
        throws Exception {
        CategoriasArticulos categoriasArticulos = null;

        try {
            categoriasArticulos = categoriasArticulosLogic.getCategoriasArticulos(codigoCateArti);
        } catch (Exception e) {
            throw e;
        }

        return categoriasArticulos;
    }

    public List<CategoriasArticulos> findByCriteriaInCategoriasArticulos(
        Object[] variables, Object[] variablesBetween,
        Object[] variablesBetweenDates) throws Exception {
        return categoriasArticulosLogic.findByCriteria(variables,
            variablesBetween, variablesBetweenDates);
    }

    public List<CategoriasArticulos> findPageCategoriasArticulos(
        String sortColumnName, boolean sortAscending, int startRow,
        int maxResults) throws Exception {
        return categoriasArticulosLogic.findPageCategoriasArticulos(sortColumnName,
            sortAscending, startRow, maxResults);
    }

    public Long findTotalNumberCategoriasArticulos() throws Exception {
        return categoriasArticulosLogic.findTotalNumberCategoriasArticulos();
    }

    public List<CategoriasArticulosDTO> getDataCategoriasArticulos()
        throws Exception {
        return categoriasArticulosLogic.getDataCategoriasArticulos();
    }

    public List<Colecciones> getColecciones() throws Exception {
        return coleccionesLogic.getColecciones();
    }

    public void saveColecciones(Colecciones entity) throws Exception {
        coleccionesLogic.saveColecciones(entity);
    }

    public void deleteColecciones(Colecciones entity) throws Exception {
        coleccionesLogic.deleteColecciones(entity);
    }

    public void updateColecciones(Colecciones entity) throws Exception {
        coleccionesLogic.updateColecciones(entity);
    }

    public Colecciones getColecciones(Long codigoCole)
        throws Exception {
        Colecciones colecciones = null;

        try {
            colecciones = coleccionesLogic.getColecciones(codigoCole);
        } catch (Exception e) {
            throw e;
        }

        return colecciones;
    }

    public List<Colecciones> findByCriteriaInColecciones(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception {
        return coleccionesLogic.findByCriteria(variables, variablesBetween,
            variablesBetweenDates);
    }

    public List<Colecciones> findPageColecciones(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception {
        return coleccionesLogic.findPageColecciones(sortColumnName,
            sortAscending, startRow, maxResults);
    }

    public Long findTotalNumberColecciones() throws Exception {
        return coleccionesLogic.findTotalNumberColecciones();
    }

    public List<ColeccionesDTO> getDataColecciones() throws Exception {
        return coleccionesLogic.getDataColecciones();
    }

    public List<ColeccionesRss> getColeccionesRss() throws Exception {
        return coleccionesRssLogic.getColeccionesRss();
    }

    public void saveColeccionesRss(ColeccionesRss entity)
        throws Exception {
        coleccionesRssLogic.saveColeccionesRss(entity);
    }

    public void deleteColeccionesRss(ColeccionesRss entity)
        throws Exception {
        coleccionesRssLogic.deleteColeccionesRss(entity);
    }

    public void updateColeccionesRss(ColeccionesRss entity)
        throws Exception {
        coleccionesRssLogic.updateColeccionesRss(entity);
    }

    public ColeccionesRss getColeccionesRss(Long codigoColRss)
        throws Exception {
        ColeccionesRss coleccionesRss = null;

        try {
            coleccionesRss = coleccionesRssLogic.getColeccionesRss(codigoColRss);
        } catch (Exception e) {
            throw e;
        }

        return coleccionesRss;
    }

    public List<ColeccionesRss> findByCriteriaInColeccionesRss(
        Object[] variables, Object[] variablesBetween,
        Object[] variablesBetweenDates) throws Exception {
        return coleccionesRssLogic.findByCriteria(variables, variablesBetween,
            variablesBetweenDates);
    }

    public List<ColeccionesRss> findPageColeccionesRss(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception {
        return coleccionesRssLogic.findPageColeccionesRss(sortColumnName,
            sortAscending, startRow, maxResults);
    }

    public Long findTotalNumberColeccionesRss() throws Exception {
        return coleccionesRssLogic.findTotalNumberColeccionesRss();
    }

    public List<ColeccionesRssDTO> getDataColeccionesRss()
        throws Exception {
        return coleccionesRssLogic.getDataColeccionesRss();
    }

    public List<Entradas> getEntradas() throws Exception {
        return entradasLogic.getEntradas();
    }

    public void saveEntradas(Entradas entity) throws Exception {
        entradasLogic.saveEntradas(entity);
    }

    public void deleteEntradas(Entradas entity) throws Exception {
        entradasLogic.deleteEntradas(entity);
    }

    public void updateEntradas(Entradas entity) throws Exception {
        entradasLogic.updateEntradas(entity);
    }

    public Entradas getEntradas(Long codigoEntra) throws Exception {
        Entradas entradas = null;

        try {
            entradas = entradasLogic.getEntradas(codigoEntra);
        } catch (Exception e) {
            throw e;
        }

        return entradas;
    }

    public List<Entradas> findByCriteriaInEntradas(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception {
        return entradasLogic.findByCriteria(variables, variablesBetween,
            variablesBetweenDates);
    }

    public List<Entradas> findPageEntradas(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception {
        return entradasLogic.findPageEntradas(sortColumnName, sortAscending,
            startRow, maxResults);
    }

    public Long findTotalNumberEntradas() throws Exception {
        return entradasLogic.findTotalNumberEntradas();
    }

    public List<EntradasDTO> getDataEntradas() throws Exception {
        return entradasLogic.getDataEntradas();
    }

    public List<EventosArticulos> getEventosArticulos()
        throws Exception {
        return eventosArticulosLogic.getEventosArticulos();
    }

    public void saveEventosArticulos(EventosArticulos entity)
        throws Exception {
        eventosArticulosLogic.saveEventosArticulos(entity);
    }

    public void deleteEventosArticulos(EventosArticulos entity)
        throws Exception {
        eventosArticulosLogic.deleteEventosArticulos(entity);
    }

    public void updateEventosArticulos(EventosArticulos entity)
        throws Exception {
        eventosArticulosLogic.updateEventosArticulos(entity);
    }

    public EventosArticulos getEventosArticulos(Long codigoEveArt)
        throws Exception {
        EventosArticulos eventosArticulos = null;

        try {
            eventosArticulos = eventosArticulosLogic.getEventosArticulos(codigoEveArt);
        } catch (Exception e) {
            throw e;
        }

        return eventosArticulos;
    }

    public List<EventosArticulos> findByCriteriaInEventosArticulos(
        Object[] variables, Object[] variablesBetween,
        Object[] variablesBetweenDates) throws Exception {
        return eventosArticulosLogic.findByCriteria(variables,
            variablesBetween, variablesBetweenDates);
    }

    public List<EventosArticulos> findPageEventosArticulos(
        String sortColumnName, boolean sortAscending, int startRow,
        int maxResults) throws Exception {
        return eventosArticulosLogic.findPageEventosArticulos(sortColumnName,
            sortAscending, startRow, maxResults);
    }

    public Long findTotalNumberEventosArticulos() throws Exception {
        return eventosArticulosLogic.findTotalNumberEventosArticulos();
    }

    public List<EventosArticulosDTO> getDataEventosArticulos()
        throws Exception {
        return eventosArticulosLogic.getDataEventosArticulos();
    }

    public List<Roles> getRoles() throws Exception {
        return rolesLogic.getRoles();
    }

    public void saveRoles(Roles entity) throws Exception {
        rolesLogic.saveRoles(entity);
    }

    public void deleteRoles(Roles entity) throws Exception {
        rolesLogic.deleteRoles(entity);
    }

    public void updateRoles(Roles entity) throws Exception {
        rolesLogic.updateRoles(entity);
    }

    public Roles getRoles(Long codigoRol) throws Exception {
        Roles roles = null;

        try {
            roles = rolesLogic.getRoles(codigoRol);
        } catch (Exception e) {
            throw e;
        }

        return roles;
    }

    public List<Roles> findByCriteriaInRoles(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception {
        return rolesLogic.findByCriteria(variables, variablesBetween,
            variablesBetweenDates);
    }

    public List<Roles> findPageRoles(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception {
        return rolesLogic.findPageRoles(sortColumnName, sortAscending,
            startRow, maxResults);
    }

    public Long findTotalNumberRoles() throws Exception {
        return rolesLogic.findTotalNumberRoles();
    }

    public List<RolesDTO> getDataRoles() throws Exception {
        return rolesLogic.getDataRoles();
    }

    public List<Rss> getRss() throws Exception {
        return rssLogic.getRss();
    }

    public void saveRss(Rss entity) throws Exception {
        rssLogic.saveRss(entity);
    }

    public void deleteRss(Rss entity) throws Exception {
        rssLogic.deleteRss(entity);
    }

    public void updateRss(Rss entity) throws Exception {
        rssLogic.updateRss(entity);
    }

    public Rss getRss(Long codigoRss) throws Exception {
        Rss rss = null;

        try {
            rss = rssLogic.getRss(codigoRss);
        } catch (Exception e) {
            throw e;
        }

        return rss;
    }

    public List<Rss> findByCriteriaInRss(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception {
        return rssLogic.findByCriteria(variables, variablesBetween,
            variablesBetweenDates);
    }

    public List<Rss> findPageRss(String sortColumnName, boolean sortAscending,
        int startRow, int maxResults) throws Exception {
        return rssLogic.findPageRss(sortColumnName, sortAscending, startRow,
            maxResults);
    }

    public Long findTotalNumberRss() throws Exception {
        return rssLogic.findTotalNumberRss();
    }

    public List<RssDTO> getDataRss() throws Exception {
        return rssLogic.getDataRss();
    }

    public List<Usuarios> getUsuarios() throws Exception {
        return usuariosLogic.getUsuarios();
    }

    public void saveUsuarios(Usuarios entity) throws Exception {
        usuariosLogic.saveUsuarios(entity);
    }

    public void deleteUsuarios(Usuarios entity) throws Exception {
        usuariosLogic.deleteUsuarios(entity);
    }

    public void updateUsuarios(Usuarios entity) throws Exception {
        usuariosLogic.updateUsuarios(entity);
    }

    public Usuarios getUsuarios(Long codigoUsua) throws Exception {
        Usuarios usuarios = null;

        try {
            usuarios = usuariosLogic.getUsuarios(codigoUsua);
        } catch (Exception e) {
            throw e;
        }

        return usuarios;
    }

    public List<Usuarios> findByCriteriaInUsuarios(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception {
        return usuariosLogic.findByCriteria(variables, variablesBetween,
            variablesBetweenDates);
    }

    public List<Usuarios> findPageUsuarios(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception {
        return usuariosLogic.findPageUsuarios(sortColumnName, sortAscending,
            startRow, maxResults);
    }

    public Long findTotalNumberUsuarios() throws Exception {
        return usuariosLogic.findTotalNumberUsuarios();
    }

    public List<UsuariosDTO> getDataUsuarios() throws Exception {
        return usuariosLogic.getDataUsuarios();
    }

	@Override
	public UsuariosDTO loginUsario(String correo, String pass) throws Exception {
		return usuariosLogic.loginUsario(correo, pass);
	}

	@Override
	public UsuariosDTO consultaUsuarioXEmail(String correo) throws Exception {
		return usuariosLogic.consultaUsuarioXEmail(correo);
	}
}
