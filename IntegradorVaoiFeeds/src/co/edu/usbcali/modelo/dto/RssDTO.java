package co.edu.usbcali.modelo.dto;

import java.io.Serializable;


/**
*
* @author Zathura Code Generator http://code.google.com/p/zathura
* www.zathuracode.org
*
*/
public class RssDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long codigoRss;
    private String url;

    public Long getCodigoRss() {
        return codigoRss;
    }

    public void setCodigoRss(Long codigoRss) {
        this.codigoRss = codigoRss;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
