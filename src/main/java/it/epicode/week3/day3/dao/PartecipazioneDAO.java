package it.epicode.week3.day3.dao;

import it.epicode.week3.day3.entities.Partecipazione;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

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
}
