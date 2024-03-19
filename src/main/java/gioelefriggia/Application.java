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
        Evento evento = new Evento("Concerto Blues", new Date(), "Evento di musica blues al teatro", TipoEvento.PUBBLICO, 1500);
        eventoDao.save(evento);


        // Esempio di recupero di un evento tramite ID
        Evento eventoRecuperato = eventoDao.getById(evento.getId());
        System.out.println(eventoRecuperato);

        // Esempio di eliminazione di un evento
        eventoDao.delete(evento.getId());

        em.close();
        emf.close();
    }
}

