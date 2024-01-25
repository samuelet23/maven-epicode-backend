package it.epicode.week3.day34.entities.sottoClassiEvento;

import it.epicode.week3.day34.entities.Evento;
import it.epicode.week3.day34.entities.Location;
import it.epicode.week3.day34.entities.Partecipazione;
import it.epicode.week3.day34.entities.type.EventType;
import it.epicode.week3.day34.entities.type.Genere;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "evento")
public class Concerto extends Evento {

    @Enumerated(EnumType.STRING)
    private Genere genere;
    @Column(name = "in_streaming")
    private boolean inStreaming;

    public Concerto(){}

    public Concerto(Genere genere, boolean inStreaming) {
        this.genere = genere;
        this.inStreaming = inStreaming;
    }

    public Concerto(int id, String titolo, LocalDate dataEvento, String descrizione, EventType tipoEvento, int numeroMassimoPartecipanti, List<Partecipazione> partecipazioni, Location location, Genere genere, boolean inStreaming) {
        super(id, titolo, dataEvento, descrizione, tipoEvento, numeroMassimoPartecipanti, partecipazioni, location);
        this.genere = genere;
        this.inStreaming = inStreaming;
    }

    @Override
    public String toString() {
        return "Concerto{" +
                "genere=" + genere +
                ", inStreaming=" + inStreaming +
                ", dataEvento=" + dataEvento +
                '}';
    }

    public Genere getGenere() {
        return genere;
    }

    public void setGenere(Genere genere) {
        this.genere = genere;
    }

    public boolean isInStreaming() {
        return inStreaming;
    }

    public void setInStreaming(boolean inStreaming) {
        this.inStreaming = inStreaming;
    }
}
