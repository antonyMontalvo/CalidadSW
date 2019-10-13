package unmsm.edu.pe.calidadsw.dao.model;

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
    
    /**
     * 
     * @return
     */
    public int getIdClient() {
        return idClient;
    }

    /**
     * 
     * @param idClient
     */
    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    /**
     * 
     * @return
     */
    public String getTelephone() {
        return telephone;
    }

    /**
     * 
     * @param telephone
     */
    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    /**
     * 
     * @return
     */
    public String getMail() {
        return mail;
    }

    /**
     * 
     * @param mail
     */
    public void setMail(String mail) {
        this.mail = mail;
    }

    /**
     * 
     * @return
     */
    public String getUsername() {
        return username;
    }

    /**
     * 
     * @param username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * 
     * @return
     */
    public String getPassword() {
        return password;
    }

    /**
     * 
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

}
