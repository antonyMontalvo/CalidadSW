package unmsm.edu.pe.calidadsw.dao.model;

/**
 *
 * @author antony
 */
public class Event_has_exhibitor {
    private int _idEvent;
    private int _dni;

    public Event_has_exhibitor() {
    }

    public Event_has_exhibitor(int idEvent, int dni) {
        this._idEvent = idEvent;
        this._dni = dni;
    }

    public int getIdEvent() {
        return _idEvent;
    }

    public void setIdEvent(int idEvent) {
        this._idEvent = idEvent;
    }

    public int getDni() {
        return _dni;
    }

    public void setDni(int dni) {
        this._dni = dni;
    }

}
