package ec.edu.uce.application.service;

import ec.edu.uce.domain.model.Pasaporte;
import ec.edu.uce.domain.repository.PasaporteRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class PasaporteService {

    @Inject
    private PasaporteRepository pasaporteRepository;
    @Transactional
    public void guardar(Pasaporte pasaporte){
        this.pasaporteRepository.crear(pasaporte);
    }

}
