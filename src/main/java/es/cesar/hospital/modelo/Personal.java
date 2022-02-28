package es.cesar.hospital.modelo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer"})
@Table(name = "personal", uniqueConstraints ={
        @UniqueConstraint(columnNames = "dni"),
        @UniqueConstraint(columnNames = "telefono")
})
public class Personal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "apellidos", nullable = false)
    private String apellidos;

    @Column(name = "dni", nullable = false)
    private String dni;

    @Column(name = "telefono", nullable = false)
    private String telefono;

    @Column(name = "turno", nullable = false)
    private String turno;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="tipo_personal", nullable = true)
    private TipoPersonal tipoPersonal;


    //Constructores

    public Personal(String nombre, String apellidos, String dni, String telefono, String turno, TipoPersonal tipoPersonal) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.dni = dni;
        this.telefono = telefono;
        this.turno = turno;
        this.tipoPersonal = tipoPersonal;

    }

    public Personal(String nombre, String apellidos) {

    }

    public Personal() {

    }
}
