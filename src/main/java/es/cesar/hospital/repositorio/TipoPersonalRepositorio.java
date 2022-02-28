package es.cesar.hospital.repositorio;

import es.cesar.hospital.modelo.TipoPersonal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoPersonalRepositorio extends JpaRepository<TipoPersonal, Long> {
    public TipoPersonal findByTipo(String tipo);

}
