package es.cesar.hospital.BBDD;

import es.cesar.hospital.modelo.*;
import es.cesar.hospital.repositorio.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

@Service
public class Conectar implements CommandLineRunner {

    private final TipoCitaRepositorio tipoCita;
    private final TipoPersonalRepositorio tipoPersonal;
    private final AmbulaciaRepositorio ambulacia;
    private final ConductorRepositorio conductor;
    private final HabitacionRepositorio habitacion;
    private final PlantaRepositorio planta;
    private final VacunaRepositorio vacuna;
    private final ZonaRepositorio zona;
    private final PersonalRepositorio personal;

    @Autowired
    public Conectar(
            TipoCitaRepositorio tipoCita,
            TipoPersonalRepositorio tipoPersonal,
            AmbulaciaRepositorio ambulacia,
            ConductorRepositorio conductor,
            HabitacionRepositorio habitacion,
            PlantaRepositorio planta,
            VacunaRepositorio vacuna,
            ZonaRepositorio zona,
            PersonalRepositorio personal){
        this.tipoCita = tipoCita;
        this.tipoPersonal = tipoPersonal;
        this.ambulacia = ambulacia;
        this.conductor = conductor;
        this.habitacion = habitacion;
        this.planta = planta;
        this.vacuna = vacuna;
        this.zona = zona;
        this.personal = personal;
    }

    @Override
    public void run(String... strings) {

        TipoCita tipoCita1 = new TipoCita("Vacunacion");
        this.tipoCita.save(tipoCita1);
        TipoCita tipoCita2 = new TipoCita("Consulta");
        this.tipoCita.save(tipoCita2);
        TipoCita tipoCita3 = new TipoCita("Urgencia");
        this.tipoCita.save(tipoCita3);


        TipoPersonal pediatra = new TipoPersonal("Pediatra");
        this.tipoPersonal.save(pediatra);
        TipoPersonal cardiologo = new TipoPersonal("Cardiologo");
        this.tipoPersonal.save(cardiologo);
        TipoPersonal psiquiatra = new TipoPersonal("Psiquiatra");
        this.tipoPersonal.save(psiquiatra);
        TipoPersonal enfermero = new TipoPersonal("Enfermero");
        this.tipoPersonal.save(enfermero);
        TipoPersonal cirujano = new TipoPersonal("Cirujano");
        this.tipoPersonal.save(cirujano);
        TipoPersonal neurologo = new TipoPersonal("Neurologo");
        this.tipoPersonal.save(neurologo);

        this.vacuna.save(new Vacuna("Pfizer", 2));
        this.vacuna.save(new Vacuna("Moderna", 2));
        this.vacuna.save(new Vacuna("Astrazeneca", 3));

        this.ambulacia.save(new Ambulancia("2080DRT", "A1"));
        this.ambulacia.save(new Ambulancia("3270GSP", "A1"));
        this.ambulacia.save(new Ambulancia("5719FJH", "A2"));
        this.ambulacia.save(new Ambulancia("1073DBN", "A2"));
        this.ambulacia.save(new Ambulancia("4084TEP", "B"));
        this.ambulacia.save(new Ambulancia("9620IOP", "B"));
        this.ambulacia.save(new Ambulancia("0581NJK", "B"));
        this.ambulacia.save(new Ambulancia("8719ASX", "C"));
        this.ambulacia.save(new Ambulancia("3584INL", "C"));
        this.ambulacia.save(new Ambulancia("6217RMY", "C"));

        int contadorZona = 0;

        for (int i = 0; i < 3; i++) {
            String [] arrayEsp = {"Enfermeria", "Pediatria", "Psiquiatria", "Neurologia", "Cardiologia", "Cirugia"};
            Planta planta = new Planta(i + 1);
            this.planta.save(planta);
            for (int j = 0; j < 2; j++) {
                Zona zona = new Zona(arrayEsp[contadorZona], planta);
                this.zona.save(zona);
                for (int k = 0; k < 10; k++) {
                    this.habitacion.save(new Habitacion(k + 1, zona));
                }
            }
        }

        Personal personal1 = new Personal("Alfredo","Perez Gamboa","48123453C","652972588" ,"Mañana" , pediatra);
        this.personal.save(personal1);
        Personal personal2 = new Personal("Marta","Domingo Vazquez","73467014T","656462579" ,"Tarde" , pediatra);
        this.personal.save(personal2);
        Personal personal3 = new Personal("Omar","Montes Jardin","86729467B","609874674" ,"Mañana" , enfermero);
        this.personal.save(personal3);
        Personal personal4 = new Personal("Manoli","Page Webber","14805678Z","686527480" ,"Tarde" , enfermero);
        this.personal.save(personal4);
        Personal personal5 = new Personal("Monica","Soria Riada","35625890P","612850429" ,"Mañana" , psiquiatra);
        this.personal.save(personal5);
        Personal personal6 = new Personal("Alvaro","Garcia Nahuel","23153682W","6531794580" ,"Tarde" , psiquiatra);
        this.personal.save(personal6);
        Personal personal7 = new Personal("Cristofer","Alonso Mingueza","68426076S","653492694" ,"Mañana" , neurologo);
        this.personal.save(personal7);
        Personal personal8 = new Personal("Alfredo","Duro Roncero","13258942R","667835571" ,"Tarde" , neurologo);
        this.personal.save(personal8);
        Personal personal9 = new Personal("Paula","Ruiz Martinez","63578293M","6903378810" ,"Mañana" , cardiologo);
        this.personal.save(personal9);
        Personal personal10 = new Personal("Lara","Torres Navas","26745690L","678015370" ,"Tarde" , cardiologo);
        this.personal.save(personal10);
        Personal personal11 = new Personal("Pablo","Cabeza Dominguez","76280461G","646802512" ,"Mañana" , cirujano);
        this.personal.save(personal11);
        Personal personal12 = new Personal("Maria","Garcia Lopez","73561067U","647825681" ,"Tarde" , cirujano);
        this.personal.save(personal12);
    }
}

