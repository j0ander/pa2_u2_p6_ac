package ec.edu.uce;

import ec.edu.uce.application.service.EstudianteService;
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
            //Estudiante est = new Estudiante("Joel", "Chancusi", LocalDate.of(2005, 1, 29), "ads");
            //Estudiante est1 = new Estudiante(2, "Anderson", "Chancusi", LocalDate.of(2005, 1, 29), "Maculino");
            //Criteria API Query
            this.estudianteService.buscarTodosCriteria().forEach(x -> System.out.println(x.toString()));
            
            this.estudianteService.consultarPorNombreCriteria("Anderson").forEach(x -> System.out.println(x.toString()));
            System.out.println("Nombre y Apellido ---------------------------------------------------------------------------------------------");
            this.estudianteService.consultaDinamicoCriteria("Joel", "Chancusi").forEach(x -> System.out.println(x.toString()));
            System.out.println("Solo el nombre ---------------------------------------------------------------------------------------------");
            this.estudianteService.consultaDinamicoCriteria("Joel", null).forEach(x -> System.out.println(x.toString()));
            System.out.println("Solo el apellido ---------------------------------------------------------------------------------------------");
            this.estudianteService.consultaDinamicoCriteria(null, "Chancusi").forEach(x -> System.out.println(x.toString()));
            System.out.println("Todo null ---------------------------------------------------------------------------------------------");
            this.estudianteService.consultaDinamicoCriteria(null, null).forEach(x -> System.out.println(x.toString()));
            return 0;

        }
    }

}
