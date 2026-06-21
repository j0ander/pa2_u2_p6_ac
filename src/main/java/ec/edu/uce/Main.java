package ec.edu.uce;

import java.util.ArrayList;
import java.util.List;

import ec.edu.uce.application.service.CategoriaService;
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
        @Inject
        private CategoriaService cs;

        @Override
        public int run(String... args) {
            System.out.println("Conexion a base de datos");
            /*
             * Categoria catAccion = new Categoria();
             * catAccion.setNombre("Acción");
             * catAccion.
             * setDescripcion("Películas con persecuciones, peleas y mucha adrenalina.");
             * 
             * Categoria catSciFi = new Categoria();
             * catSciFi.setNombre("Ciencia Ficción");
             * catSciFi.
             * setDescripcion("Historias basadas en futuros distópicos y ciencia avanzada."
             * );
             * 
             * Pelicula pelicula = new Pelicula();
             * pelicula.setTitulo("Matrix");
             * pelicula.setDuracion(136);
             * pelicula.setCategorias(List.of(catAccion,catSciFi));
             * 
             * this.ps.guardar(pelicula);
             */

            /* Categoria generoFavorito = new Categoria();
            generoFavorito.setNombre("Cine Premium");
            generoFavorito.setDescripcion("Selección de las mejores obras cinematográficas.");
            
            Pelicula peliSciFi = new Pelicula();
            peliSciFi.setTitulo("Interstellar");
            peliSciFi.setDuracion(169);
            peliSciFi.setCategorias(List.of(generoFavorito));

            Pelicula peliAccion = new Pelicula();
            peliAccion.setTitulo("John Wick");
            peliAccion.setDuracion(101);
            peliAccion.setCategorias(List.of(generoFavorito));

            generoFavorito.setPeliculas(List.of(peliSciFi, peliAccion));

            this.cs.guardar(generoFavorito); */

            this.ps.buscarPorId(1).getCategorias().forEach(System.out::println);
            this.cs.buscarPorId(3).getPeliculas().forEach(System.out::println);

            return 0;
        }
    }
}
