package ec.edu.uce;

import java.time.LocalDate;

import ec.edu.uce.application.service.EstudianteService;
import ec.edu.uce.domain.model.Estudiante;
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
        private EstudianteService estudianteService;

        @Override
        public int run(String... args) {
            System.out.println("Conexion a base de datos");
            Estudiante est = new Estudiante("Joel", "Chancusi", LocalDate.of(2005, 1, 29), "ads");
            Estudiante est1 = new Estudiante(2, "Anderson", "Chancusi", LocalDate.of(2005, 1, 29), "Maculino");
           
            //Native Query
            //this.estudianteService.buscarTodosNative().forEach(x -> System.out.println(x.toString()));
            return 0;

        }
    }

}
