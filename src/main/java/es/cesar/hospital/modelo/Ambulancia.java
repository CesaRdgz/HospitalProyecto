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
@Table(name = "ambulancia")
public class Ambulancia {

    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "matricula")
    private String matricula;

    @Column(name = "clase")
    private String clase;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "conductor")
    private List<Conductor> conductor;

    public Ambulancia(String matricula, String clase) {
        this.matricula = matricula;
        this.clase = clase;
        this.conductor = null;
    }
}