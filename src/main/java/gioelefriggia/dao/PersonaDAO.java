package gioelefriggia.dao;

import gioelefriggia.model.Persona;
import jakarta.persistence.EntityManager;
import java.util.List;

public class PersonaDAO {
    private EntityManager em;

    public PersonaDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Persona persona) {
        em.getTransaction().begin();
        em.persist(persona);
        em.getTransaction().commit();
    }

    public Persona getById(Long id) {
        return em.find(Persona.class, id);
    }

    public List<Persona> getAll() {
        return em.createQuery("SELECT p FROM Persona p", Persona.class).getResultList();
    }

    public void update(Persona persona) {
        em.getTransaction().begin();
        em.merge(persona);
        em.getTransaction().commit();
    }

    public void delete(Long id) {
        Persona persona = getById(id);
        if (persona != null) {
            em.getTransaction().begin();
            em.remove(persona);
            em.getTransaction().commit();
        }
    }

    // Altri metodi per la gestione delle persone...
}
