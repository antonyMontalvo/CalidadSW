package unmsm.edu.pe.calidadsw.dao.model;

/**
 * User
 */
public class User {
    private int idUser;
    private String dni;
    private String name;
    private String lastname;
    private String birthdate;

    public User() {
    }

    /**
     * 
     * @return
     */
    public int getIdUser() {
        return idUser;
    }

    /**
     * 
     * @param idUser
     */
    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    /**
     * 
     * @return
     */
    public String getDni() {
        return dni;
    }

    /**
     * 
     * @param dni
     */
    public void setDni(String dni) {
        this.dni = dni;
    }

    /**
     * 
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * 
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 
     * @return
     */
    public String getLastname() {
        return lastname;
    }

    /**
     * 
     * @param lastname
     */
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    /**
     * 
     * @return
     */
    public String getBirthdate() {
        return birthdate;
    }

    /**
     * 
     * @param birthdate
     */
    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

}