package ec.edu.uce;

import java.util.ArrayList;
import java.util.List;
import ec.edu.uce.application.service.PeliculaService;
import ec.edu.uce.domain.model.Categoria;
import ec.edu.uce.domain.model.Pelicula;
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
        private PeliculaService ps;

        @Override
        public int run(String... args) {
            System.out.println("Conexion a base de datos");
            return 0;
        }
    }
}
