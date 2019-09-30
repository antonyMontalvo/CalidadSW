package unmsm.edu.pe.calidadsw.dao.design;

import java.util.List;

import unmsm.edu.pe.calidadsw.dao.model.Ambient;

/**
 *
 * @author Usuario
 */
public interface IAmbientDAO {

    public abstract boolean create(Ambient ambient);

    public abstract boolean delete(Integer id);

    public abstract List<Ambient> read();
}
