package es.cesar.hospital.repositorio;

import es.cesar.hospital.modelo.Ambulancia;
import es.cesar.hospital.modelo.Cita;
import es.cesar.hospital.modelo.Paciente;
import es.cesar.hospital.modelo.Personal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface CitaRepositorio extends JpaRepository<Cita, Long> {
    public ArrayList<Cita> findByPacienteId(Long id);
}
