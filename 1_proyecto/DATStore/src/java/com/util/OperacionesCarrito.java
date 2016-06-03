/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.util;

import com.dto.Carrito;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author hogar1
 */
public class OperacionesCarrito {
    
    
    public OperacionesCarrito(){
      
    }
    public static  List<Carrito> listacarrito ;
    
    static {
      listacarrito = new ArrayList<Carrito>();
    }
  
    
    public List<Carrito> ListarCarrito(){
        return listacarrito;
    
    }
    
    public void LimpiarCarrito(){
        listacarrito.clear();
    
    }
    
    public Carrito BuscarProducto(int idproducto){
        
          for(Carrito objeto:listacarrito){
              if(objeto.getIdProducto()== idproducto ){
              return objeto;
              }
           }
         
        return null;
    
    }
    
    public void EliminarProducto(int idproducto){
                
    listacarrito.remove(BuscarProducto(idproducto));
    
    }
    
    public void ActualizaDatos(Carrito c){
                
        for(int i=0; i < listacarrito.size();i++){
        
         Carrito carro = listacarrito.get(i);
            
         if(c.getIdProducto() ==  carro.getIdProducto()){
         int contador = i;
         listacarrito.set(contador,c);  
         break;
         }
      } 
      
    }
    

    public void AgregarProducto(Carrito c){
       
        int contador = -1;
        
        for(int i=0; i < listacarrito.size();i++){
            
         Carrito carro = listacarrito.get(i);
            
         if(c.getIdProducto() ==  carro.getIdProducto()){
         contador = i;
         break;    
         }
        }
         if(contador == -1){
             listacarrito.add(c);
           
        }
          else {
             
             int nuevacantidad = listacarrito.get(contador).getCantidad() + c.getCantidad();
             listacarrito.get(contador).setCantidad(nuevacantidad);
             Double nuevoprecio = listacarrito.get(contador).getPrecio() + c.getPrecio();
             listacarrito.get(contador).setPrecio(nuevoprecio);
            //listacarrito.set(contador,c);
            
            
          }
        
   
    }
 
    public int TotalProductos(){
    int cantidad = 0;
    for(int i =0; i < listacarrito.size();i++){
      
        cantidad += listacarrito.get(i).getCantidad();
        
    }
        return cantidad;
    
    }
   
}
