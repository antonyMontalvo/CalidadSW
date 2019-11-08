package unmsm.edu.pe.calidadsw.dao.design;

import unmsm.edu.pe.calidadsw.dao.model.Administrator;

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

}
