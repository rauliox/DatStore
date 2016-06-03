
package com.util;


import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

public class GlobalUtil {
    public static enum TipoUsuario{CLIENTE, VENDEDOR}
    public static String getCodTipoUsuario(TipoUsuario tipoUsuario){
        switch (tipoUsuario) {
            case CLIENTE: return("cliente");
            case VENDEDOR: return("vendedor");
        }
        return null;
    }
    public static TipoUsuario getTipoUsuario(String codTipoUsuario){
        if (codTipoUsuario.equals("cliente"))return(TipoUsuario.CLIENTE);
        if (codTipoUsuario.equals("vendedor"))return(TipoUsuario.VENDEDOR);
        return null;
    }
        
    public static enum Estado{ACTIVO, ELIMINADO, CREADO, ACEPTADO, ENVIADO, ENTREGADO, ANULADO, NORECIBIDO,RECHAZADO}
    public static String getCodEstado(Estado estado){
        switch(estado){
            case ACTIVO:return("A");
            case ELIMINADO:return("E");
            case CREADO:return("1");
            case ACEPTADO:return("2");
            case ENVIADO:return("3");
            case ENTREGADO:return("4");
            case ANULADO:return("X");
            case NORECIBIDO:return("N");
            case RECHAZADO:return("R");
        }
        return null;
    }
    public static Estado getEstado(String codEstado){
        if (codEstado.equals("A"))return(Estado.ACTIVO);
        if (codEstado.equals("E"))return(Estado.ELIMINADO);
        if (codEstado.equals("1"))return(Estado.CREADO);
        if (codEstado.equals("2"))return(Estado.ACEPTADO);
        if (codEstado.equals("3"))return(Estado.ENVIADO);
        if (codEstado.equals("4"))return(Estado.ENTREGADO);
        if (codEstado.equals("X"))return(Estado.ANULADO);
        if (codEstado.equals("N"))return(Estado.NORECIBIDO);
        if (codEstado.equals("R"))return(Estado.RECHAZADO);
        
        return null;
    }
    
    public static void mapParams(PreparedStatement ps,List args) throws SQLException {
        int i = 1;
        for (Object arg : args) {         
            if (arg instanceof Date) {
                ps.setTimestamp(i++, new Timestamp(((Date) arg).getTime()));
            } else if (arg instanceof Integer) {
                ps.setInt(i++, (Integer) arg);
            } else if (arg instanceof Long) {
                ps.setLong(i++, (Long) arg);
            } else if (arg instanceof Double) {
                ps.setDouble(i++, (Double) arg);
            } else if (arg instanceof Float) {
                ps.setFloat(i++, (Float) arg);
            } else {
                ps.setString(i++, (String) arg);
            }
        }
    }
    
   
    
    

}
