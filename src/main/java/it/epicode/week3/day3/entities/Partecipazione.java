package it.epicode.week3.day3.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "partecipazioni")
public class Partecipazione {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @ManyToOne
    @JoinColumn(name = "persona_fk")
    private Persona persona;
    @ManyToOne
    @JoinColumn(name = "evento_fk")
    private Evento evento;
    @Column (name = "stato_partecipazione")
    @Enumerated(EnumType.STRING)
    private Stato statoPartecipazione;



    public Partecipazione(){}
    public Partecipazione(int id, Persona persona, Evento evento, Stato statoPartecipazione) {
        this.id = id;
        this.persona = persona;
        this.evento = evento;
        this.statoPartecipazione = statoPartecipazione;
    }

    @Override
    public String toString() {
        return "Partecipazione{" +
                "id=" + id +
                ", persona=" + persona +
                ", evento=" + evento +
                ", statoPartecipazione=" + statoPartecipazione +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    public Stato getStatoPartecipazione() {
        return statoPartecipazione;
    }

    public void setStatoPartecipazione(Stato statoPartecipazione) {
        this.statoPartecipazione = statoPartecipazione;
    }
}
