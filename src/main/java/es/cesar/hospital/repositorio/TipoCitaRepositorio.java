package es.cesar.hospital.repositorio;

import es.cesar.hospital.modelo.TipoCita;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoCitaRepositorio extends JpaRepository<TipoCita, Long> {
public TipoCita findByTipo(String tipo);
}
