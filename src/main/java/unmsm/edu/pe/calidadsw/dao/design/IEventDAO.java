package unmsm.edu.pe.calidadsw.dao.design;

import java.util.List;

import unmsm.edu.pe.calidadsw.dao.model.Event;

/**
 *
 * @author Usuario
 */
public interface IEventDAO {

    /**
     * 
     * @param event
     * @return
     */
    public abstract boolean create(Event event);

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
    public abstract List<Event> read();
    
    public abstract List<Event> search(String start_date, String end_date);
}
