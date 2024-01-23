package it.epicode.week3.day2;

import javax.persistence.Persistence;
import javax.swing.event.HyperlinkEvent;
import java.time.LocalDate;

public class usaEvento {

    public static void main(String[] args) {
    EventoDAO dao = new EventoDAO();
    Evento evento1 = new Evento();
    Evento evento2 = new Evento();
    Evento evento3 = new Evento();
    Evento evento4 = new Evento();
    Evento evento5 = new Evento();
    setNewEvento(evento1, "Evento1", LocalDate.of(2022, 10,10), EventType.PUBBLICO, 300,"porta chi vuoi");
    setNewEvento(evento2, "Evento2", LocalDate.of(2023, 10,10), EventType.PUBBLICO, 300,"porta chi vuoi");
    setNewEvento(evento3, "Evento3", LocalDate.of(2024, 10,10), EventType.PRIVATO, 50,"Solo i più stretti");
    setNewEvento(evento4, "Evento4", LocalDate.of(2025, 10,10), EventType.PUBBLICO, 300,"porta chi vuoi");
    setNewEvento(evento5, "Evento5", LocalDate.of(2026, 10,10), EventType.PRIVATO, 50,"Solo i più stretti");


  dao.save(evento1);
  dao.save(evento2);
  dao.save(evento3);
  dao.save(evento4);
  dao.save(evento5);


    }


    public static void setNewEvento(Evento evento, String titolo, LocalDate dataEvento, EventType tipoEvento, int maxPartecipanti, String descrizione){
        evento.setTitolo(titolo);
        evento.setDataEvento(dataEvento);
        evento.setTipoEvento(tipoEvento);
        evento.setNumeroMassimoPartecipanti(maxPartecipanti);
        evento.setDescrizione(descrizione);

    }

}
