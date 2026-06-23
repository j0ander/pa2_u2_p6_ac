package ec.edu.uce.application.service;

import java.math.BigDecimal;

import ec.edu.uce.domain.model.Transferencia;
import ec.edu.uce.domain.repository.TransferenciaRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class TransferenciaService {
    @Inject
    private TransferenciaRepository tr;

    

    public void transferencia(String nroCuentaOrigen, String nroCuentaDestino, BigDecimal monto){
        this.tr.transferir(nroCuentaOrigen, nroCuentaDestino, monto);
    }

    public void guardar(Transferencia transferencia){
        this.tr.crear(transferencia);
    }
}
