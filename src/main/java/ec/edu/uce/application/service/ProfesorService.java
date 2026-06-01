package ec.edu.uce.application.service;

import java.util.List;

import com.arjuna.ats.arjuna.common.recoveryPropertyManager;

import ec.edu.uce.domain.model.Profesor;
import ec.edu.uce.domain.repository.ProfesorRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class ProfesorService {
    @Inject
    private ProfesorRepository profesorRepository;

    public void guardar(Profesor profesor){
        this.profesorRepository.crear(profesor);
    }

    public void actualizar(Profesor profesor){
        this.profesorRepository.actualizar(profesor);
    }

    public Profesor buscar(Integer id){
        return this.profesorRepository.seleccionarPorId(id);
    }

    public void eliminar(Integer id){
        this.profesorRepository.eliminar(id);
    }

    public List<Profesor> buscarTodos(){
        return profesorRepository.seleccionarTodos();
    }

    public List<String> consultarNombrePorMateria(String materia){
        return profesorRepository.seleccionarNombresPorMateria(materia);
    }

    public Profesor consultarPorNumeroFinalCedula(Integer cedula){
        return profesorRepository.seleccionarPorNumeroFinalCedula(cedula);
    }

    public List<Profesor> consultarPorMateria(String materia){
        return profesorRepository.seleccionarPorMateria(materia);
    }

    public List<Profesor> consultarNombrePorInicial(String inicial){
        return profesorRepository.seleccionarPorInicialNombre(inicial);
    }
    public List<Object[]> contarPorApellidos(){
        return profesorRepository.contarPorApellido();
    }
}
