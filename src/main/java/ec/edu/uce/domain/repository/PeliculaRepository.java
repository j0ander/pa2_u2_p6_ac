package ec.edu.uce.domain.repository;

import ec.edu.uce.domain.model.Pelicula;

public interface PeliculaRepository {
    void crear(Pelicula pelicula);
    Pelicula consultarPorId(Integer id);
}
