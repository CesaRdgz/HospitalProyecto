package es.cesar.hospital.controlador;

import es.cesar.hospital.modelo.Paciente;
import es.cesar.hospital.servicio.PacienteServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class PerfilController {

    @Autowired
    PacienteServicio pacienteServicio;

    @GetMapping("/perfil")
    public String index(Model model){
        return "perfil";
    }

    @GetMapping("/logout")
    public String logout(Model model, HttpSession session){
        session.invalidate();
        return "redirect:/";
    }

    @GetMapping("/editPassword")
    public String edit(Model model, HttpSession session, HttpServletRequest request){
        Paciente paciente = (Paciente) session.getAttribute("usuario");
        paciente.setContrasena(request.getParameter("contrasena"));
        pacienteServicio.registrar(paciente);
        session.invalidate();
        return "redirect:/auth/login";
    }
}
