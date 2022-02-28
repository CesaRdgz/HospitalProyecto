package es.cesar.hospital.servicio;

import es.cesar.hospital.modelo.TipoCita;
import es.cesar.hospital.repositorio.TipoCitaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TipoCitaServicio {

    @Autowired
    TipoCitaRepositorio tipoCitaRepositorio;

    public TipoCita registrar(String tipoCita){
        return tipoCitaRepositorio.findByTipo(tipoCita);
    }
}
