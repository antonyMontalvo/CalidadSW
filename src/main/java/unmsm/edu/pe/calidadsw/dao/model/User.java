package unmsm.edu.pe.calidadsw.dao.model;

import java.util.Date;

/**
 * User
 */
public class User {
    private int idUser;
    private String dni;
    private String name;
    private String lastname;
    private Date birthdate;

    public User() {
    }

    public User(String dni, String name, String lastname, Date birthdate) {
        this.dni = dni;
        this.name = name;
        this.lastname = lastname;
        this.birthdate = birthdate;
    }

    public User(int idUser, String dni, String name, String lastname, Date birthdate) {
        this.idUser = idUser;
        this.dni = dni;
        this.name = name;
        this.lastname = lastname;
        this.birthdate = birthdate;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

}