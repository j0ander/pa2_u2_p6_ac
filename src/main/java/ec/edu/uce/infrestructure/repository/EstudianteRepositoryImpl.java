package ec.edu.uce.infrestructure.repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import ec.edu.uce.domain.model.Estudiante;
import ec.edu.uce.domain.repository.EstudianteRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import jakarta.transaction.Transactional;

@ApplicationScoped
@Transactional
public class EstudianteRepositoryImpl implements EstudianteRepository {

    // Es la clase principal que me gestiona e implementa erm (Interactuar con la
    // base de datos)
    @Inject
    private EntityManager em;

    @Override
    public void actualizar(Estudiante estudiante) {
        this.em.merge(estudiante); // merge (mezclar) la entidad que se ingresa si o si debe tener su dato de clave
                                   // primaria
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

    // 1.- Query
    // 1.1.- TYPEDQUERY

    @Override
    public List<Estudiante> seleccionarTodos() {
        TypedQuery<Estudiante> miQuery = this.em.createQuery("Select e from Estudiante e", Estudiante.class);
        return miQuery.getResultList();
    }

    @Override
    public List<Estudiante> seleccionarPorNombre(String nombre) {
        TypedQuery<Estudiante> miQuery = this.em.createQuery("Select e from Estudiante e Where e.nombre = :nombre1 ",
                Estudiante.class);
        miQuery.setParameter("nombre1", nombre);
        return miQuery.getResultList();
    }

    @Override
    public Estudiante seleccionarPorCedula(String cedula) {
        TypedQuery<Estudiante> miQuery = this.em.createQuery("Select e from Estudiante e Where e.cedula = :cedula",
                Estudiante.class);
        miQuery.setParameter("cedula", cedula);
        // return miQuery.getSingleResult();
        // return miQuery.getResultList().get(0);
        // return miQuery.getResultList().getFirst();
        return miQuery.getResultList().getLast();
    }

    // 1.2.- Named Query

    @Override
    public List<Estudiante> seleccionarPorGenero(String genero) {
        Query myQuery = this.em.createNamedQuery("Estudiante.buscarPorGenero");
        myQuery.setParameter("genero", genero);
        return (List<Estudiante>) myQuery.getResultList();
    }

    @Override
    public List<Estudiante> seleccionarPorGeneroTyped(String genero) {
        TypedQuery<Estudiante> myQuery = this.em.createNamedQuery("Estudiante.buscarPorGenero", Estudiante.class);
        myQuery.setParameter("genero", genero);
        return myQuery.getResultList();
    }

    @Override
    public List<Estudiante> seleccionarPorRangoFechas(LocalDate fechaInicio, LocalDate fechaFin) {
        TypedQuery<Estudiante> myQuery = this.em.createNamedQuery("Estudiante.buscarPorRangoFecha", Estudiante.class);
        myQuery.setParameter("inicio", fechaInicio);
        myQuery.setParameter("fin", fechaFin);
        return myQuery.getResultList();
    }

    @Override
    public Long seleccionarContar() {
        TypedQuery<Long> myQuery = this.em.createNamedQuery("Estudiante.contar", Long.class);
        return myQuery.getSingleResult();
    }

    // 2.- NativeQuery
    @Override
    @SuppressWarnings("unchecked")
    public List<Estudiante> seleccionarTodosNative() {
        Query myQuery = this.em.createNativeQuery("Select * from estudiante", Estudiante.class); // SQL PURO
        return myQuery.getResultList();
    }

    // 3.- Criteria API Query

    @Override
    public List<Estudiante> seleccionarTodosCriteria() {
        // crear una instancia de la clase que va ha ser la encargada de esta
        // construccion
        CriteriaBuilder cb = this.em.getCriteriaBuilder();
        // definir el tipo de objeto que va a retornar mi consulta
        CriteriaQuery<Estudiante> miQuery = cb.createQuery(Estudiante.class);
        // se define las entidades del FROM
        Root<Estudiante> root = miQuery.from(Estudiante.class);
        // Defino con que tipo de SQL voy a trabajar: Select
        miQuery.select(root);
        // hasta aqui terminamos de construir mi Query

        // Transformar miQuery a un query ejecutable
        TypedQuery<Estudiante> query = this.em.createQuery(miQuery);
        return query.getResultList();
    }

    @Override
    public List<Estudiante> seleccionarPorNombreCriteria(String nombre) {
        CriteriaBuilder cb = this.em.getCriteriaBuilder();
        CriteriaQuery<Estudiante> miQuery = cb.createQuery(Estudiante.class);
        Root<Estudiante> root = miQuery.from(Estudiante.class);
        // equal en el primero que voy a comparar y en el segundo contra que lo voy a
        // comparar
        Predicate p1 = cb.equal(root.get("nombre"), nombre);
        miQuery.select(root).where(p1);
        return this.em.createQuery(miQuery).getResultList();
    }
    
    //query que se consulte por nombre y apellido almenos que uno de los dos sea nulo
    
    @Override
    public List<Estudiante> seleccionarDinamicoCriteria(String nombre, String apellido) {
        CriteriaBuilder cb = this.em.getCriteriaBuilder();
        CriteriaQuery<Estudiante> miQuery = cb.createQuery(Estudiante.class);
        Root<Estudiante> root = miQuery.from(Estudiante.class);
        List<Predicate> condiciones = new ArrayList<>();
        if(nombre != null){
            Predicate p1 = cb.equal(root.get("nombre"), nombre);
            condiciones.add(p1);
        }
        if(apellido != null){
            Predicate p2 = cb.equal(root.get("apellido"), apellido);
            condiciones.add(p2);
        }
        miQuery.select(root).where(condiciones);
        TypedQuery<Estudiante> query = this.em.createQuery(miQuery);
        return query.getResultList();
    }

}
