package es.cesar.hospital.controlador;
import es.cesar.hospital.modelo.Personal;
import es.cesar.hospital.repositorio.PersonalRepositorio;
import es.cesar.hospital.servicio.PersonalServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/personal")
public class RestControllerPersonal {

    @Autowired
    private PersonalServicio personalService;

    @Autowired
    PersonalRepositorio personalRepositorio;

    @GetMapping()
    public List<Personal> obtenerPersonal(){
        return personalService.obtenerPersonal();
    }

    @GetMapping(path = "/{id}")
    public Optional <Personal> obtenerPorId(@PathVariable("id") Long id){
        return this.personalService.obtenerPorId(id);
    }

    @GetMapping("/query")
    public ArrayList<Personal> obtenerPorDNI(@RequestParam("dni") String dni){
        return this.personalService.obtenerPorDNI(dni);
    }

    @PutMapping("/actualizar")
    public void actualizarPersonal(@RequestBody Personal personal){
        personalRepositorio.save(personal);
    }
    @DeleteMapping("/eliminar/{id}")
    public void eliminarPersonal(@PathVariable("id") Long id){
        personalRepositorio.deleteById(id);
    }
}

