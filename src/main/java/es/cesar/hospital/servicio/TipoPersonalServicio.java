package es.cesar.hospital.servicio;

import es.cesar.hospital.modelo.TipoPersonal;
import es.cesar.hospital.repositorio.TipoPersonalRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TipoPersonalServicio {

    @Autowired
    TipoPersonalRepositorio tipoPersonalRepositorio;

    public TipoPersonal findByTipo (String tipo){
        return tipoPersonalRepositorio.findByTipo(tipo);
    }
}
