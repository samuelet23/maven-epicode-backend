package it.epicode.week3.day34.dao;

import it.epicode.week3.day34.entities.Evento;
import it.epicode.week3.day34.entities.Partecipazione;
import jakarta.persistence.*;

import java.util.List;
@NamedQuery(name = "partecipazioniDaConfermare", query = "select p from Partecipazione where p.evento = :evento and p.statoPartecipazione = DA_CONFERMARE")
public class PartecipazioneDAO {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestioneeventi");
    EntityManager em = emf.createEntityManager();
    EntityTransaction et = em.getTransaction();


    public void save(Partecipazione p ){
        try{
            et.begin();
            em.persist(p);
            et.commit();
        }catch (Exception ex){
            ex.getMessage();
            em.close();
        }
    }
    public Partecipazione getById(int id ){
        Partecipazione p = em.find(Partecipazione.class, id);
        try {
            em.refresh(p);
        }catch (Exception ex){
            ex.getMessage();
            em.close();
        }
        return p;
    }

    public void delete(int id){
        try{
            et.begin();
            Partecipazione p = getById(id);
            em.remove(p);
            et.commit();
        }catch (Exception ex){
            ex.getMessage();
            em.close();
        }
    }

    public List<Partecipazione> getPartecipazioneDaCondermare(Evento e){
        Query query = em.createNamedQuery("partecipazioniDaConfermare");
        query.setParameter("evento", e);

        return (List<Partecipazione>) query.getResultList();
    }
}
