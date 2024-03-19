package gioelefriggia;

import gioelefriggia.model.Evento;
import gioelefriggia.model.TipoEvento;
import gioelefriggia.dao.EventoDAO;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.Date;

public class Application {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("GestioneEventiPU");
        EntityManager em = emf.createEntityManager();
        EventoDAO eventoDao = new EventoDAO(em);

        // Esempio di creazione e salvataggio di un evento
        Evento concertoRock = new Evento("Concerto Rock", new Date(), "Evento di musica rock all'aperto", TipoEvento.PUBBLICO, 500);
        eventoDao.save(concertoRock);

        Evento concertoBlues = new Evento("Concerto Blues", new Date(), "Evento di musica blues al teatro", TipoEvento.PUBBLICO, 1500);
        eventoDao.save(concertoBlues);

        Evento concertoJazz = new Evento("Concerto Jazz", new Date(), "Evento di musica jazz al centro culturale", TipoEvento.PUBBLICO, 800);
        eventoDao.save(concertoJazz);

        // Esempio di recupero di un evento tramite ID
        Evento eventoRecuperato = eventoDao.getById(concertoRock.getId());
        System.out.println(eventoRecuperato);

        // Esempio di eliminazione di un evento
        eventoDao.delete(concertoBlues.getId());

        em.close();
        emf.close();
    }
}

