package es.cesar.hospital.repositorio;

import es.cesar.hospital.modelo.Habitacion;
import es.cesar.hospital.modelo.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HabitacionRepositorio extends JpaRepository<Habitacion, Long> {
}
