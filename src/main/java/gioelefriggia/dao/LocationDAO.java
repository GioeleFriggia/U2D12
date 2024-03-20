package gioelefriggia.dao;

import gioelefriggia.model.Location;
import jakarta.persistence.EntityManager;

public class LocationDAO {
    private EntityManager em;

    public LocationDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Location location) {
        em.getTransaction().begin();
        em.persist(location);
        em.getTransaction().commit();
    }

    // Altri metodi per la gestione delle location
}
