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
@Table(name = "planta")
public class Planta {

    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "piso", nullable = false)
    private int Piso;

    @OneToMany
    @JoinColumn(name = "Zona")
    private List<Zona> zona;

    public Planta(int piso) {
        Piso = piso;
    }


}
