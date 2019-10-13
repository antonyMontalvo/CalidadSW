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
    public abstract int createBasic(Event event);

    /**
     * 
     * @param event
     * @return
     */
    public abstract boolean createSecond(Event event);

    /**
     * 
     * @param event
     * @return
     */
    public abstract boolean finalCreate(Event event);

    /**
     * 
     * @param idEvent
     * @return
     */
    public abstract boolean delete(Integer idEvent);

    /**
     * 
     * @param idEvent
     * @return
     */
    public abstract Event readEvent(Integer idEvent);

    /**
     * 
     * @return
     */
    public abstract List<Event> read();

    /**
     * 
     * @param start_date
     * @param end_date
     * @return
     */
    public abstract List<Event> search(String startDate, String endDate);

    /**
     * 
     * @param idEvent
     * @return
     */
    public abstract boolean publish(Integer idEvent);

    /**
     * 
     * @param idEvent
     * @return
     */
    public abstract List<Event> filterSchedule(Event event);
}
