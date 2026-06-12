package ec.edu.uce.domain.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "ciudadano")
public class Ciudadano {
    @Id
    @SequenceGenerator(name = "seq_ciudadano_generador", sequenceName = "seq_ciudadano", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_ciudadano_generador")
    @Column(name = "seq_id")
    private Integer id;
    @Column(name = "seq_nombre")
    private String nombre;
    @Column(name = "seq_cedula")
    private String cedula;

    public Ciudadano(Integer id, String nombre, String cedula) {
        this.id = id;
        this.nombre = nombre;
        this.cedula = cedula;
    }

    public Ciudadano(String nombre, String cedula) {
        this.nombre = nombre;
        this.cedula = cedula;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getcedula() {
        return cedula;
    }

    public void setcedula(String cedula) {
        this.cedula = cedula;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    @Override
    public String toString() {
        return "Ciudadano [id=" + id + ", nombre=" + nombre + ", cedula=" + cedula + "]";
    }

}