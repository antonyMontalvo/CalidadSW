package unmsm.edu.pe.calidadsw.dao.model;

import java.util.Date;

/**
 *
 * @author antony
 */
public class Client extends User {
    private int idClient;
    private String telephone;
    private String mail;
    private String username;
    private String password;

    public Client() {
    }

    // Insert client
    public Client(String dni, String name, String lastname, Date birthdate) {
        super(dni, name, lastname, birthdate);
    }

    // With id client
    public Client(String dni, String name, String lastname, Date birthdate, int idClient) {
        super(dni, name, lastname, birthdate);
        this.idClient = idClient;
    }

    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
