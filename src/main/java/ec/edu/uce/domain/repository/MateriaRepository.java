package ec.edu.uce.domain.repository;

import ec.edu.uce.domain.model.Materia;

public interface MateriaRepository {
    void crear(Materia materia);

    Materia consultarPorId(Integer id);
}
