package ec.edu.uce.infrestructure.repository;

import ec.edu.uce.domain.model.Autor;
import ec.edu.uce.domain.repository.AutorRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@ApplicationScoped
@Transactional
public class AutorRepositoryImpl implements AutorRepository{

    @Inject
    private EntityManager em;

    @Override
    public void crear(Autor autor) {
        this.em.persist(autor);
    }

}
