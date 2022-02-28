package es.cesar.hospital.modelo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="habitacion")
public class Habitacion {

    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name="ocupado", nullable = false)
    private boolean ocupado;

    @Column(name="numeroHabitacion", nullable = false)
    private int numeroHabitacion;

    @OneToOne
    @JoinColumn(name="zona")
    private Zona zona;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "paciente")
    private Paciente paciente;

    public Habitacion(int numeroHabitacion, Zona zona) {
        this.ocupado = false;
        this.zona = zona;
        this.numeroHabitacion = numeroHabitacion;
        this.paciente = null;
    }

}
