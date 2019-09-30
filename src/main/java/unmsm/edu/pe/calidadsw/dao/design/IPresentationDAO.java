package unmsm.edu.pe.calidadsw.dao.design;

import java.util.List;

import unmsm.edu.pe.calidadsw.dao.model.Exhibitor;
import unmsm.edu.pe.calidadsw.dao.model.Presentation;

/**
 *
 * @author Usuario
 */
public interface IPresentationDAO { // Event_has_exhibitorDAO

    public abstract List<Exhibitor> consultaTodosExpositoresEvento(Integer id);

    public abstract boolean inscribirExpositorEvento(Presentation presentation);

}
