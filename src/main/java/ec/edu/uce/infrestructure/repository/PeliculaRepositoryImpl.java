package ec.edu.uce.infrestructure.repository;

import ec.edu.uce.domain.model.Pelicula;
import ec.edu.uce.domain.repository.PeliculaRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@ApplicationScoped
@Transactional
public class PeliculaRepositoryImpl implements PeliculaRepository{
    @Inject
    private EntityManager em;
    @Override
    public void crear(Pelicula pelicula) {
        this.em.persist(pelicula);
    }
}
