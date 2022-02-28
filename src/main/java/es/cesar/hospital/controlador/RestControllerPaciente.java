package es.cesar.hospital.controlador;
import es.cesar.hospital.modelo.Cita;
import es.cesar.hospital.modelo.Paciente;
import es.cesar.hospital.modelo.Personal;
import es.cesar.hospital.repositorio.PacienteRepositorio;
import es.cesar.hospital.servicio.PacienteServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Past;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/paciente")
public class RestControllerPaciente {

    @Autowired
    private PacienteServicio pacienteServicio;

    @GetMapping()
    public ArrayList<Paciente> obtenerPacientes(){
        return pacienteServicio.obtenerPacientes();
    }

    @GetMapping(path = "/{id}")
    public Optional <Paciente> obtenerPorId(@PathVariable("id") Long id){
        return this.pacienteServicio.obtenerPorId(id);
    }

    @DeleteMapping(path = "/{id}")
    public String eleminarPorId(@PathVariable ("id") Long id){
        boolean eliminado = this.pacienteServicio.eleminarPaciente(id);
        if (eliminado){
            return "Se elimino el paciente " + id;
        }else{
            return "No se pudo eliminar al paciente con id " + id;
        }
    }

}
