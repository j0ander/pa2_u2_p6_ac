package ec.edu.uce.infrestructure.repository;

import java.util.List;


import ec.edu.uce.domain.model.Profesor;
import ec.edu.uce.domain.repository.ProfesorRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@ApplicationScoped
@Transactional
public class ProfesorRepositoryImpl implements ProfesorRepository {

    @Inject
    private EntityManager em;

    @Override
    public void actualizar(Profesor profesor) {
        this.em.merge(profesor);

    }

    @Override
    public void eliminar(Integer id) {
        this.em.remove(this.seleccionarPorId(id));

    }

    @Override
    public void crear(Profesor profesor) {
        this.em.persist(profesor);
    }

    @Override

    public Profesor seleccionarPorId(Integer id) {
        return this.em.find(Profesor.class, id);
    }

    @Override
    public List<Profesor> seleccionarTodos() {
        TypedQuery<Profesor> miQuery = this.em.createQuery("Select p from Profesor p", Profesor.class);
        return miQuery.getResultList();
    }

    @Override
    public List<String> seleccionarNombresPorMateria(String materia) {
        TypedQuery<String> miQuery = this.em.createQuery("Select p.nombre from Profesor p Where p.materia = :materia",
                String.class);
        miQuery.setParameter("materia", materia);
        return miQuery.getResultList();
    }

    @Override
    public Profesor seleccionarPorNumeroFinalCedula(Integer cedula) {
        TypedQuery<Profesor> miQuery = this.em
                .createQuery("Select p from Profesor p Where cast(p.cedula as string) Like :cedula", Profesor.class);
        miQuery.setParameter("cedula", "%" + cedula);
        return miQuery.getResultList().getFirst();
    }

    @Override
    public List<Profesor> seleccionarPorMateria(String materia) {
        TypedQuery<Profesor> mQuery = this.em.createNamedQuery("Profesor.buscarPorMateria", Profesor.class);
        mQuery.setParameter("materia", materia);
        return mQuery.getResultList();
    }

    @Override
    public List<Profesor> seleccionarPorInicialNombre(String inicial) {
        TypedQuery<Profesor> mQuery = this.em.createNamedQuery("Profesor.buscarPorInicialNombre", Profesor.class);
        mQuery.setParameter("inicial", inicial + "%");
        return mQuery.getResultList();
    }

    @Override
    public List<Object[]> contarPorApellido() {
        TypedQuery<Object[]> mQuery = this.em.createNamedQuery("Profesor.contarPorApellido", Object[].class);
        return mQuery.getResultList();
    }

    @Override
    public List<Profesor> seleccionarTodosNative() {
        Query nativeQuery = this.em.createNativeQuery("SELECT * FROM profesor", Profesor.class);
        return nativeQuery.getResultList();
    }

    @Override
    public List<String> seleccionarNombresPorMateriaNative(String materia) {
        Query nativeQuery = this.em.createNativeQuery("SELECT prof_nombre FROM profesor WHERE prof_materia = ?");
        nativeQuery.setParameter(1, materia);
        return nativeQuery.getResultList();
    }

    @Override
    public Profesor seleccionarPorNumeroFinalCedulaNative(Integer cedula) {
        Query nativeQuery = this.em.createNativeQuery("SELECT * FROM profesor WHERE CAST(prof_cedula AS VARCHAR) LIKE ?",
                Profesor.class);
        nativeQuery.setParameter(1, "%" + cedula);
        return (Profesor) nativeQuery.getResultList().getFirst();
    }

    @Override
    public List<Object[]> contarPorApellidoNative() {
        Query nativeQuery = this.em.createNativeQuery("SELECT prof_apellido, COUNT(*) FROM profesor GROUP BY prof_apellido");
        return nativeQuery.getResultList();
    }
}
