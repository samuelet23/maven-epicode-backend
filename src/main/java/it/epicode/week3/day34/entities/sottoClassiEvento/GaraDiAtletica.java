package it.epicode.week3.day34.entities.sottoClassiEvento;

import it.epicode.week3.day34.entities.Evento;
import it.epicode.week3.day34.entities.Location;
import it.epicode.week3.day34.entities.Partecipazione;
import it.epicode.week3.day34.entities.Persona;
import it.epicode.week3.day34.entities.type.EventType;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "gara_di_atletica")
public class GaraDiAtletica extends Evento {

    @Column(name = "set_atleti")
    @OneToMany(mappedBy = "atleta")
    private Set<Persona> setAtleti;

    @OneToOne
    @JoinColumn(name = "vincitore_fk")
    private Persona vincitore;

    public GaraDiAtletica(){}
    public GaraDiAtletica(Set<Persona> setAtleti, Persona vincitore) {
        this.setAtleti = setAtleti;
        this.vincitore = vincitore;
    }

    public GaraDiAtletica(int id, String titolo, LocalDate dataEvento, String descrizione, EventType tipoEvento, int numeroMassimoPartecipanti, List<Partecipazione> partecipazioni, Location location, Set<Persona> setAtleti, Persona vincitore) {
        super(id, titolo, dataEvento, descrizione, tipoEvento, numeroMassimoPartecipanti, partecipazioni, location);
        this.setAtleti = setAtleti;
        this.vincitore = vincitore;
    }

    @Override
    public String toString() {
        return "GaraDiAtletica{" +
                "setAtleti=" + setAtleti +
                ", vincitore=" + vincitore +
                ", dataEvento=" + dataEvento +
                '}';
    }

    public Set<Persona> getSetAtleti() {
        return setAtleti;
    }

    public void setSetAtleti(Set<Persona> setAtleti) {
        this.setAtleti = setAtleti;
    }

    public Persona getVincitore() {
        return vincitore;
    }

    public void setVincitore(Persona vincitore) {
        this.vincitore = vincitore;
    }
}
