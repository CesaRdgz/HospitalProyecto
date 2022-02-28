package es.cesar.hospital.servicio;

import es.cesar.hospital.modelo.*;
import es.cesar.hospital.repositorio.CitaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;

@Service
public class CitaServicio {

    @Autowired
    private CitaRepositorio citaRepositorio;

    @Autowired
    private PersonalServicio personalService;

    @Autowired
    private TipoPersonalServicio tipoPersonalServicio;

    @Autowired
    private VacunaServicio vacunaServicio;

    @Autowired
    private PacienteServicio pacienteServicio;


    public Cita registrar(Cita cita, HttpSession session){

        Paciente paciente = (Paciente) session.getAttribute("usuario");
        Personal personal = personalService.findByTurnoAndTipoPersonal(cita.getTurno(),
                            tipoPersonalServicio.findByTipo(cita.getEspecificacion()));
        TipoCita tipoCita = (TipoCita) session.getAttribute("tipo_cita");

        if (session.getAttribute("tipo_vacuna") != null){
            pacienteServicio.setvacuna(paciente, session);
        }

        cita.setTipoCita(tipoCita);
        cita.setPaciente(paciente);
        cita.setPersonal(personal);

        return  citaRepositorio.save(cita);
    }

    public ArrayList<Cita> obtenerCitas(){
        return (ArrayList<Cita>) citaRepositorio.findAll();
    }

    public ArrayList<Cita> CitaCliente(Long id){
        return citaRepositorio.findByPacienteId(id);
    }
}

