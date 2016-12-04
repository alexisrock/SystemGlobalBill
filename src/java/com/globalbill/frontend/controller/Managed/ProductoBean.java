/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.globalbill.frontend.controller.Managed;


import com.globalbill.backend.model.ProductoFacadeLocal;
import com.globalbill.backend.Entities.Producto;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import javax.faces.application.FacesMessage;


import javax.faces.context.FacesContext;
import org.primefaces.context.RequestContext;

/**
 *
 * @author Administrador
 */
@Named(value = "productoBean")
@SessionScoped
public class ProductoBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @EJB
    private ProductoFacadeLocal productoFacade;
    private Producto producto;
    private List<Producto> listarProducto;
    /**
     * Creates a new instance of ProductoBean
     */
    public ProductoBean() {
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

   
    @PostConstruct()
public void init(){

    producto= new Producto();
    
}

public void ingresarProducto(){

try{
    productoFacade.create(producto);
    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "", "producto registrado correctamente"));
      

}catch(Exception e){
  FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(
            FacesMessage.SEVERITY_ERROR,"Se produjo un error: ", e.getMessage()));
            
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, 
            "Se produjo un error al insertar. "+ 
            "el codigo de la excepción es: ", e.getMessage());
            
            RequestContext.getCurrentInstance().showMessageInDialog(fm);
    
}

}

    public List<Producto> getListarProducto() {
        
        this.listarProducto = productoFacade.findAll();
System.out.println("numero de registros"+listarProducto.size());
        return listarProducto;
    }

    public void setListarProducto(List<Producto> listarProducto) {
        this.listarProducto = listarProducto;
    }



public void eliminarProducto(Producto produ){
       productoFacade.remove(produ);
  
}
public String editarProducto(Producto pro){
   producto = pro;
return "/faces/resources/Producto/editarrProducto.xhtml";
}



public String editarProducto(){
   try{
    productoFacade.edit(producto);
    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "","producto Editado correctamente"));

    return "/faces/resources/Producto/eliminarProducto.xhtml";
   }
   
   catch(Exception e){
   
    FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(
            FacesMessage.SEVERITY_ERROR,"Se produjo un error: ", e.getMessage()));
            
   }
   return "/faces/resources/Producto/eliminarProducto.xhtml";
}


}
