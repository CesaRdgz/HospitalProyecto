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
@Table(name = "conductor")
public class Conductor extends Personal{

    @OneToMany
    @Column(name = "ambulanciaConducida")
    private List<Ambulancia> ambulancia;

    public Conductor(String nombre, String apellidos, List<Ambulancia> ambulancia) {
        super(nombre, apellidos);
        this.ambulancia = ambulancia;
    }
}
