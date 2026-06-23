package ec.edu.uce.domain.repository;

import ec.edu.uce.domain.model.CuentaBancaria;

public interface CuentaBancariaRepository {
    void crear(CuentaBancaria cuentaBancaria);

    void actualizar(CuentaBancaria cuentaBancaria);

    CuentaBancaria seleccionarPorNumero(String numero);
}
