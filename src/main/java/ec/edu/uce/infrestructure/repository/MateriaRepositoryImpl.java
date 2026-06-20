package ec.edu.uce.infrestructure.repository;

import ec.edu.uce.domain.model.Materia;
import ec.edu.uce.domain.repository.MateriaRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@ApplicationScoped
@Transactional
public class MateriaRepositoryImpl implements MateriaRepository {

    @Inject
    private EntityManager em;

    @Override
    public void crear(Materia materia) {
        this.em.persist(materia);
    }
    
    @Override
    public Materia consultarPorId(Integer id) {
        return this.em.find(Materia.class, id);
    }
       
   /*  @Override
    public Materia  consultarPorId(Integer id) {
    return em.createQuery(
        "SELECT m FROM Materia m LEFT JOIN FETCH m.alumnos WHERE m.id = :id",
        Materia.class)
        .setParameter("id", id)
        .getSingleResult();
    } */


}
