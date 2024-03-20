package gioelefriggia.dao;

import gioelefriggia.model.Partecipazione;
import jakarta.persistence.EntityManager;

public class PartecipazioneDAO {
    private EntityManager em;

    public PartecipazioneDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Partecipazione partecipazione) {
        em.getTransaction().begin();
        em.persist(partecipazione);
        em.getTransaction().commit();
    }

    // Altri metodi per la gestione delle partecipazioni
}
