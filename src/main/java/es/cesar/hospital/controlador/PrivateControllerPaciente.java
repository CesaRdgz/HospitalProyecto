package es.cesar.hospital.controlador;

import es.cesar.hospital.modelo.Paciente;
import es.cesar.hospital.servicio.PacienteServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/private")
public class PrivateControllerPaciente {

    @Autowired
    private PacienteServicio pacienteServicio;

    @GetMapping("/index")
    public String index(Authentication auth, HttpSession session){
        String email = auth.getName() ;

        if (session.getAttribute("usuario") == null){
            Paciente paciente = pacienteServicio.findByEmail(email);
            session.setAttribute("usuario", paciente);
        }
        return "index";
    }
}
