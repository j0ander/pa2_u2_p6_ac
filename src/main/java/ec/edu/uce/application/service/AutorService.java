package ec.edu.uce.application.service;

import ec.edu.uce.domain.model.Autor;
import ec.edu.uce.domain.repository.AutorRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class AutorService {
    @Inject 
    private AutorRepository ar;
    @Transactional
    public void guardar(Autor autor){
        this.ar.crear(autor);
    }
}
