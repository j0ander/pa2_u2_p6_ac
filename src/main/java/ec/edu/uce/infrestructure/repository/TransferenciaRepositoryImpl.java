package ec.edu.uce.infrestructure.repository;

import java.math.BigDecimal;

import ec.edu.uce.domain.model.CuentaBancaria;
import ec.edu.uce.domain.model.Transferencia;
import ec.edu.uce.domain.repository.CuentaBancariaRepository;
import ec.edu.uce.domain.repository.TransferenciaRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@ApplicationScoped
@Transactional
public class TransferenciaRepositoryImpl implements TransferenciaRepository {

    @Inject
    private EntityManager em;

    @Inject
    private CuentaBancariaRepository cuentaRepository;

    @Override
    public void transferir(String nroCuentaOrigen, String nroCuentaDestino, BigDecimal monto) {
        CuentaBancaria origen = this.cuentaRepository.seleccionarPorNumero(nroCuentaOrigen);
        CuentaBancaria destino = this.cuentaRepository.seleccionarPorNumero(nroCuentaDestino);

        if (origen == null) {
            throw new RuntimeException("La cuenta origen no existe");
        }

        if (destino == null) {
            throw new RuntimeException("La cuenta destino no existe");
        }

        if (origen.getSaldo().compareTo(monto) < 0) {
            throw new RuntimeException("Saldo insuficiente");
        }

        origen.setSaldo(origen.getSaldo().subtract(monto));
        destino.setSaldo(destino.getSaldo().add(monto));

        this.cuentaRepository.actualizar(origen);
        this.cuentaRepository.actualizar(destino);

        Transferencia transferencia = new Transferencia();
        transferencia.setMonto(monto);
        transferencia.setCuentaOrigen(origen);
        transferencia.setCuentaDestino(destino);
 

        
        this.em.persist(transferencia);
    }

    @Override
    public void crear(Transferencia transferencia) {
        this.em.persist(transferencia);
    }

}
