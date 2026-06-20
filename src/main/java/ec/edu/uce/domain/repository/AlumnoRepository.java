package ec.edu.uce.domain.repository;

import ec.edu.uce.domain.model.Alumno;

public interface AlumnoRepository {
    void crear(Alumno alumno);

    Alumno consultarPorId(Integer id);
}
