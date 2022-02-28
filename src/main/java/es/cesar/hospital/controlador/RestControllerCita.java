package es.cesar.hospital.controlador;


import es.cesar.hospital.modelo.Cita;
import es.cesar.hospital.modelo.Paciente;
import es.cesar.hospital.modelo.Personal;
import es.cesar.hospital.repositorio.CitaRepositorio;
import es.cesar.hospital.servicio.CitaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;

@RestController
@RequestMapping("/citas")

public class RestControllerCita {

    @Autowired
    CitaServicio citaServicio;

    @Autowired
    CitaRepositorio citaRepositorio;


    @GetMapping()
    public ArrayList<Cita> obtenerCitas(){
        return citaServicio.obtenerCitas();
    }

    @GetMapping("/query")
    public ArrayList<Cita> citaCliente(@RequestParam("id") Long id){
        return this.citaServicio.CitaCliente(id);
    }

    @DeleteMapping("/eliminar/{id}")
    public void eliminarCita(@PathVariable("id") Long id){
        citaRepositorio.deleteById(id);
    }

}
