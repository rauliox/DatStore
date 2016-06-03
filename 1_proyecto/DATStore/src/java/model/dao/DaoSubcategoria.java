package model.dao;

import com.dto.Categoria;
import com.dto.Subcategoria;
import java.util.List;

public interface DaoSubcategoria {
    public List<Subcategoria> subcategoriaQry();
    public String subcategoriaIns(Subcategoria subcategoria);
    public String subcategoriaDel(Integer idSubcategoria);
    public Subcategoria subcategoriaGet(Integer idSubcategoria);
    public String subcategoriaUpd(Subcategoria subcategoria);
}
