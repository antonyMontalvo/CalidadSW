package unmsm.edu.pe.calidadsw.dao.design;

import java.util.List;

import unmsm.edu.pe.calidadsw.dao.model.Event;
import unmsm.edu.pe.calidadsw.dao.model.Exhibitor;
import unmsm.edu.pe.calidadsw.dao.model.Presentation;

/**
 *
 * @author Usuario
 */
public interface IPresentationDAO {
    /**
     * Event_has_exhibitor
     */

    /**
     * 
     * @param event
     * @return
     */
    public abstract List<Exhibitor> readExhibitorsEvent(Event event);

    /**
     * 
     * @param presentation
     * @return
     */
    public abstract boolean registerPresentation(Presentation presentation);

}
