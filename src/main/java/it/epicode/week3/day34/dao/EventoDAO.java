package it.epicode.week3.day34.dao;

import it.epicode.week3.day34.entities.Evento;
import it.epicode.week3.day34.entities.Persona;
import it.epicode.week3.day34.entities.sottoClassiEvento.Concerto;
import it.epicode.week3.day34.entities.sottoClassiEvento.GaraDiAtletica;
import it.epicode.week3.day34.entities.sottoClassiEvento.PartitaDiCalcio;
import it.epicode.week3.day34.entities.type.Genere;
import jakarta.persistence.*;

import java.util.List;
import java.util.Queue;

@NamedQuery(name = "partiteVinteCasa", query = "select p from PartitaDiCalcio p where :numeroGolCasa > :numeroGolOspite ")
@NamedQuery(name = "partiteVinteOspite", query = "select p from PartitaDiCalcio p where :numeroGolOspite > :numeroGolCasa")
@NamedQuery(name = "partitePareggiate", query = "select p from PartitaDiCalcio p where :numeroGolOspite = :numeroGolCasa")
@NamedQuery(name = "garePerVincitore", query = "select g from GaraDiAtletica g where g.vincitore = :vincitore")
@NamedQuery(name = "garePerPartecipante", query = "select g from GaraDiAtletica g where :atleta member of setAtleti")
@NamedQuery(name = "eventiSoldOut", query = "select e from Evento e where size(e.partecipazioni) = :numeroMassimoPartecipanti")
public class EventoDAO {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestioneeventi");
    EntityManager em = emf.createEntityManager();
    EntityTransaction et = em.getTransaction();


    public void save(Evento e ){
        try{
        et.begin();
        em.persist(e);
        et.commit();
        }catch (Exception ex){
            ex.getMessage();
            em.close();
        }
    }
    public Evento getById(int id ){
        Evento e = em.find(Evento.class, id);
        try {
        em.refresh(e);
        }catch (Exception ex){
            ex.getMessage();
            em.close();
        }
        return e;
    }

    public void delete(int id){
        try{
        et.begin();
        Evento e = getById(id);
        em.remove(e);
        et.commit();
        }catch (Exception ex){
            ex.getMessage();
            em.close();
        }
    }

    public List<Concerto> getConcertiInStreaming(boolean b){
        try{
        Query concertiStreaming = em.createQuery("select c from Concerto c where c.inStreaming = :inStreaming");
         return (List<Concerto>) concertiStreaming.setParameter("inStreaming", b).getResultList();
        } finally {
            em.close();
        }
    }

    public List<Concerto> getConcertiGenere(Genere genere){
        try{
            Query concertiStreaming = em.createQuery("select c from Concerto c where c.genere = :genere");
            return (List<Concerto>) concertiStreaming.setParameter("genere", genere);

        } finally {
            em.close();
        }
    }
    public List<PartitaDiCalcio> getVinteCasa(PartitaDiCalcio p){
        Query query = em.createNamedQuery("partiteVinteCasa");
        query.setParameter("numeroGolCasa", p.getNumeroGolCasa());
        query.setParameter("numeroGolOspite", p.getNumeroGolOspite());

       return (List<PartitaDiCalcio>) query.getResultList();
    }
 public List<PartitaDiCalcio> getVinteOspiti(PartitaDiCalcio p){
        Query query = em.createNamedQuery("partiteVinteOspite");
        query.setParameter("numeroGolCasa", p.getNumeroGolCasa());
        query.setParameter("numeroGolOspite", p.getNumeroGolOspite());

       return (List<PartitaDiCalcio>) query.getResultList();
    }

public List<PartitaDiCalcio> getPartitePareggiate(PartitaDiCalcio p){
        Query query = em.createNamedQuery("partitePareggiate");
        query.setParameter("numeroGolCasa", p.getNumeroGolCasa());
        query.setParameter("numeroGolOspite", p.getNumeroGolOspite());

       return (List<PartitaDiCalcio>) query.getResultList();
    }

public List<GaraDiAtletica> getGarePerVincitore(GaraDiAtletica gara){

        Query query = em.createNamedQuery("garePerVincitore");
        query.setParameter("vincitore", gara.getVincitore());

        return (List<GaraDiAtletica>) query.getResultList();
}

public List<GaraDiAtletica> getGarePerPartecipante(Persona persona){

        Query query = em.createNamedQuery("garePerPartecipante");
        query.setParameter("atleta", persona.getAtleta());

        return (List<GaraDiAtletica>) query.getResultList();
}

public List<Evento> getEventiSoldOut(Evento e){
    Query query = em.createNamedQuery("eventiSoldOut");
    query.setParameter("numeroMassimoPartecipanti", e.getNumeroMassimoPartecipanti());
    return (List<Evento>) query.getResultList();
}

}

