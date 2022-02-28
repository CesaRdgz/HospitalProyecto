package es.cesar.hospital.repositorio;


import es.cesar.hospital.modelo.Personal;
import es.cesar.hospital.modelo.TipoPersonal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface PersonalRepositorio extends JpaRepository<Personal, Long> {
    public abstract ArrayList<Personal> findBydni(String dni);

    public Personal findByTurnoAndTipoPersonal(String turno, TipoPersonal tipoPersonal);

}
