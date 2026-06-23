package ec.edu.uce.infrestructure.repository;

import ec.edu.uce.domain.model.CuentaBancaria;
import ec.edu.uce.domain.repository.CuentaBancariaRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@ApplicationScoped
@Transactional
public class CuentaBancariaRepositoryImpl implements CuentaBancariaRepository {

    @Inject
    private EntityManager em;

    @Override
    public void crear(CuentaBancaria cuentaBancaria) {
        this.em.persist(cuentaBancaria);
    }

    @Override
    public void actualizar(CuentaBancaria cuentaBancaria) {
        this.em.merge(cuentaBancaria);
    }

    @Override
    public CuentaBancaria seleccionarPorNumero(String numero) {
        return this.em.createQuery(
            "SELECT c FROM CuentaBancaria c WHERE c.numeroCuenta = :numero",
                CuentaBancaria.class)
                .setParameter("numero", numero)
                .getSingleResult();
    }

}