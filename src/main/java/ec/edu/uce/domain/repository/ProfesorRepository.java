package ec.edu.uce.domain.repository;

import ec.edu.uce.domain.model.Profesor;

public interface ProfesorRepository {
    void crear(Profesor profesor);

    Profesor seleccionarPorId(Integer id);

    void actualizar(Profesor profesor);

    void eliminar(Integer id);
}
