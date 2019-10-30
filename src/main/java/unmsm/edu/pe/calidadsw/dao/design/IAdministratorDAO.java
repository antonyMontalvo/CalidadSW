package unmsm.edu.pe.calidadsw.dao.design;

import unmsm.edu.pe.calidadsw.dao.model.Administrator;
import unmsm.edu.pe.calidadsw.dao.model.Client;

/**
 * Usuario
 */
public interface IAdministratorDAO {

    /**
     * 
     * @param user
     * @return
     */
    public abstract Administrator readLogin(String user);

    /**
     * 
     * @param client
     * @return
     */
    public abstract Boolean registerUser(Client client);

}
