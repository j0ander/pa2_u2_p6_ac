package ec.edu.uce;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import ec.edu.uce.application.service.ClienteService;
import ec.edu.uce.domain.model.Cliente;
import ec.edu.uce.domain.model.Pedido;
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
        private ClienteService cs;

        @Override
        public int run(String... args) {
            System.out.println("Conexion a base de datos");
            Cliente cl = new Cliente(); 
            cl.setNombre("Anderson0");
            cl.setCedula("987654321");
           
            Pedido p1 = new Pedido();
            p1.setTotal(Double.valueOf(100));
            p1.setCliente(cl);
            p1.setFecha(LocalDate.of(2026, 10, 10));
            Pedido p2 = new Pedido();
            p2.setTotal(Double.valueOf(100));
            p2.setCliente(cl);
            p2.setFecha(LocalDate.of(2026, 1, 5));

            List<Pedido> pedidos = new ArrayList<>();
            pedidos.add(p1);
            pedidos.add(p2);
            
            cl.setPedidos(pedidos);

            this.cs.guardar(cl);
            return 0;

        }
    }

}
