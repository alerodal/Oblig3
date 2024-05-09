package koder.oblig3;

import jakarta.persistence.*;

@Entity
@Table(name="Kino")
public class Kino {

    @Column(nullable = false, length = 150)
    private String film;

    @Column(nullable = false)
    private int antall;

    @Column(nullable = false, length = 255)
    private String fornavn;

    @Column(nullable = false, length = 255)
    private String etternavn;

    @Column(nullable = false, length = 25)
    private String telefonnr;

    @Column(nullable = false, length = 100)
    private String epost;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Kino(String film, int antall, String fornavn, String etternavn, String telefonnr, String epost){
        this.film=film;
        this.antall=antall;
        this.fornavn=fornavn;
        this.etternavn=etternavn;
        this.telefonnr=telefonnr;
        this.epost=epost;
    }
    public Kino(){
    }

    public String getFilm(){
        return film;
    }

    public void setFilm(String film) {
        this.film = film;
    }

    public int getAntall() {
        return antall;
    }

    public void setAntall(int antall) {
        this.antall = antall;
    }

    public String getFornavn() {
        return fornavn;
    }

    public void setFornavn(String fornavn) {
        this.fornavn = fornavn;
    }

    public String getEtternavn() {
        return etternavn;
    }

    public void setEtternavn(String etternavn) {
        this.etternavn = etternavn;
    }

    public String getTelefonnr() {
        return telefonnr;
    }

    public void setTelefonnr(String telefonnr) {
        this.telefonnr = telefonnr;
    }

    public String getEpost() {
        return epost;
    }

    public void setEpost(String epost) {
        this.epost = epost;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}

