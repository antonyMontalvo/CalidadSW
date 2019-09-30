package unmsm.edu.pe.calidadsw.dao.design;

import java.util.List;

import unmsm.edu.pe.calidadsw.dao.model.Exhibitor;

/**
 *
 * @author Usuario
 */
public interface IExhibitorDAO {

    /**
     * 
     * @param exhibitor
     * @return
     */
    public abstract boolean create(Exhibitor exhibitor);

    /**
     * 
     * @return
     */
    public abstract List<Exhibitor> read();
}
