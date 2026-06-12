package ec.edu.uce.domain.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "pasaporte")
public class Pasaporte {
    @Id
    @SequenceGenerator(name = "seq_pasaporte_generador", sequenceName = "seq_pasaporte", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_pasaporte_generador")
    @Column(name = "pas_id")
    private Integer id;
    @Column(name = "pas_numero_pasaporte")
    private String numeroPasaporte;
    @Column(name = "pas_fecha_nacimiento")
    private String fechaVencimiento;
    @OneToOne
    @JoinColumn(name = "pas_ciudadano")
    private Ciudadano ciudadano;

    public Pasaporte(Integer id, String numeroPasaporte, String fechaVencimiento) {
        this.id = id;
        this.numeroPasaporte = numeroPasaporte;
        this.fechaVencimiento = fechaVencimiento;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumeroPasaporte() {
        return numeroPasaporte;
    }

    public void setNumeroPasaporte(String numeroPasaporte) {
        this.numeroPasaporte = numeroPasaporte;
    }

    public String getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(String fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public Ciudadano getCiudadano() {
        return ciudadano;
    }

    public void setCiudadano(Ciudadano ciudadano) {
        this.ciudadano = ciudadano;
    }

    @Override
    public String toString() {
        return "Pasaporte [id=" + id + ", numeroPasaporte=" + numeroPasaporte + ", fechaVencimiento=" + fechaVencimiento
                + ", ciudadano=" + ciudadano + "]";
    }

    
}