package unmsm.edu.pe.calidadsw.dao.design;

import java.util.List;
import java.util.Map;

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
     * @param idEvent
     * @return
     */
    public abstract List<Presentation> readExhibitorsEvent(Integer idEvent);

    /**
     * 
     * @param presentation
     * @return
     */
    public abstract boolean registerPresentation(Presentation presentation);

    /**
     * 
     * @param presentations
     * @return
     */
    public Map<Integer, List<Presentation>> getAlgoritmo(List<Presentation> presentations);

}
