package unmsm.edu.pe.calidadsw.dao.model;

import java.util.Date;

/**
 *
 * @author antony
 */
public class Administrator extends User {
    private int idAdministrator;
    private String username;
    private String password;

    public Administrator() {
    }

    public Administrator(String dni, String name, String lastname, Date birthdate, String username, String password) {
        super(dni, name, lastname, birthdate);
        this.username = username;
        this.password = password;
    }

    public Administrator(String dni, String name, String lastname, Date birthdate, int idAdministrator, String username,
            String password) {
        super(dni, name, lastname, birthdate);
        this.idAdministrator = idAdministrator;
        this.username = username;
        this.password = password;
    }

    public int getIdAdministrator() {
        return idAdministrator;
    }

    public void setIdAdministrator(int idAdministrator) {
        this.idAdministrator = idAdministrator;
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
