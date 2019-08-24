package de.devk.dojo.rockpaperscissors.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Client {

    @Id
    @GeneratedValue
    private long id;

    private String name;
    private long registrationCode;

    public Client() {
    }

    public Client(String name, long registrationCode) {
        this.name = name;
        this.registrationCode = registrationCode;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getRegistrationCode() {
        return registrationCode;
    }

    public void setRegistrationCode(long registrationCode) {
        this.registrationCode = registrationCode;
    }
}
