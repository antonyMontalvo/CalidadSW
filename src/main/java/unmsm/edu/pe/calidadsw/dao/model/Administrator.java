package unmsm.edu.pe.calidadsw.dao.model;

/**
 *
 * @author antony
 */
public class Administrator extends User {
    private int idAdministrator;
    private String username;
    private String password;
    
    /**
     * 
     * @return
     */
    public int getIdAdministrator() {
        return idAdministrator;
    }

    /**
     * 
     * @param idAdministrator
     */
    public void setIdAdministrator(int idAdministrator) {
        this.idAdministrator = idAdministrator;
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
