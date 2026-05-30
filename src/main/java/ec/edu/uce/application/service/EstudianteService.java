package ec.edu.uce.application.service;

import java.time.LocalDate;
import java.util.List;

import ec.edu.uce.domain.model.Estudiante;
import ec.edu.uce.domain.repository.EstudianteRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class EstudianteService {
    @Inject
    private EstudianteRepository estudianteRepository;

    public void guardar(Estudiante estudiante){
        this.estudianteRepository.crear(estudiante);
    }

    public void actualizar(Estudiante estudiante){
        this.estudianteRepository.actualizar(estudiante);
    }

    public Estudiante buscar(Integer id){
        return this.estudianteRepository.seleccionarPorId(id);
        
    }
    public void eliminar(Integer id){
        this.estudianteRepository.eliminar(id);
    }

    public List<Estudiante> buscarTodos(){
        return this.estudianteRepository.seleccionarTodos();
    }
    
    public List<Estudiante> consultarPorNombre(String nombre){
        return this.estudianteRepository.seleccionarPorNombre(nombre);
    }
    
    public Estudiante consultarPorCedula(String cedula){
        return this.estudianteRepository.seleccionarPorCedula(cedula);
    }
    
    public List<Estudiante> consultarPorGenero(String genero){
        return this.estudianteRepository.seleccionarPorGenero(genero);
    }
    public List<Estudiante> consultarPorGeneroTyped(String genero){
        return this.estudianteRepository.seleccionarPorGeneroTyped(genero);
    }
    public List<Estudiante> consultarPorRangoFechas(LocalDate fechaInicio, LocalDate fechaFin){
        return this.estudianteRepository.seleccionarPorRangoFechas(fechaInicio, fechaFin);
    }
    
    public Long contar(){
        return this.estudianteRepository.seleccionarContar();
    }
    
    public List<Estudiante> buscarTodosNative(){
        return this.estudianteRepository.seleccionarTodosNative();
    }
   

  

}
