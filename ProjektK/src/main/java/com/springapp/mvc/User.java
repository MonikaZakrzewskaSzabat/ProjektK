package com.springapp.mvc;

import javax.persistence.*;

@Entity(name = "account")
public class User {
    @Id
    private Long id;

    @Basic
    private String imie;

    @Basic
    private String nazwisko;

    @Basic
    private String email;

    @Basic
    private String parafia;

    @Basic
    private int wiek;

    @Basic
    private String haslo;

    public User() {
    }

    public User(String imie, String nazwisko, String email, String parafia, int wiek, String haslo) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.email = email;
        this.parafia= parafia;
        this.wiek= wiek;
        this.haslo= haslo;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getParafia() {
        return parafia;
    }

    public void setParafia(String parafia) {
        this.parafia = parafia;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getWiek() {
        return wiek;
    }

    public void setWiek(int wiek) {
        this.wiek = wiek;
    }

    public String getHaslo() {
        return haslo;
    }

    public void setHaslo(String haslo) {
        this.haslo = haslo;
    }
}
