package ec.edu.uce.application.service;

import ec.edu.uce.domain.model.CuentaBancaria;
import ec.edu.uce.domain.repository.CuentaBancariaRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class CuentaBancariaService {
    @Inject
    private CuentaBancariaRepository cbr;

    public void guardar(CuentaBancaria cuentaBancaria){
        this.cbr.crear(cuentaBancaria);
    }



}
