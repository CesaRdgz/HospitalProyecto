package es.cesar.hospital.modelo;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer"})
@Table(name = "paciente", uniqueConstraints ={
                                                @UniqueConstraint(columnNames = "email"),
                                                @UniqueConstraint(columnNames = "dni"),
                                                @UniqueConstraint(columnNames = "telefono")
})
public class Paciente {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "apellidos", nullable = false)
    private String apellidos;

    @Column(name = "contrasena", nullable = false)
    private String contrasena;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "dni", nullable = false)
    private String dni;

    @Column(name = "telefono", nullable = false)
    private String telefono;

    @OneToOne
    @JoinColumn(name = "vacuna")
    private Vacuna vacuna;

    @OneToOne
    @JoinColumn(name = "habitacionPaciente")
    private Habitacion habitacion;

    //Constructores

    public Paciente(String nombre, String apellidos, String contrasena, String email, String dni, String telefono, Vacuna vacuna) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.contrasena = contrasena;
        this.email = email;
        this.dni = dni;
        this.telefono = telefono;
        this.vacuna = vacuna;
    }

    public Paciente(Long id, String nombre, String apellidos, String contrasena, String email, String dni, String telefono) {
        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.contrasena = contrasena;
        this.email = email;
        this.dni = dni;
        this.telefono = telefono;
    }

    public Paciente() {

    }
}
