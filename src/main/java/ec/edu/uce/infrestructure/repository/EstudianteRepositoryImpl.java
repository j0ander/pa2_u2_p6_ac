package ec.edu.uce.infrestructure.repository;

import ec.edu.uce.domain.model.Estudiante;
import ec.edu.uce.domain.repository.EstudianteRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@ApplicationScoped
@Transactional 
public class EstudianteRepositoryImpl implements EstudianteRepository{
    
    //Es la clase principal que me gestiona e implementa erm (Interactuar con la base de datos)
    @Inject
    private EntityManager em;
    @Override
    public void actualizar(Estudiante estudiante) {
        this.em.merge(estudiante); //merge (mezclar) la entidad que se ingresa si o si debe tener su dato de clave primaria       
    }

    @Override
    public void crear(Estudiante estudiante) {
        this.em.persist(estudiante); 
        
    }

    @Override
    public void eliminar(Integer id) {
        this.em.remove(this.seleccionarPorId(id));        
    }

    @Override
    public Estudiante seleccionarPorId(Integer id) {
        
        return this.em.find(Estudiante.class, id);
    }
}
