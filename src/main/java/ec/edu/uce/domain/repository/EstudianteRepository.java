package ec.edu.uce.domain.repository;

import java.time.LocalDate;
import java.util.List;

import ec.edu.uce.domain.model.Estudiante;

public interface EstudianteRepository {
    void crear(Estudiante estudiante);

    Estudiante seleccionarPorId(Integer id);

    void actualizar(Estudiante estudiante);

    void eliminar(Integer id);

    List<Estudiante> seleccionarTodos();

    List<Estudiante> seleccionarPorNombre(String nombre);

    Estudiante seleccionarPorCedula(String cedula);

    List<Estudiante> seleccionarPorGenero(String genero);
    List<Estudiante> seleccionarPorGeneroTyped(String genero);
    List<Estudiante> seleccionarPorRangoFechas(LocalDate fechaInicio, LocalDate fechaFin);
    Long seleccionarContar();

    List<Estudiante> seleccionarTodosNative();
}
