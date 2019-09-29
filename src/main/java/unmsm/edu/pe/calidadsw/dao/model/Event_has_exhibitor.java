package unmsm.edu.pe.calidadsw.dao.model;

/**
 *
 * @author antony
 */
public class Event_has_exhibitor {
    private int idEvent;
    private int dni;

    public Event_has_exhibitor() {
    }

    public Event_has_exhibitor(int idEvent, int dni) {
        this.idEvent = idEvent;
        this.dni = dni;
    }

    public int getIdEvent() {
        return idEvent;
    }

    public void setIdEvent(int idEvent) {
        this.idEvent = idEvent;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

}
