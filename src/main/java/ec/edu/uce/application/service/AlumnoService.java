package ec.edu.uce.application.service;

import ec.edu.uce.domain.model.Alumno;
import ec.edu.uce.domain.repository.AlumnoRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class AlumnoService {
    @Inject
    private AlumnoRepository ar;

    @Transactional
    public void guardar(Alumno alumno) {
        this.ar.crear(alumno);
    }

    public Alumno buscarPorId(Integer id){
        return this.ar.consultarPorId(id);
    }
}
