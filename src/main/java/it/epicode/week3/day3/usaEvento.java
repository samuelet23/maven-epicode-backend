package it.epicode.week3.day3;

import it.epicode.week3.day3.dao.EventoDAO;
import it.epicode.week3.day3.dao.LocationDAO;
import it.epicode.week3.day3.dao.PartecipazioneDAO;
import it.epicode.week3.day3.dao.PersonaDAO;
import it.epicode.week3.day3.entities.*;

import java.time.LocalDate;
import java.util.List;

public class usaEvento {

    public static void main(String[] args) {
        EventoDAO daoEvento = new EventoDAO();
        PersonaDAO personaDAO = new PersonaDAO();
        LocationDAO locationDAO = new LocationDAO();
        PartecipazioneDAO partecipazioneDAO = new PartecipazioneDAO();

        Persona persona1 = new Persona();
        persona1.setNome("Francesco");
        Evento evento1 = new Evento();
        evento1.setDescrizione("Evento di beneficienza");
        Location location = new Location();
        location.setNome("Villa Mirador");
        Partecipazione partecipazione = new Partecipazione();

        evento1.setLocation(location);

        Persona p = personaDAO.getById(1);

        partecipazione.setEvento(evento1);
        partecipazione.setPersona(p);
        partecipazione.setStatoPartecipazione(Stato.CONFERMATA);

        persona1.setPartecipazioni(List.of(partecipazione));

        personaDAO.save(persona1);


    }



}
