package model.dao;

import com.dto.ReporteProductos;
import java.util.List;

public interface DaoReporteProductos {

    List<ReporteProductos> reporte(Integer idVendedor);
    
}
