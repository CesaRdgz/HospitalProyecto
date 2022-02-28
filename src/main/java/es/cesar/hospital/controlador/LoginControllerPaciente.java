package es.cesar.hospital.controlador;

import es.cesar.hospital.modelo.Paciente;
import es.cesar.hospital.servicio.PacienteServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@Controller
public class LoginControllerPaciente {

    @Autowired
    private PacienteServicio pacienteServicio;

    @GetMapping("/auth/registro")
    public String registroForm(Model model){
        model.addAttribute("paciente", new Paciente());
        return "registro";
    }

    @PostMapping("/auth/registro")
    public String registro(@Validated @ModelAttribute Paciente paciente , BindingResult result, Model model ){
        if(result.hasErrors()){
            return "redirect:/auth/registro";
        } else {
            model.addAttribute("paciente", pacienteServicio.registrar(paciente));
        }
        return "redirect:/auth/login";
    }

    @GetMapping("/auth/login")
    public String login(Model model){
        model.addAttribute("paciente", new Paciente());
        return "login";
    }

    @GetMapping("/auth/returnlogin")
    public String returnlogin(Model model){
        return "login";
    }

}
