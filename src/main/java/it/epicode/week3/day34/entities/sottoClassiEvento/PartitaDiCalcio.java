package it.epicode.week3.day34.entities.sottoClassiEvento;

import it.epicode.week3.day34.entities.Evento;
import it.epicode.week3.day34.entities.Location;
import it.epicode.week3.day34.entities.Partecipazione;
import it.epicode.week3.day34.entities.type.EventType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "partita_di_calcio")
public class PartitaDiCalcio extends Evento {

    @Column(name = "squadra_casa")
    private String squadraCasa;

    @Column(name = "squadra_ospite")
    private String squadraOspite;

    @Column(name = "squadra_vincente")
    private String squadraVincente;

    @Column(name = "numero_gol_casa")
    private int numeroGolCasa;

    @Column(name = "numero_gol_ospite")
    private int numeroGolOspite;



    public PartitaDiCalcio(){}

    public PartitaDiCalcio(String squadraCasa, String squadraOspite, String squadraVincente, int numeroGolCasa, int numeroGolOspite) {
        this.squadraCasa = squadraCasa;
        this.squadraOspite = squadraOspite;
        this.squadraVincente = whoWin(numeroGolCasa, numeroGolOspite);
        this.numeroGolCasa = numeroGolCasa;
        this.numeroGolOspite = numeroGolOspite;
    }

    public PartitaDiCalcio(int id, String titolo, LocalDate dataEvento, String descrizione, EventType tipoEvento, int numeroMassimoPartecipanti, List<Partecipazione> partecipazioni, Location location, String squadraCasa, String squadraOspite, String squadraVincente, int numeroGolCasa, int numeroGolOspite) {
        super(id, titolo, dataEvento, descrizione, tipoEvento, numeroMassimoPartecipanti, partecipazioni, location);
        this.squadraCasa = squadraCasa;
        this.squadraOspite = squadraOspite;
        this.squadraVincente = whoWin(numeroGolCasa, numeroGolOspite);
        this.numeroGolCasa = numeroGolCasa;
        this.numeroGolOspite = numeroGolOspite;
    }



    private String whoWin(int golCasa, int golOspite){
        if (golCasa > golOspite) {
            return this.squadraCasa;
        } else if (golOspite > golCasa) {
            return this.squadraOspite;
        }
        return null;
    }

    @Override
    public String toString() {
        return "PartitaDiCalcio{" +
                "squadraCasa='" + squadraCasa + '\'' +
                ", squadraOspite='" + squadraOspite + '\'' +
                ", numeroGolCasa=" + numeroGolCasa +
                ", numeroGolOspite=" + numeroGolOspite +
                ", squadraVincente= "+ squadraVincente +
                ", dataEvento=" + dataEvento +
                '}';
    }

    public String getSquadraCasa() {
        return squadraCasa;
    }

    public void setSquadraCasa(String squadraCasa) {
        this.squadraCasa = squadraCasa;
    }

    public String getSquadraOspite() {
        return squadraOspite;
    }

    public void setSquadraOspite(String squadraOspite) {
        this.squadraOspite = squadraOspite;
    }

    public String getSquadraVincente() {
        return squadraVincente;
    }

    public void setSquadraVincente(String squadraVincente) {
        this.squadraVincente = squadraVincente;
    }

    public int getNumeroGolCasa() {
        return numeroGolCasa;
    }

    public void setNumeroGolCasa(int numeroGolCasa) {
        this.numeroGolCasa = numeroGolCasa;
    }

    public int getNumeroGolOspite() {
        return numeroGolOspite;
    }

    public void setNumeroGolOspite(int numeroGolOspite) {
        this.numeroGolOspite = numeroGolOspite;
    }
}
