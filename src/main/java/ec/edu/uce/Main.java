package ec.edu.uce;

import ec.edu.uce.application.service.EstudianteService;
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
            System.out.println("Conexion a base de datos");
            this.profesorService.buscarTodosNative().forEach(x -> System.out.println(x.toString()));
            this.profesorService.consultarNombrePorMateriaNative("Base de Datos")
                    .forEach(x -> System.out.println(x.toString()));
            System.out.println(this.profesorService.consultarPorNumeroFinalCedulaNative(8).toString());
            this.profesorService.contarPorApellidosNative().forEach(x -> {
                String apellido = (String) x[0];
                Long cantidad = (Long) x[1];
                System.out.println("Apellido: " + apellido + " - Cantidad: " + cantidad);
            });
            return 0;

        }
    }

}
