package unmsm.edu.pe.calidadsw.dao.design;

import unmsm.edu.pe.calidadsw.dao.model.Client;

/**
 *
 * @author Usuario
 */
public interface IClientDAO {

    /**
     * 
     * @param client
     * @return
     */
    public abstract boolean create(Client client);
}
