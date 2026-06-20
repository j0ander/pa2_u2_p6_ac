package ec.edu.uce;

import ec.edu.uce.application.service.AlumnoService;
import ec.edu.uce.application.service.MateriaService;
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
        private AlumnoService alumnoService;

        @Inject
        private MateriaService materiaService;

        @Override
        public int run(String... args) {
            System.out.println("Conexion a base de datos");
            /* // Alumno que tomo dos materias
            Alumno al = new Alumno();
            al.setNombre("Anderson");
            Materia m1 = new Materia();
            m1.setNombre("P. Avanzada");
            m1.setNumeroCreditos(4);

            Materia m2 = new Materia();
            m2.setNombre("P. Web");
            m2.setNumeroCreditos(6);

            List<Materia> materias = List.of(m1, m2);
            
            al.setMaterias(materias);
            
            // Insert mediante el service Alumno
            this.alumnoService.guardar(al); */
            
            /* Materia m3 = new Materia();
            m3.setNombre("P. Distribuida");
            m3.setNumeroCreditos(8);
            
            Alumno a2 = new Alumno();
            a2.setNombre("Joel");
            a2.setMaterias(List.of(m3));
            
            Alumno a3 = new Alumno();
            a3.setNombre("AndersonJoel");
            a3.setMaterias(List.of(m3));
            List<Alumno> alumnos = List.of(a2, a3);
            
            m3.setAlumnos(alumnos);
            
            // Insert mediante el service materia
            this.materiaService.guardar(m3); */

            //crear dentro del service de materia consulta por id
            this.materiaService.buscarPorId(4).getAlumnos().forEach(x -> System.out.println(x.toString()));
            
            this.alumnoService.buscarPorId(2).getMaterias().forEach(x -> System.out.println(x.toString()));
            return 0;

        }
    }

}
