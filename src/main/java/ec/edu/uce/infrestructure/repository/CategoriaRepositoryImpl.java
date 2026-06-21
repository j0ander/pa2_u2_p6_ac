package ec.edu.uce.infrestructure.repository;

import ec.edu.uce.domain.model.Categoria;
import ec.edu.uce.domain.repository.CategoriaRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@ApplicationScoped
@Transactional
public class CategoriaRepositoryImpl implements CategoriaRepository {

    @Inject
    private EntityManager em;

    @Override
    public void crear(Categoria categoria) {
        this.em.persist(categoria);
    }

    @Override
    public Categoria consultarPorId(Integer id) {
        return this.em.find(Categoria.class, id);
    }

}
