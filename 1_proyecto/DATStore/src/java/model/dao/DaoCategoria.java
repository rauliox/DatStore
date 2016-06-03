package model.dao;

import com.dto.Categoria;

import java.util.List;

public interface DaoCategoria {
    public List<Categoria> categoriaQry();
    public List<Categoria>listarCategoria(Integer idCategoria);
    public String categoriaIns(Categoria categoria);
    public String categoriaDel(Integer idCategoria);
    public Categoria categoriaGet(Integer idCategoria);
    public String categoriaUpd(Categoria categoria);
}
