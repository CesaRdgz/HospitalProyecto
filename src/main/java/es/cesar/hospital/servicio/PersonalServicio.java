package es.cesar.hospital.servicio;

import es.cesar.hospital.modelo.Paciente;
import es.cesar.hospital.modelo.Personal;
import es.cesar.hospital.modelo.TipoPersonal;
import es.cesar.hospital.repositorio.PersonalRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class PersonalServicio {

    @Autowired
    PersonalRepositorio personalRepositorio;

    public Personal findByTurnoAndTipoPersonal (String turno, TipoPersonal tipoPersonal){
        return personalRepositorio.findByTurnoAndTipoPersonal(turno, tipoPersonal);
    }

    public ArrayList<Personal> obtenerPersonal(){
        return (ArrayList<Personal>) personalRepositorio.findAll();
    }

    public Optional<Personal> obtenerPorId(Long id){
        return personalRepositorio.findById(id);
    }

    public  ArrayList<Personal> obtenerPorDNI(String dni){
        return personalRepositorio.findBydni(dni);
    }

    public boolean eliminarPersonal(Long id){
        try {
            personalRepositorio.deleteById(id);
            return true;
        }catch (Exception error){
            return false;
        }
    }

}
