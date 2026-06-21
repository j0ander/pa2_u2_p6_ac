package ec.edu.uce.domain.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "pelicula")
public class Pelicula {
    @Id
    @SequenceGenerator(name = "seq_pelicula_generador", sequenceName = "seq_pelicula", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "seq_pelicula_generador")
    @Column(name = "peli_id")
    private Integer id;
    @Column(name = "peli_titulo")
    private String titulo;
    @Column(name = "peli_duracion")
    private Integer duracion;
    @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinTable(name = "pelicula_categoria", joinColumns = @JoinColumn(name = "peca_id_pelicula"), inverseJoinColumns = @JoinColumn(name = "peca_id_categoria"))
    private List<Categoria> categorias;
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public Integer getDuracion() {
        return duracion;
    }
    public void setDuracion(Integer duracion) {
        this.duracion = duracion;
    }
    public List<Categoria> getCategorias() {
        return categorias;
    }
    public void setCategorias(List<Categoria> categorias) {
        this.categorias = categorias;
    }
    @Override
    public String toString() {
        List<String> titulosCategotias = (categorias!= null)
                ? categorias.stream().map(Categoria::getNombre).toList()
                : null;

        return "Pelicula [id=" + id + ", titulo=" + titulo + ", categorias=" + titulosCategotias + "]";
    }
     
}
