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
 

    List<Profesor> seleccionarPorMateria(String materia);
    List<Profesor> seleccionarPorInicialNombre(String inicial);
    List<Object[]> contarPorApellido();

    List<Profesor> seleccionarTodosNative();
    List<String> seleccionarNombresPorMateriaNative(String materia);
    Profesor seleccionarPorNumeroFinalCedulaNative(Integer cedula);
    List<Object[]> contarPorApellidoNative();

    List<Profesor> seleccionarPorMateriaCriteria(String materia);
    List<Profesor> seleccionarPorInicialNombreCriteria(String inicial);
    List<Object[]> contarPorApellidoCriteria();
    List<Profesor> buscarCriteriaDinamico(String nombre, String apellido, String materia);
 

}
