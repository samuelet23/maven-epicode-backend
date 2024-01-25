package it.epicode.week3.day34.dao;

import it.epicode.week3.day34.entities.Persona;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class PersonaDAO {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestioneeventi");
    EntityManager em = emf.createEntityManager();
    EntityTransaction et = em.getTransaction();


    public void save(Persona p){
        try{
            et.begin();
            em.persist(p);
            et.commit();
        }catch (Exception ex){
            ex.getMessage();
            em.close();
        }
    }
    public Persona getById(int id ){
        Persona p = em.find(Persona.class, id);
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
            Persona p = getById(id);
            em.remove(p);
            et.commit();
        }catch (Exception ex){
            ex.getMessage();
            em.close();
        }
    }
}
