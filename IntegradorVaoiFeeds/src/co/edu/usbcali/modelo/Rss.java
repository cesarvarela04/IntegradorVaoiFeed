package co.edu.usbcali.modelo;
// Generated 6/03/2015 04:42:17 PM by Hibernate Tools 4.0.0


import java.util.HashSet;
import java.util.Set;

/**
 * Rss generated by hbm2java
 */
public class Rss  implements java.io.Serializable {


     /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long codigoRss;
     private String url;
     private Set<ColeccionesRss> coleccionesRsses = new HashSet<ColeccionesRss>(0);
     private Set<Entradas> entradases = new HashSet<Entradas>(0);
     private Long codigoCole;
    public Rss() {
    }

	
    public Rss(Long codigoRss, String url) {
        this.codigoRss = codigoRss;
        this.url = url;
    }
    public Rss(Long codigoRss, String url, Set<ColeccionesRss> coleccionesRsses, Set<Entradas> entradases) {
       this.codigoRss = codigoRss;
       this.url = url;
       this.coleccionesRsses = coleccionesRsses;
       this.entradases = entradases;
    }
   
    public Long getCodigoRss() {
        return this.codigoRss;
    }
    
    public void setCodigoRss(Long codigoRss) {
        this.codigoRss = codigoRss;
    }
    public String getUrl() {
        return this.url;
    }
    
    public void setUrl(String url) {
        this.url = url;
    }
    public Set<ColeccionesRss> getColeccionesRsses() {
        return this.coleccionesRsses;
    }
    
    public void setColeccionesRsses(Set<ColeccionesRss> coleccionesRsses) {
        this.coleccionesRsses = coleccionesRsses;
    }
    public Set<Entradas> getEntradases() {
        return this.entradases;
    }
    
    public void setEntradases(Set<Entradas> entradases) {
        this.entradases = entradases;
    }


	public Long getCodigoCole() {
		return codigoCole;
	}

	public void setCodigoCole(Long codigoCole) {
		this.codigoCole = codigoCole;
	}

}
