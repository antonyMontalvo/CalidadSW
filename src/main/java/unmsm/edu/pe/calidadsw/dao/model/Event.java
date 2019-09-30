package unmsm.edu.pe.calidadsw.dao.model;

import java.util.Date;

/**
 *
 * @author antony
 */
public class Event {
    private int idEvent;
    private String title;
    private String description;
    private Date date;
    private String state;
    private Ambient ambient; // LLave foranea proveniente de la tabla ambiente.
    private Administrator administrator; // Llave foranea proveniente de la tabla administrador.

    public Event() {
    }

    public Event(String title, String description, Date date, String state, Ambient ambient,
            Administrator administrator) {
        this.title = title;
        this.description = description;
        this.date = date;
        this.state = state;
        this.ambient = ambient;
        this.administrator = administrator;
    }

    public Event(int idEvent, String title, String description, Date date, String state, Ambient ambient,
            Administrator administrator) {
        this.idEvent = idEvent;
        this.title = title;
        this.description = description;
        this.date = date;
        this.state = state;
        this.ambient = ambient;
        this.administrator = administrator;
    }

    public int getIdEvent() {
        return idEvent;
    }

    public void setIdEvent(int idevent) {
        this.idEvent = idevent;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Ambient getAmbient() {
        return ambient;
    }

    public void setAmbient(Ambient ambient) {
        this.ambient = ambient;
    }

    public Administrator getAdministrator() {
        return administrator;
    }

    public void setAdministrator(Administrator administrator) {
        this.administrator = administrator;
    }

}
