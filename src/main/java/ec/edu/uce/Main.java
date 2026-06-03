package ec.edu.uce;

import ec.edu.uce.application.service.ProfesorService;
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
            System.out.println("Conexion a base de datos");
            this.profesorService.consultarPorMateriaCriteria("Base de Datos")
                    .forEach(x -> System.out.println(x.toString()));
            this.profesorService.consultarNombrePorInicialCriteria("a").forEach(x -> System.out.println(x.toString()));
            this.profesorService.contarPorApellidosCriteria().forEach(x -> {
                String apellido = (String) x[0];
                Long cantidad = (Long) x[1];

                System.out.println(apellido + " -> " + cantidad);
            });

            this.profesorService.consultarDinamicaCriteria(null, null, null)
                    .forEach(x -> System.out.println(x.toString()));
            this.profesorService.consultarDinamicaCriteria("Anderson", null, null)
                    .forEach(x -> System.out.println(x.toString()));
            this.profesorService.consultarDinamicaCriteria("Anderson", "Chancusi", null)
                    .forEach(x -> System.out.println(x.toString()));
            this.profesorService.consultarDinamicaCriteria("Anderson", "Chancusi", "Programacion")
                    .forEach(x -> System.out.println(x.toString()));
            this.profesorService.consultarDinamicaCriteria(null, null, "Programacion")
                    .forEach(x -> System.out.println(x.toString()));

            return 0;

        }
    }
}
