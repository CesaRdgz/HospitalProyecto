package es.cesar.hospital.controlador;

import es.cesar.hospital.modelo.Cita;
import es.cesar.hospital.modelo.Paciente;
import es.cesar.hospital.repositorio.CitaRepositorio;
import es.cesar.hospital.servicio.CitaServicio;
import es.cesar.hospital.servicio.TipoCitaServicio;
import es.cesar.hospital.servicio.VacunaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class CitaController {

    @Autowired
    private CitaServicio citaServicio;

    @Autowired
    private TipoCitaServicio tipoCitaServicio;

    @Autowired
    private CitaRepositorio citaRepositorio;

    @Autowired
    private VacunaServicio vacunaServicio;

    @GetMapping("/cita")
    public String index (Model model){
        if ( model.getAttribute("paciente") == null){
            return "redirect:/auth/login";
        }else{
            model.addAttribute("cita", new Cita());
            return "index";
        }
    }

    @PostMapping("/cita")
    public String cita(@Validated @ModelAttribute("cita") Cita cita , BindingResult result, Model model, HttpSession session, HttpServletRequest request){

        if ( session.getAttribute("usuario") != null){
            if(result.hasErrors()){
                return "redirect:/";
            } else {
                session.setAttribute("tipo_cita", tipoCitaServicio.registrar(request.getParameter("tipo_cita")));
                model.addAttribute("cita", citaServicio.registrar(cita, session));
                return "redirect:/";
            }

        }else{
            return "redirect:/auth/login";
        }

    }


    @GetMapping("/citaVacuna")
    public String indexVacuna (Model model, HttpSession session){
        if ( session.getAttribute("usuario") == null){
            return "redirect:/auth/login";
        }else{
            model.addAttribute("cita", new Cita());
            return "index";
        }
    }

    @PostMapping("/citaVacuna")
    public String citaVacuna(@Validated @ModelAttribute("cita") Cita cita , BindingResult result, Model model, HttpSession session, HttpServletRequest request){

        if (session.getAttribute("usuario") != null){
            if(result.hasErrors()){
                return "redirect:/";
            } else {
                session.setAttribute("tipo_vacuna", vacunaServicio.findByNombre(request.getParameter("tipo_vacuna")));
                session.setAttribute("tipo_cita", tipoCitaServicio.registrar(request.getParameter("tipo_cita1")));
                model.addAttribute("cita", citaServicio.registrar(cita, session));
                return "redirect:/";
            }
        }else{
            return "redirect:/auth/login";
        }
    }

}
