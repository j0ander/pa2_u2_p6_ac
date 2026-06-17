package ec.edu.uce;

import java.time.LocalDateTime;

import ec.edu.uce.application.service.CiudadanoService;
import ec.edu.uce.application.service.PasaporteService;
import ec.edu.uce.application.service.ProfesorService;
import ec.edu.uce.domain.model.Ciudadano;
import ec.edu.uce.domain.model.Pasaporte;
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
        private CiudadanoService cs;
        @Inject
        private PasaporteService ps;
        @Override
        public int run(String... args) {
            System.out.println("Conexion a base de datos");
            Pasaporte pas = new Pasaporte( "129947298", "29/01/2005", new Ciudadano("Anderson Joel", "17612899809"));
            this.ps.guardar(pas);
            return 0;

        }
    }
}
