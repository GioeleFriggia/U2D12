package gioelefriggia;

import gioelefriggia.dao.EventoDAO;
import gioelefriggia.dao.LocationDAO;
import gioelefriggia.dao.PartecipazioneDAO;
import gioelefriggia.dao.PersonaDAO;
import gioelefriggia.model.*;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.Date;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("GestioneEventiPU");
        EntityManager em = emf.createEntityManager();

        // Creazione dei DAO
        EventoDAO eventoDao = new EventoDAO(em);
        PersonaDAO personaDao = new PersonaDAO(em);
        LocationDAO locationDao = new LocationDAO(em);
        PartecipazioneDAO partecipazioneDao = new PartecipazioneDAO(em);

        // Creazione e salvataggio di una persona
        Persona persona1 = new Persona("John", "Doe", "john@example.com", new Date(), Sesso.M);
        Persona persona2 = new Persona("Jane", "Doe", "jane@example.com", new Date(), Sesso.F);
        Persona persona3 = new Persona("Alice", "Smith", "alice@example.com", new Date(), Sesso.F);
        personaDao.save(persona1);
        personaDao.save(persona2);
        personaDao.save(persona3);

        // Creazione e salvataggio delle location
        Location location1 = new Location("Stadium", "City 1");
        Location location2 = new Location("Arena", "City 2");
        Location location3 = new Location("Theater", "City 3");
        locationDao.save(location1);
        locationDao.save(location2);
        locationDao.save(location3);

        // Creazione e salvataggio degli eventi (concerti)
        Evento concertoRock = new Evento("Concerto Rock", new Date(), "Concerto di musica Rock", TipoEvento.CONCERTO, 1000, location1);
        Evento concertoBlues = new Evento("Concerto Blues", new Date(), "Concerto di musica Blues", TipoEvento.CONCERTO, 800, location2);
        Evento concertoClassic = new Evento("Concerto Classico", new Date(), "Concerto di musica Classica", TipoEvento.CONCERTO, 1200, location3);
        Evento concertoPunk = new Evento("Concerto Punk", new Date(), "Concerto di musica Punk", TipoEvento.CONCERTO, 700, location1);
        Evento concertoJazz = new Evento("Concerto Jazz", new Date(), "Concerto di musica Jazz", TipoEvento.CONCERTO, 900, location2);

        eventoDao.save(concertoRock);
        eventoDao.save(concertoBlues);
        eventoDao.save(concertoClassic);
        eventoDao.save(concertoPunk);
        eventoDao.save(concertoJazz);

        // Aggiungi partecipanti agli eventi
        Partecipazione partecipazione1 = new Partecipazione(persona1, concertoRock, StatoPartecipazione.CONFERMATA);
        Partecipazione partecipazione2 = new Partecipazione(persona2, concertoRock, StatoPartecipazione.CONFERMATA);
        Partecipazione partecipazione3 = new Partecipazione(persona3, concertoBlues, StatoPartecipazione.CONFERMATA);
        Partecipazione partecipazione4 = new Partecipazione(persona1, concertoClassic, StatoPartecipazione.CONFERMATA);
        Partecipazione partecipazione5 = new Partecipazione(persona2, concertoPunk, StatoPartecipazione.CONFERMATA);

        partecipazioneDao.save(partecipazione1);
        partecipazioneDao.save(partecipazione2);
        partecipazioneDao.save(partecipazione3);
        partecipazioneDao.save(partecipazione4);
        partecipazioneDao.save(partecipazione5);

        em.close();
        emf.close();
    }
}
