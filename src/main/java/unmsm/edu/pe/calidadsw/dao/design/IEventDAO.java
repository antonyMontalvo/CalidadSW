package unmsm.edu.pe.calidadsw.dao.design;

import java.util.List;

import unmsm.edu.pe.calidadsw.dao.model.Event;

/**
 *
 * @author Usuario
 */
public interface IEventDAO {

    public abstract boolean create(Event event);

    public abstract boolean delete(Integer id);

    public abstract List<Event> read();
}
