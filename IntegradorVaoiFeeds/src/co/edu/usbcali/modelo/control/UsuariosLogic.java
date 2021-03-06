package co.edu.usbcali.modelo.control;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import co.edu.usbcali.dataaccess.dao.IArticulosDAO;
import co.edu.usbcali.dataaccess.dao.IColeccionesDAO;
import co.edu.usbcali.dataaccess.dao.IEventosArticulosDAO;
import co.edu.usbcali.dataaccess.dao.IUsuariosDAO;
import co.edu.usbcali.exceptions.ZMessManager;
import co.edu.usbcali.modelo.Articulos;
import co.edu.usbcali.modelo.Colecciones;
import co.edu.usbcali.modelo.EventosArticulos;
import co.edu.usbcali.modelo.Usuarios;
import co.edu.usbcali.modelo.dto.UsuariosDTO;
import co.edu.usbcali.utilities.Utilities;


/**
* @author Zathura Code Generator http://code.google.com/p/zathura
* www.zathuracode.org
*
*/
@Scope("singleton")
@Service("UsuariosLogic")
public class UsuariosLogic implements IUsuariosLogic {
    /**
     * DAO injected by Spring that manages Usuarios entities
     *
     */
    @Autowired
    private IUsuariosDAO usuariosDAO;

    /**
    * DAO injected by Spring that manages Articulos entities
    *
    */
    @Autowired
    private IArticulosDAO articulosDAO;

    /**
    * DAO injected by Spring that manages Colecciones entities
    *
    */
    @Autowired
    private IColeccionesDAO coleccionesDAO;

    /**
    * DAO injected by Spring that manages EventosArticulos entities
    *
    */
    @Autowired
    private IEventosArticulosDAO eventosArticulosDAO;

    /**
    * Logic injected by Spring that manages Roles entities
    *
    */
    @Autowired
    IRolesLogic logicRoles1;

    @Transactional(readOnly = true)
    public List<Usuarios> getUsuarios() throws Exception {
        List<Usuarios> list = new ArrayList<Usuarios>();

        try {
            list = usuariosDAO.findAll();
        } catch (Exception e) {
            throw new ZMessManager().new GettingException(ZMessManager.ALL +
                "Usuarios");
        } finally {
        }

        return list;
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void saveUsuarios(Usuarios entity) throws Exception {
        try {
            if (entity.getRoles() == null) {
                throw new Exception("El rol no puede ser nulo");
            }

            if (entity.getClave() == null) {
                throw new Exception("La clave no puede ser nula");
            }

            if ((entity.getClave() != null) &&
                    (Utilities.checkWordAndCheckWithlength(entity.getClave(),
                        150) == false)) {
                throw new Exception("La clave no puede tener mas de 150 caracteres");
            }

            if (entity.getEmail() == null) {
                throw new Exception("El Email no puede ser nulo");
            }

            if ((entity.getEmail() != null) &&
                    (Utilities.checkWordAndCheckWithlength(entity.getEmail(),
                        150) == false)) {
                throw new Exception("El Email no puede tener mas de 150 caracteres");
            }

            if (entity.getEstadoRegistro() == null) {
                throw new Exception(
                    "El Estado Registro no puede estar vacio");
            }

            if ((entity.getEstadoRegistro() != null) &&
                    (Utilities.checkWordAndCheckWithlength(
                        entity.getEstadoRegistro(), 1) == false)) {
                throw new Exception(
                    "El Estado Registro no puede tener mas de 1 caracter");
            }

            if (entity.getFechaCreacion() == null) {
                throw new Exception(
                    "La Fecha Creacion no puede estar vacia");
            }

            if (entity.getNombre() == null) {
                throw new Exception("El Nombre no puede ser nulo");
            }

            if ((entity.getNombre() != null) &&
                    (Utilities.checkWordAndCheckWithlength(entity.getNombre(),
                        150) == false)) {
                throw new Exception("El Nombre no puede tener mas de 150 caracteres");
            }

            if (entity.getUsuCrea() == null) {
                throw new Exception("El Usuario Creador no puede esatr vacio");
            }

            if ((entity.getUsuCrea() != null) &&
                    (Utilities.checkWordAndCheckWithlength(
                        entity.getUsuCrea(), 150) == false)) {
                throw new Exception("El Usuario Creador no puede tener mas de 150 caracteres");
            }

            if ((entity.getUsuModifica() != null) &&
                    (Utilities.checkWordAndCheckWithlength(
                        entity.getUsuModifica(), 150) == false)) {
                throw new Exception(
                    "El Usuario Modifica no puede tener mas de 150 caracteres");
            }

            if (entity.getRoles().getCodigoRol() == null) {
                throw new Exception(
                    "El rol no puede estar vacio");
            }
            
            entity.setEmail(entity.getEmail().toLowerCase());
            
            Long existe=existeCorreo(entity.getEmail());
            
            if(existe>=1){
            	throw new Exception("Ya Existe el correo ingresado");
            }
            
            usuariosDAO.save(entity);
        } catch (Exception e) {
            throw e;
        } finally {
        }
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void deleteUsuarios(Usuarios entity) throws Exception {
        if (entity == null) {
            throw new ZMessManager().new NullEntityExcepcion("Usuarios");
        }

        if (entity.getCodigoUsua() == null) {
            throw new ZMessManager().new EmptyFieldException("codigoUsua");
        }

        List<Articulos> articuloses = null;
        List<Colecciones> coleccioneses = null;
        List<EventosArticulos> eventosArticuloses = null;

        try {
            articuloses = articulosDAO.findByProperty("usuarios.codigoUsua",
                    entity.getCodigoUsua());

            if (Utilities.validationsList(articuloses) == true) {
                throw new ZMessManager().new DeletingException("articuloses");
            }

            coleccioneses = coleccionesDAO.findByProperty("usuarios.codigoUsua",
                    entity.getCodigoUsua());

            if (Utilities.validationsList(coleccioneses) == true) {
                throw new ZMessManager().new DeletingException("coleccioneses");
            }

            eventosArticuloses = eventosArticulosDAO.findByProperty("usuarios.codigoUsua",
                    entity.getCodigoUsua());

            if (Utilities.validationsList(eventosArticuloses) == true) {
                throw new ZMessManager().new DeletingException(
                    "eventosArticuloses");
            }

            usuariosDAO.delete(entity);
        } catch (Exception e) {
            throw e;
        } finally {
        }
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void updateUsuarios(Usuarios entity) throws Exception {
        try {

            if (entity.getRoles() == null) {
                throw new Exception("El rol no puede ser nulo");
            }

            if (entity.getClave() == null) {
                throw new Exception("La clave no puede ser nula");
            }

            if ((entity.getClave() != null) &&
                    (Utilities.checkWordAndCheckWithlength(entity.getClave(),
                        150) == false)) {
                throw new Exception("La clave no puede tener mas de 150 caracteres");
            }

            if (entity.getEmail() == null) {
                throw new Exception("El Email no puede ser nulo");
            }

            if ((entity.getEmail() != null) &&
                    (Utilities.checkWordAndCheckWithlength(entity.getEmail(),
                        150) == false)) {
                throw new Exception("El Email no puede tener mas de 150 caracteres");
            }

            if (entity.getEstadoRegistro() == null) {
                throw new Exception(
                    "El Estado Registro no puede estar vacio");
            }

            if ((entity.getEstadoRegistro() != null) &&
                    (Utilities.checkWordAndCheckWithlength(
                        entity.getEstadoRegistro(), 1) == false)) {
                throw new Exception(
                    "El Estado Registro no puede tener mas de 1 caracter");
            }

            if (entity.getFechaCreacion() == null) {
                throw new Exception(
                    "La Fecha Creacion no puede estar vacia");
            }

            if (entity.getNombre() == null) {
                throw new Exception("El Nombre no puede ser nulo");
            }

            if ((entity.getNombre() != null) &&
                    (Utilities.checkWordAndCheckWithlength(entity.getNombre(),
                        150) == false)) {
                throw new Exception("El Nombre no puede tener mas de 150 caracteres");
            }

            if (entity.getUsuCrea() == null) {
                throw new Exception("El Usuario Creador no puede esatr vacio");
            }

            if ((entity.getUsuCrea() != null) &&
                    (Utilities.checkWordAndCheckWithlength(
                        entity.getUsuCrea(), 150) == false)) {
                throw new Exception("El Usuario Creador no puede tener mas de 150 caracteres");
            }

            if ((entity.getUsuModifica() != null) &&
                    (Utilities.checkWordAndCheckWithlength(
                        entity.getUsuModifica(), 150) == false)) {
                throw new Exception(
                    "El Usuario Modifica no puede tener mas de 150 caracteres");
            }

            if (entity.getRoles().getCodigoRol() == null) {
                throw new Exception(
                    "El rol no puede estar vacio");
            }

            entity.setEmail(entity.getEmail().toLowerCase());
            
            Usuarios usuarioBD = getUsuarios(entity.getCodigoUsua());
            
            if(entity.getEmail().equals(usuarioBD.getEmail())){
            	
            }else{
            	Long existe=existeCorreo(entity.getEmail());
                
                if(existe>=1){
                	throw new Exception("Ya Existe el correo ingresado");
                }
            }
            
            usuariosDAO.merge(entity);
        } catch (Exception e) {
            throw e;
        } finally {
        }
    }

    @Transactional(readOnly = true)
    public List<UsuariosDTO> getDataUsuarios() throws Exception {
        try {
            List<Usuarios> usuarios = usuariosDAO.findAll();

            List<UsuariosDTO> usuariosDTO = new ArrayList<UsuariosDTO>();

            for (Usuarios usuariosTmp : usuarios) {
                UsuariosDTO usuariosDTO2 = new UsuariosDTO();

                usuariosDTO2.setCodigoUsua(usuariosTmp.getCodigoUsua());
                usuariosDTO2.setClave((usuariosTmp.getClave() != null)
                    ? usuariosTmp.getClave() : null);
                usuariosDTO2.setEmail((usuariosTmp.getEmail() != null)
                    ? usuariosTmp.getEmail() : null);
                usuariosDTO2.setEstadoRegistro((usuariosTmp.getEstadoRegistro() != null)
                    ? usuariosTmp.getEstadoRegistro() : null);
                usuariosDTO2.setFechaCreacion(usuariosTmp.getFechaCreacion());
                usuariosDTO2.setFechaModifcacion(usuariosTmp.getFechaModifcacion());
                usuariosDTO2.setNombre((usuariosTmp.getNombre() != null)
                    ? usuariosTmp.getNombre() : null);
                usuariosDTO2.setUsuCrea((usuariosTmp.getUsuCrea() != null)
                    ? usuariosTmp.getUsuCrea() : null);
                usuariosDTO2.setUsuModifica((usuariosTmp.getUsuModifica() != null)
                    ? usuariosTmp.getUsuModifica() : null);
                usuariosDTO2.setCodigoRol_Roles((usuariosTmp.getRoles()
                                                            .getCodigoRol() != null)
                    ? usuariosTmp.getRoles().getCodigoRol() : null);
                usuariosDTO.add(usuariosDTO2);
            }

            return usuariosDTO;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public Usuarios getUsuarios(Long codigoUsua) throws Exception {
        Usuarios entity = null;

        try {
            entity = usuariosDAO.findById(codigoUsua);
        } catch (Exception e) {
            throw new ZMessManager().new FindingException("Usuarios");
        } finally {
        }

        return entity;
    }

    @Transactional(readOnly = true)
    public List<Usuarios> findPageUsuarios(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception {
        List<Usuarios> entity = null;

        try {
            entity = usuariosDAO.findPage(sortColumnName, sortAscending,
                    startRow, maxResults);
        } catch (Exception e) {
            throw new ZMessManager().new FindingException("Usuarios Count");
        } finally {
        }

        return entity;
    }

    @Transactional(readOnly = true)
    public Long findTotalNumberUsuarios() throws Exception {
        Long entity = null;

        try {
            entity = usuariosDAO.count();
        } catch (Exception e) {
            throw new ZMessManager().new FindingException("Usuarios Count");
        } finally {
        }

        return entity;
    }

    /**
    *
    * @param varibles
    *            este arreglo debera tener:
    *
    * [0] = String variable = (String) varibles[i]; representa como se llama la
    * variable en el pojo
    *
    * [1] = Boolean booVariable = (Boolean) varibles[i + 1]; representa si el
    * valor necesita o no ''(comillas simples)usado para campos de tipo string
    *
    * [2] = Object value = varibles[i + 2]; representa el valor que se va a
    * buscar en la BD
    *
    * [3] = String comparator = (String) varibles[i + 3]; representa que tipo
    * de busqueda voy a hacer.., ejemplo: where nombre=william o where nombre<>william,
        * en este campo iria el tipo de comparador que quiero si es = o <>
            *
            * Se itera de 4 en 4..., entonces 4 registros del arreglo representan 1
            * busqueda en un campo, si se ponen mas pues el continuara buscando en lo
            * que se le ingresen en los otros 4
            *
            *
            * @param variablesBetween
            *
            * la diferencia son estas dos posiciones
            *
            * [0] = String variable = (String) varibles[j]; la variable ne la BD que va
            * a ser buscada en un rango
            *
            * [1] = Object value = varibles[j + 1]; valor 1 para buscar en un rango
            *
            * [2] = Object value2 = varibles[j + 2]; valor 2 para buscar en un rango
            * ejempolo: a > 1 and a < 5 --> 1 seria value y 5 seria value2
                *
                * [3] = String comparator1 = (String) varibles[j + 3]; comparador 1
                * ejemplo: a comparator1 1 and a < 5
                    *
                    * [4] = String comparator2 = (String) varibles[j + 4]; comparador 2
                    * ejemplo: a comparador1>1  and a comparador2<5  (el original: a > 1 and a <
                            * 5) *
                            * @param variablesBetweenDates(en
                            *            este caso solo para mysql)
                            *  [0] = String variable = (String) varibles[k]; el nombre de la variable que hace referencia a
                            *            una fecha
                            *
                            * [1] = Object object1 = varibles[k + 2]; fecha 1 a comparar(deben ser
                            * dates)
                            *
                            * [2] = Object object2 = varibles[k + 3]; fecha 2 a comparar(deben ser
                            * dates)
                            *
                            * esto hace un between entre las dos fechas.
                            *
                            * @return lista con los objetos que se necesiten
                            * @throws Exception
                            */
    @Transactional(readOnly = true)
    public List<Usuarios> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception {
        List<Usuarios> list = new ArrayList<Usuarios>();
        String where = new String();
        String tempWhere = new String();

        if (variables != null) {
            for (int i = 0; i < variables.length; i++) {
                if ((variables[i] != null) && (variables[i + 1] != null) &&
                        (variables[i + 2] != null) &&
                        (variables[i + 3] != null)) {
                    String variable = (String) variables[i];
                    Boolean booVariable = (Boolean) variables[i + 1];
                    Object value = variables[i + 2];
                    String comparator = (String) variables[i + 3];

                    if (booVariable.booleanValue()) {
                        tempWhere = (tempWhere.length() == 0)
                            ? ("(model." + variable + " " + comparator + " \'" +
                            value + "\' )")
                            : (tempWhere + " AND (model." + variable + " " +
                            comparator + " \'" + value + "\' )");
                    } else {
                        tempWhere = (tempWhere.length() == 0)
                            ? ("(model." + variable + " " + comparator + " " +
                            value + " )")
                            : (tempWhere + " AND (model." + variable + " " +
                            comparator + " " + value + " )");
                    }
                }

                i = i + 3;
            }
        }

        if (variablesBetween != null) {
            for (int j = 0; j < variablesBetween.length; j++) {
                if ((variablesBetween[j] != null) &&
                        (variablesBetween[j + 1] != null) &&
                        (variablesBetween[j + 2] != null) &&
                        (variablesBetween[j + 3] != null) &&
                        (variablesBetween[j + 4] != null)) {
                    String variable = (String) variablesBetween[j];
                    Object value = variablesBetween[j + 1];
                    Object value2 = variablesBetween[j + 2];
                    String comparator1 = (String) variablesBetween[j + 3];
                    String comparator2 = (String) variablesBetween[j + 4];
                    tempWhere = (tempWhere.length() == 0)
                        ? ("(" + value + " " + comparator1 + " " + variable +
                        " and " + variable + " " + comparator2 + " " + value2 +
                        " )")
                        : (tempWhere + " AND (" + value + " " + comparator1 +
                        " " + variable + " and " + variable + " " +
                        comparator2 + " " + value2 + " )");
                }

                j = j + 4;
            }
        }

        if (variablesBetweenDates != null) {
            for (int k = 0; k < variablesBetweenDates.length; k++) {
                if ((variablesBetweenDates[k] != null) &&
                        (variablesBetweenDates[k + 1] != null) &&
                        (variablesBetweenDates[k + 2] != null)) {
                    String variable = (String) variablesBetweenDates[k];
                    Object object1 = variablesBetweenDates[k + 1];
                    Object object2 = variablesBetweenDates[k + 2];
                    String value = null;
                    String value2 = null;

                    try {
                        Date date1 = (Date) object1;
                        Date date2 = (Date) object2;
                        value = Utilities.formatDateWithoutTimeInAStringForBetweenWhere(date1);
                        value2 = Utilities.formatDateWithoutTimeInAStringForBetweenWhere(date2);
                    } catch (Exception e) {
                        list = null;
                        throw e;
                    }

                    tempWhere = (tempWhere.length() == 0)
                        ? ("(model." + variable + " between \'" + value +
                        "\' and \'" + value2 + "\')")
                        : (tempWhere + " AND (model." + variable +
                        " between \'" + value + "\' and \'" + value2 + "\')");
                }

                k = k + 2;
            }
        }

        if (tempWhere.length() == 0) {
            where = null;
        } else {
            where = "(" + tempWhere + ")";
        }

        try {
            list = usuariosDAO.findByCriteria(where);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        } finally {
        }

        return list;
    }

    @Transactional(readOnly = true)
	@Override
	public UsuariosDTO loginUsario(String correo, String pass) throws Exception {
		return usuariosDAO.loginUsario(correo, pass);
	}
    @Transactional(readOnly = true)
	@Override
	public Long existeCorreo(String correo) throws Exception {

		return usuariosDAO.existeCorreo(correo);
	}
    
    @Transactional(readOnly = true)
	@Override
	public UsuariosDTO consultaUsuarioXEmail(String correo) throws Exception {
		return usuariosDAO.consultaUsuarioXEmail(correo);
	}
}
