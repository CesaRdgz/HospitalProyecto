package es.cesar.hospital.repositorio;

import es.cesar.hospital.modelo.Paciente;
import es.cesar.hospital.modelo.Zona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ZonaRepositorio extends JpaRepository<Zona, Long> {

}
