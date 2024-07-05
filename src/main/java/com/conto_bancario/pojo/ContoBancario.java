package com.conto_bancario.pojo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class ContoBancario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int saldo;

    public ContoBancario() {

        setSaldo(0);
    }

    public int getSaldo() {

        return saldo;
    }

    private void setSaldo(int saldo) {

        this.saldo = saldo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public void deposita(int importo) throws IllegalArgumentException {

        if (importo <= 0)
            throw new IllegalArgumentException("L'importo deve essere maggiore di zero");

        setSaldo(getSaldo() + importo);
    }

    public void preleva(int importo) throws IllegalArgumentException {

        if (saldo - importo < 0)
            throw new IllegalArgumentException("Impossibile prelevare cifra maggiore di quella posseduta (ti piacerebbe)");

        setSaldo(getSaldo() - importo);
    }

    @Override
    public String toString() {

        return"id: " +getId() + ", Saldo: " + getSaldo();
    }

}
