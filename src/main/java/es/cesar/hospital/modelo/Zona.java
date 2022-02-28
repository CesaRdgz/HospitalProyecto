package es.cesar.hospital.modelo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "zona")
public class Zona {

    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    private long id;

    @Column(name = "especializacion", nullable = false)
    private String especializacion;

    @OneToOne
    @JoinColumn(name = "planta", nullable = false)
    private Planta planta;

    @OneToMany
    @JoinColumn(name = "zona")
    private List<Habitacion> habitaciones;

    public Zona( String especializacion, Planta planta ) {

        this.especializacion = especializacion;
        this.planta = planta;

    }
}
