package ec.edu.uce;

import java.math.BigDecimal;

import ec.edu.uce.application.service.CuentaBancariaService;
import ec.edu.uce.application.service.TransferenciaService;
import ec.edu.uce.domain.model.CuentaBancaria;
import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.QuarkusApplication;
import io.quarkus.runtime.annotations.QuarkusMain;
import jakarta.inject.Inject;

@QuarkusMain
public class Main {

    public static void main(String[] args) {
        Quarkus.run(App.class, args);

    }

    public static class App implements QuarkusApplication {

        @Inject
        private CuentaBancariaService cuentaBancariaService;


        @Inject
        private TransferenciaService transferenciaService;


        @Override
        public int run(String... args) {

            System.out.println("Conexión a base de datos");

            CuentaBancaria cuenta1 = new CuentaBancaria();
            cuenta1.setNumeroCuenta("005");
            cuenta1.setTitular("Anderson");
            cuenta1.setSaldo(new BigDecimal("1000"));

            CuentaBancaria cuenta2 = new CuentaBancaria();
            cuenta2.setNumeroCuenta("006");
            cuenta2.setTitular("Joel");
            cuenta2.setSaldo(new BigDecimal("500"));

            this.cuentaBancariaService.guardar(cuenta1);
            this.cuentaBancariaService.guardar(cuenta2);

            this.transferenciaService.transferencia(
                    "003",
                    "004",
                    new BigDecimal("10"));


            return 0;
        }
    }

}
