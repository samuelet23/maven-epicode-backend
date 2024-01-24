package it.epicode.week3.day3.dao;

import it.epicode.week3.day3.entities.Location;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class LocationDAO {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestioneeventi");
    EntityManager em = emf.createEntityManager();
    EntityTransaction et = em.getTransaction();


    public void save(Location l ){
        try{
            et.begin();
            em.persist(l);
            et.commit();
        }catch (Exception ex){
            ex.getMessage();
            em.close();
        }
    }
    public Location getById(int id ){
        Location l = em.find(Location.class, id);
        try {
            em.refresh(l);
        }catch (Exception ex){
            ex.getMessage();
            em.close();
        }
        return l;
    }

    public void delete(int id){
        try{
            et.begin();
            Location l = getById(id);
            em.remove(l);
            et.commit();
        }catch (Exception ex){
            ex.getMessage();
            em.close();
        }
    }
}
