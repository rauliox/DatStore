/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model.dao;

import com.dto.Carrito;
import com.dto.Usuario;
import java.util.List;

/**
 *
 * @author hogar1
 */
public interface DaoProcesarCompra {
     public String Procesar(List<Carrito> carrito ,Usuario usuario);
}
