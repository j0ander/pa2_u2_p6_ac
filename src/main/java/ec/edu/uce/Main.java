package ec.edu.uce;


import ec.edu.uce.application.service.ProfesorService;
import ec.edu.uce.domain.model.Profesor;
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
        private ProfesorService profesorService;

        @Override
        public int run(String... args) {

            Profesor profesor1 = new Profesor(
                    "Anderson",
                    "Chancusi",
                    1723456789,
                    "Programacion");

            Profesor profesor2 = new Profesor(3,
                    "Anderson",
                    "Chancusi",
                    1751652809,
                    "Programacion");

            Profesor profesor3 = new Profesor(
                    "Joel",
                    "Pilataxi",
                    1712345678,
                    "Base de Datos");

            this.profesorService.guardar(profesor1);
            // Modifico la cedula
            this.profesorService.actualizar(profesor2);
            this.profesorService.eliminar(3);
            System.out.println(this.profesorService.buscar(2).toString());
            return 0;

        }
    }

}
