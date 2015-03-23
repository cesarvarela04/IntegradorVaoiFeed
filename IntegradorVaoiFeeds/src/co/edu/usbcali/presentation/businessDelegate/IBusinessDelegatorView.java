package co.edu.usbcali.presentation.businessDelegate;

import java.util.List;

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


/**
* @author Zathura Code Generator http://code.google.com/p/zathura
* www.zathuracode.org
*
*/
public interface IBusinessDelegatorView {
    public List<Anexos> getAnexos() throws Exception;

    public void saveAnexos(Anexos entity) throws Exception;

    public void deleteAnexos(Anexos entity) throws Exception;

    public void updateAnexos(Anexos entity) throws Exception;

    public Anexos getAnexos(Long codigoAnexo) throws Exception;

    public List<Anexos> findByCriteriaInAnexos(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<Anexos> findPageAnexos(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberAnexos() throws Exception;

    public List<AnexosDTO> getDataAnexos() throws Exception;

    public List<Articulos> getArticulos() throws Exception;

    public void saveArticulos(Articulos entity) throws Exception;

    public void deleteArticulos(Articulos entity) throws Exception;

    public void updateArticulos(Articulos entity) throws Exception;

    public Articulos getArticulos(Long codigoArti) throws Exception;

    public List<Articulos> findByCriteriaInArticulos(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<Articulos> findPageArticulos(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberArticulos() throws Exception;

    public List<ArticulosDTO> getDataArticulos() throws Exception;

    public List<Categorias> getCategorias() throws Exception;

    public void saveCategorias(Categorias entity) throws Exception;

    public void deleteCategorias(Categorias entity) throws Exception;

    public void updateCategorias(Categorias entity) throws Exception;

    public Categorias getCategorias(Long codigoCate) throws Exception;

    public List<Categorias> findByCriteriaInCategorias(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<Categorias> findPageCategorias(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberCategorias() throws Exception;

    public List<CategoriasDTO> getDataCategorias() throws Exception;

    public List<CategoriasArticulos> getCategoriasArticulos()
        throws Exception;

    public void saveCategoriasArticulos(CategoriasArticulos entity)
        throws Exception;

    public void deleteCategoriasArticulos(CategoriasArticulos entity)
        throws Exception;

    public void updateCategoriasArticulos(CategoriasArticulos entity)
        throws Exception;

    public CategoriasArticulos getCategoriasArticulos(Long codigoCateArti)
        throws Exception;

    public List<CategoriasArticulos> findByCriteriaInCategoriasArticulos(
        Object[] variables, Object[] variablesBetween,
        Object[] variablesBetweenDates) throws Exception;

    public List<CategoriasArticulos> findPageCategoriasArticulos(
        String sortColumnName, boolean sortAscending, int startRow,
        int maxResults) throws Exception;

    public Long findTotalNumberCategoriasArticulos() throws Exception;

    public List<CategoriasArticulosDTO> getDataCategoriasArticulos()
        throws Exception;

    public List<Colecciones> getColecciones() throws Exception;

    public void saveColecciones(Colecciones entity) throws Exception;

    public void deleteColecciones(Colecciones entity) throws Exception;

    public void updateColecciones(Colecciones entity) throws Exception;

    public Colecciones getColecciones(Long codigoCole)
        throws Exception;

    public List<Colecciones> findByCriteriaInColecciones(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<Colecciones> findPageColecciones(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberColecciones() throws Exception;

    public List<ColeccionesDTO> getDataColecciones() throws Exception;

    public List<ColeccionesRss> getColeccionesRss() throws Exception;

    public void saveColeccionesRss(ColeccionesRss entity)
        throws Exception;

    public void deleteColeccionesRss(ColeccionesRss entity)
        throws Exception;

    public void updateColeccionesRss(ColeccionesRss entity)
        throws Exception;

    public ColeccionesRss getColeccionesRss(Long codigoColRss)
        throws Exception;

    public List<ColeccionesRss> findByCriteriaInColeccionesRss(
        Object[] variables, Object[] variablesBetween,
        Object[] variablesBetweenDates) throws Exception;

    public List<ColeccionesRss> findPageColeccionesRss(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberColeccionesRss() throws Exception;

    public List<ColeccionesRssDTO> getDataColeccionesRss()
        throws Exception;

    public List<Entradas> getEntradas() throws Exception;

    public void saveEntradas(Entradas entity) throws Exception;

    public void deleteEntradas(Entradas entity) throws Exception;

    public void updateEntradas(Entradas entity) throws Exception;

    public Entradas getEntradas(Long codigoEntra) throws Exception;

    public List<Entradas> findByCriteriaInEntradas(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<Entradas> findPageEntradas(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberEntradas() throws Exception;

    public List<EntradasDTO> getDataEntradas() throws Exception;

    public List<EventosArticulos> getEventosArticulos()
        throws Exception;

    public void saveEventosArticulos(EventosArticulos entity)
        throws Exception;

    public void deleteEventosArticulos(EventosArticulos entity)
        throws Exception;

    public void updateEventosArticulos(EventosArticulos entity)
        throws Exception;

    public EventosArticulos getEventosArticulos(Long codigoEveArt)
        throws Exception;

    public List<EventosArticulos> findByCriteriaInEventosArticulos(
        Object[] variables, Object[] variablesBetween,
        Object[] variablesBetweenDates) throws Exception;

    public List<EventosArticulos> findPageEventosArticulos(
        String sortColumnName, boolean sortAscending, int startRow,
        int maxResults) throws Exception;

    public Long findTotalNumberEventosArticulos() throws Exception;

    public List<EventosArticulosDTO> getDataEventosArticulos()
        throws Exception;

    public List<Roles> getRoles() throws Exception;

    public void saveRoles(Roles entity) throws Exception;

    public void deleteRoles(Roles entity) throws Exception;

    public void updateRoles(Roles entity) throws Exception;

    public Roles getRoles(Long codigoRol) throws Exception;

    public List<Roles> findByCriteriaInRoles(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<Roles> findPageRoles(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberRoles() throws Exception;

    public List<RolesDTO> getDataRoles() throws Exception;

    public List<Rss> getRss() throws Exception;

    public void saveRss(Rss entity) throws Exception;

    public void deleteRss(Rss entity) throws Exception;

    public void updateRss(Rss entity) throws Exception;

    public Rss getRss(Long codigoRss) throws Exception;

    public List<Rss> findByCriteriaInRss(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<Rss> findPageRss(String sortColumnName, boolean sortAscending,
        int startRow, int maxResults) throws Exception;

    public Long findTotalNumberRss() throws Exception;

    public List<RssDTO> getDataRss() throws Exception;

    public List<Usuarios> getUsuarios() throws Exception;

    public void saveUsuarios(Usuarios entity) throws Exception;

    public void deleteUsuarios(Usuarios entity) throws Exception;

    public void updateUsuarios(Usuarios entity) throws Exception;

    public Usuarios getUsuarios(Long codigoUsua) throws Exception;

    public List<Usuarios> findByCriteriaInUsuarios(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<Usuarios> findPageUsuarios(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberUsuarios() throws Exception;

    public List<UsuariosDTO> getDataUsuarios() throws Exception;
    
    public UsuariosDTO loginUsario(String correo, String pass) throws Exception;
    
    public UsuariosDTO consultaUsuarioXEmail(String correo) throws Exception;
    
}
