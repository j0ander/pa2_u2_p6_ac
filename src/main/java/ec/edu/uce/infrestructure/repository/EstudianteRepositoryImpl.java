package ec.edu.uce.infrestructure.repository;

import java.util.List;

import ec.edu.uce.domain.model.Estudiante;
import ec.edu.uce.domain.repository.EstudianteRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
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

    //1.1 TYPEDQUERY

    @Override
    public List<Estudiante> seleccionarTodos(){
        TypedQuery<Estudiante> miQuery = this.em.createQuery("Select e from Estudiante e", Estudiante.class);
        return miQuery.getResultList();
    }

    @Override
    public List<Estudiante> seleccionarPorNombre(String nombre) {
        TypedQuery<Estudiante> miQuery = this.em.createQuery("Select e from Estudiante e Where e.nombre = :nombre1 ", Estudiante.class);
        miQuery.setParameter("nombre1", nombre);
        return miQuery.getResultList();
    }

    @Override
    public Estudiante seleccionarPorCedula(String cedula) {
        TypedQuery<Estudiante> miQuery = this.em.createQuery("Select e from Estudiante e Where e.cedula = :cedula", Estudiante.class);
        miQuery.setParameter("cedula", cedula);
        //return miQuery.getSingleResult();
        //return miQuery.getResultList().get(0);
        //return miQuery.getResultList().getFirst();
        return miQuery.getResultList().getLast();
    }

    



}
