package es.cesar.hospital.modelo;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer"})
@Table(name = "cita")
public class Cita {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "fecha", nullable = true)
    private Date fecha;

    @Column(name = "turno", nullable = true)
    private String turno;

    @Column(name = "especificacion", nullable = true)
    private String especificacion;

    @Column(name = "descripcion_patalogica", nullable = true)
    private String descripcion_patalogica;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "medico", nullable = true)
    private Personal personal;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "paciente", nullable = true)
    private Paciente paciente;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tipo_cita", nullable = true)
    private TipoCita tipoCita;

    public Cita(Date fecha, String turno, String especificacion, String descripcion_patalogica, Personal personal, Paciente paciente, TipoCita tipoCita) {
        this.fecha = fecha;
        this.turno = turno;
        this.especificacion = especificacion;
        this.descripcion_patalogica = descripcion_patalogica;
        this.personal = personal;
        this.paciente = paciente;
        this.tipoCita = tipoCita;
    }

    public Cita() {
    }
}
