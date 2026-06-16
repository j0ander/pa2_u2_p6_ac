package ec.edu.uce;

import java.time.LocalDateTime;

import ec.edu.uce.application.service.CiudadanoService;
import ec.edu.uce.application.service.EmpleadoService;
import ec.edu.uce.domain.model.Ciudadano;
import ec.edu.uce.domain.model.Empleado;
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
        private CiudadanoService ciudadanoService;
        @Inject
        private EmpleadoService es;

        @Override
        public int run(String... args) {
            System.out.println("Conexion a base de datos");

            Ciudadano cd1 = new Ciudadano("AndersonNuevo", LocalDateTime.now());

            Empleado em2 = new Empleado(LocalDateTime.now(), null);
            em2.setCiudadano(cd1);
            this.es.guardar(em2);

            return 0;

        }
    }

}
