package es.cesar.hospital.servicio;

import es.cesar.hospital.modelo.Paciente;
import es.cesar.hospital.modelo.Vacuna;
import es.cesar.hospital.repositorio.PacienteRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Optional;

@Service
public class PacienteServicio {

    @Autowired
    private PacienteRepositorio pacienteRepositorio;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public Paciente findByEmail(String email){
        return pacienteRepositorio.findByEmail(email);
    };

    public Paciente registrar(Paciente p){
        p.setContrasena(passwordEncoder.encode(p.getContrasena()));
        return  pacienteRepositorio.save(p);
    }

    public Paciente setvacuna(Paciente p, HttpSession session){
        p.setContrasena(passwordEncoder.encode(p.getContrasena()));
        p.setVacuna((Vacuna) session.getAttribute("tipo_vacuna"));
        return  pacienteRepositorio.save(p);
    }

    public ArrayList<Paciente> obtenerPacientes(){
        return (ArrayList<Paciente>) pacienteRepositorio.findAll();
    }

    public Optional<Paciente> obtenerPorId(Long id){
        return pacienteRepositorio.findById(id);
    }


    public boolean eleminarPaciente(Long id){
        try {
            pacienteRepositorio.deleteById(id);
            return true;
        }catch (Exception error){
            return false;
        }
    }
}
