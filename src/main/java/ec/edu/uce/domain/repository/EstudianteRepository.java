package ec.edu.uce.domain.repository;

import ec.edu.uce.domain.model.Estudiante;

public interface EstudianteRepository {
    void crear(Estudiante estudiante);

    Estudiante seleccionarPorId(Integer id);

    void actualizar(Estudiante estudiante);

    void eliminar(Integer id);
}
