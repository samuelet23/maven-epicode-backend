package it.epicode.week3.day2;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

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
        et.begin();
        em.refresh(e);
        et.commit();
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




}

