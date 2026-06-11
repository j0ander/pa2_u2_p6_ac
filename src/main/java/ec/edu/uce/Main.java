package ec.edu.uce;

import java.time.LocalDateTime;

import ec.edu.uce.application.service.CiudadanoService;
import ec.edu.uce.domain.model.Ciudadano;
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

        @Override
        public int run(String... args) {
            System.out.println("Conexion a base de datos");
            Ciudadano cd = new Ciudadano( "Anderson", LocalDateTime.now());
            ciudadanoService.guardar(cd);
            return 0;

        }
    }

}
