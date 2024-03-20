package gioelefriggia.model;

import jakarta.persistence.*;

@Entity
@Table(name = "locations")
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String citta;

    public Location() {
        // Costruttore vuoto necessario per JPA
    }

    public Location(String nome, String citta) {
        this.nome = nome;
        this.citta = citta;
    }

    // Getter e Setter
    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCitta() {
        return citta;
    }

    public void setCitta(String citta) {
        this.citta = citta;
    }
}
