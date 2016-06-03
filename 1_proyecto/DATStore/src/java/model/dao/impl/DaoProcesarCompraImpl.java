/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model.dao.impl;

import com.dto.Carrito;
import com.dto.Orden;
import com.dto.Usuario;
import com.sql.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.dao.DaoProcesarCompra;

/**
 *
 * @author hogar1
 */
public class DaoProcesarCompraImpl implements DaoProcesarCompra{

    @Override
    public String Procesar(List<Carrito> listacarrito, Usuario usuario) {
        
        boolean ok = false;
        String resultado = null;
        Connection cn = null;
        int idorden = 0;
        int ctos;
        
        StringBuilder sb = new StringBuilder();

        sb.append("INSERT INTO Orden(");
        sb.append("idCliente ");
        sb.append(",fechaCreada ");
        sb.append(",estado ");
        sb.append(") ");
        sb.append("values (?,?,?)");
          
          try {
               cn = ConnectionFactory.getInstance().getConnection();
               cn.setAutoCommit(false);
               PreparedStatement ps = cn.prepareStatement(sb.toString(), PreparedStatement.RETURN_GENERATED_KEYS);
             
               ps.setInt(1,usuario.getIdUsuario());
               ps.setDate(2, new java.sql.Date(System.currentTimeMillis()));
               ps.setString(3,"A");
              
                ctos =ps.executeUpdate();
              
                ResultSet rs = ps.getGeneratedKeys();
                if(rs.next()){
                    idorden = rs.getInt(1);
                }  
                ps.close();
                
                if(ctos == 0){
                    throw new SQLException("Orden no insertada");
                }
                // INSERTAMOS EN ORDENEXPRODUCTO
               ctos = 0; 

               for(int i = 0;i < listacarrito.size();i++){

                    Carrito nuevocarrito = listacarrito.get(i);

                    int IdProducto = nuevocarrito.getIdProducto();
                    int cantidad = nuevocarrito.getCantidad();
                    Double precio = nuevocarrito.getPrecio();
                    StringBuilder sb1= new StringBuilder();

                    sb1.append("INSERT INTO ordenxproducto(");
                    sb1.append("idOrden ");
                    sb1.append(",idProducto ");
                    sb1.append(",cantidad ");
                    sb1.append(",precio ");
                    sb1.append(",fechaCreada ");
                     sb1.append(",estado ");
                    sb1.append(") ");
                    sb1.append("values (?,?,?,?,?,?)");

                    ps = cn.prepareStatement(sb1.toString());

                    ps.setInt(1,idorden);
                    ps.setInt(2,IdProducto);
                    ps.setInt(3,cantidad);
                    ps.setDouble(4,precio);
                    ps.setDate(5,new java.sql.Date(System.currentTimeMillis()));
                    ps.setString(6,"1");

                   ctos = ctos + ps.executeUpdate();

               }

                if(ctos != listacarrito.size()){
                    throw new SQLException("No se insertaron los productos");
                }

                ps.close();

               
              
      // ACTUALIZAMOS STOCK
                 
                ctos = 0; 

                 for(int i = 0;i < listacarrito.size();i++){
                  
                   Carrito nuevocarrito = listacarrito.get(i);

                   int IdProducto = nuevocarrito.getIdProducto();
                   int cantidad = nuevocarrito.getCantidad();             
                    StringBuilder sb2= new StringBuilder();

                    sb2.append("UPDATE producto SET ");
                    sb2.append("stock = stock - ? ");
                    sb2.append(",vendidas = vendidas + ? ");
                    sb2.append("WHERE idProducto = ? ");

                    ps = cn.prepareStatement(sb2.toString());

                     ps.setInt(1,cantidad);
                     ps.setInt(2,cantidad);
                     ps.setInt(3,IdProducto);
                     
                     ctos = ctos + ps.executeUpdate();
                   
                   }
                    if(ctos == listacarrito.size()){
                       ok = true;
                     }
                    else{
                      throw new SQLException("No se actualizo el stock");
                    }

                    ps.close();                    
                
          }
          catch (Exception e) {
              com.util.Logger.log(e);
              e.printStackTrace();
          }
          
          
         finally {
            try { 
                if(ok != true){
                    cn.rollback();
                    resultado = "error";
                
                }
                else {
                    cn.commit();
                    resultado = "ok";
                }
                
            } catch (Exception e) {
                com.util.Logger.log(e);
                e.printStackTrace();
            }
        
          }
       
     
     return resultado;
        
    }
    
    
}
