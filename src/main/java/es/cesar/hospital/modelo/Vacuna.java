package es.cesar.hospital.modelo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name = "vacuna")
public class Vacuna {

    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "nombre", nullable = true)
    private String nombre;
    
    @Column(name = "dosis", nullable = true)
    private int dosis;

    public Vacuna(String nombre, int dosis) {
        this.nombre = nombre;
        this.dosis = dosis;
    }
}
