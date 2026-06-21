package ec.edu.uce.domain.repository;

import ec.edu.uce.domain.model.Categoria;

public interface CategoriaRepository {
    void crear(Categoria categoria);

    Categoria consultarPorId(Integer id);
}
