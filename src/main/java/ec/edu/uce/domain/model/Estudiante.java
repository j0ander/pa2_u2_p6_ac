package ec.edu.uce.domain.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity // Anotación para indicar que esta clase es una entidad de JPA
@Table(name = "estudiante") // Anotación para especificar el nombre de la tabla en la base de datos
public class Estudiante {
    // cada atributo de la clase representa una columna en la tabla de la base de
    // datos

    @Id // Anotación para indicar que este atributo es la clave primaria de la entidad
    @SequenceGenerator(name = "seq_estudiante_generador", sequenceName = "seq_estudiante", allocationSize = 1) // Anotación
                                                                                                               // para
                                                                                                               // definir
                                                                                                               // un
                                                                                                               // generador
                                                                                                               // de
                                                                                                               // secuencia
                                                                                                               // para
                                                                                                               // el ID
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_estudiante_generador") // Anotación para
                                                                                                // indicar que el valor
                                                                                                // de esta columna se
                                                                                                // generará
                                                                                                // automáticamente
    @Column(name = "estu_id") // Anotación para especificar el nombre de la columna en la base de datos
    private Integer id;

    @Column(name = "estu_nombre")
    private String nombre;

    @Column(name = "estu_apellido")
    private String apellido;

    @Column(name = "estu_fecha_nacimiento")
    private LocalDate fechaNacimiento;

    @Column(name = "estu_genero")
    private String genero;
    @Column(name = "estu_cedula")
    private String cedula;

    public Estudiante() {
    }

    public Estudiante(Integer id, String nombre, String apellido, LocalDate fechaNacimiento, String genero) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNacimiento = fechaNacimiento;
        this.genero = genero;
    }

    public Estudiante(String nombre, String apellido, LocalDate fechaNacimiento, String genero) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNacimiento = fechaNacimiento;
        this.genero = genero;
    }
    
    public Estudiante(Integer id, String nombre, String apellido, LocalDate fechaNacimiento, String genero,
            String cedula) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNacimiento = fechaNacimiento;
        this.genero = genero;
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

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }
    
    

    @Override
    public String toString() {
        return "Estudiante [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", fechaNacimiento="
                + fechaNacimiento + ", genero=" + genero + "]";
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

}
