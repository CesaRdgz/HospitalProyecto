package es.cesar.hospital.servicio;

import es.cesar.hospital.modelo.Vacuna;
import es.cesar.hospital.repositorio.VacunaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VacunaServicio {

    @Autowired
    VacunaRepositorio vacunaRepositorio;

    public Vacuna findByNombre (String nombre){
        return  vacunaRepositorio.findByNombre(nombre);
    }
}
