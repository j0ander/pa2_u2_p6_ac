package ec.edu.uce.domain.repository;

import java.math.BigDecimal;

import ec.edu.uce.domain.model.Transferencia;

public interface TransferenciaRepository {

    void transferir(String nroCuentaOrigen, String nroCuentaDestino, BigDecimal monto);

    void crear(Transferencia transferencia);


}
