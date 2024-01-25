package it.epicode.week3.day34;

import it.epicode.week3.day34.dao.EventoDAO;
import it.epicode.week3.day34.dao.LocationDAO;
import it.epicode.week3.day34.dao.PartecipazioneDAO;
import it.epicode.week3.day34.dao.PersonaDAO;
import it.epicode.week3.day34.entities.*;
import it.epicode.week3.day34.entities.sottoClassiEvento.GaraDiAtletica;
import it.epicode.week3.day34.entities.type.EventType;
import it.epicode.week3.day34.entities.type.Sesso;
import it.epicode.week3.day34.entities.type.Stato;

import java.time.LocalDate;
import java.util.Set;

public class usaEvento {

    public static void main(String[] args) {
        EventoDAO daoEvento = new EventoDAO();
        PersonaDAO personaDAO = new PersonaDAO();
        LocationDAO locationDAO = new LocationDAO();
        PartecipazioneDAO partecipazioneDAO = new PartecipazioneDAO();

        Persona persona1 = new Persona();
        persona1.setNome("Francesco");
        persona1.setCognome("totti");
        persona1.setEmail("francesco@gmail.com");
        persona1.setSesso(Sesso.M);
        persona1.setDataDiNascita(LocalDate.of(2000, 1, 11));
        personaDAO.save(persona1);


        Location locationEvento1 = new Location();
        locationEvento1.setNome("Villa Mirador");
        locationEvento1.setCitta("Catania");
        locationDAO.save(locationEvento1);

        Evento evento1 = new Evento();
        evento1.setDataEvento(LocalDate.of(2024, 5, 10));
        evento1.setTipoEvento(EventType.PUBBLICO);
        evento1.setDescrizione("Evento di beneficienza");
        evento1.setTitolo("Balla sotto le stelle");
        evento1.setNumeroMassimoPartecipanti(1000);
        evento1.setLocation(locationEvento1);
        daoEvento.save(evento1);

        Partecipazione partecipazione = new Partecipazione();
        partecipazione.setStatoPartecipazione(Stato.CONFERMATA);
        partecipazione.setEvento(evento1);
        partecipazione.setPersona(persona1);
        partecipazioneDAO.save(partecipazione);


        GaraDiAtletica gara = new GaraDiAtletica();
//        Persona persona2 = new Persona();
//        persona2.setNome("Francesco");
//        persona2.setCognome("totti");







    }



}
