package ec.edu.uce.application.service;

import ec.edu.uce.domain.model.Cliente;
import ec.edu.uce.domain.repository.ClienteRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class ClienteService {
    @Inject
    private ClienteRepository cr;

    public void guardar(Cliente cliente){
        cr.crear(cliente);
    }

}
