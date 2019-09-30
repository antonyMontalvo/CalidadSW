package unmsm.edu.pe.calidadsw.dao.design;

import java.util.List;

import unmsm.edu.pe.calidadsw.dao.model.Ambient;

/**
 *
 * @author Usuario
 */
public interface IAmbientDAO {

    /**
     * 
     * @param ambient
     * @return
     */
    public abstract boolean create(Ambient ambient);

    /**
     * 
     * @param id
     * @return
     */
    public abstract boolean delete(Integer id);

    /**
     * 
     * @return
     */
    public abstract List<Ambient> read();
}
