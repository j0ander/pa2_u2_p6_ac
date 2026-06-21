package ec.edu.uce.application.service;

import ec.edu.uce.domain.model.Categoria;
import ec.edu.uce.domain.repository.CategoriaRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class CategoriaService {

    @Inject
    private CategoriaRepository cr;

    public void guardar(Categoria categoria ){
        this.cr.crear(categoria);
    }

    public Categoria buscarPorId(Integer id){
        return this.cr.consultarPorId(id);
    }

}
