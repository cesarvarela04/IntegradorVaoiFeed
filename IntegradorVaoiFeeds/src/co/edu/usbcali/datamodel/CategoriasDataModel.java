package co.edu.usbcali.datamodel;
 

import java.util.List;

import javax.faces.model.ListDataModel;


import org.primefaces.model.SelectableDataModel;

import co.edu.usbcali.modelo.dto.CategoriasDTO;


  
public class CategoriasDataModel extends ListDataModel<CategoriasDTO> implements SelectableDataModel<CategoriasDTO> {    
  
    public CategoriasDataModel() {  
    }  
  
    public CategoriasDataModel(List<CategoriasDTO> data) {  
        super(data);  
    }  
      
    @Override  
    public CategoriasDTO getRowData(String rowKey) {  

		@SuppressWarnings("unchecked")
		List<CategoriasDTO> contacto = (List<CategoriasDTO>) getWrappedData();  
          
        for(CategoriasDTO td : contacto) {          	
            if(td.getCodigoCate().toString().equals(rowKey))  
                return td;  
        }  
          
        return null;  
    }  
  
    @Override  
    public Object getRowKey(CategoriasDTO td) {  
        return td.getCodigoCate();  
    }  

}