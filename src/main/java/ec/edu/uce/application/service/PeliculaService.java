package ec.edu.uce.application.service;

import ec.edu.uce.domain.model.Pelicula;
import ec.edu.uce.domain.repository.PeliculaRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class PeliculaService {
    @Inject
    private PeliculaRepository pr;

    public void guardar(Pelicula pelicula){
        this.pr.crear(pelicula);
    }

    public Pelicula buscarPorId(Integer id){
        return this.pr.consultarPorId(id);
    }
}
