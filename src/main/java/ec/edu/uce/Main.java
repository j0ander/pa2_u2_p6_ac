package ec.edu.uce;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import ec.edu.uce.application.service.AutorService;
import ec.edu.uce.domain.model.Autor;
import ec.edu.uce.domain.model.Libro;
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
        private AutorService as;

        @Override
        public int run(String... args) {
            System.out.println("Conexion a base de datos");
            Autor autor = new Autor();
            autor.setNombre("Gabriel García Márquez");
            autor.setNacionalidad("Colombiano");

            Libro l1 = new Libro();
            l1.setTitulo("Cien años de soledad");
            l1.setFechaPublicacion(LocalDate.of(1967, 5, 30));
            l1.setAutor(autor);

            Libro l2 = new Libro();
            l2.setTitulo("El amor en los tiempos del cólera");
            l2.setFechaPublicacion(LocalDate.of(1985, 3, 5));
            l2.setAutor(autor);

            List<Libro> libros = new ArrayList<>();
            libros.add(l1);
            libros.add(l2);

            autor.setLibros(libros);

            this.as.guardar(autor);
            return 0;
        }
    }
}
