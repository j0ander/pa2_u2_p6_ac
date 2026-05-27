package ec.edu.uce.domain.repository;

import java.util.List;

import ec.edu.uce.domain.model.Profesor;

public interface ProfesorRepository {
    void crear(Profesor profesor);

    Profesor seleccionarPorId(Integer id);

    void actualizar(Profesor profesor);

    void eliminar(Integer id);

    List<Profesor> seleccionarTodos();

    List<String> seleccionarNombresPorMateria(String materia);

    Profesor seleccionarPorNumeroFinalCedula(Integer cedula);

}
