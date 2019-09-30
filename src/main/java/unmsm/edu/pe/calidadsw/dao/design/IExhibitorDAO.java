package unmsm.edu.pe.calidadsw.dao.design;

import java.util.List;

import unmsm.edu.pe.calidadsw.dao.model.Exhibitor;

/**
 *
 * @author Usuario
 */
public interface IExhibitorDAO {

    public abstract boolean create(Exhibitor exhibitor);

    public abstract List<Exhibitor> read();
}
