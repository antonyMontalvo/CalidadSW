package unmsm.edu.pe.calidadsw.dao.model;

/**
 *
 * @author antony
 */
public class Event {
    private int idEvent;
    private String title;
    private String description;
    private String date;
    private String state;
    private int idAmbient; // LLave foranea proveniente de la tabla ambiente.
    private int dni; // Llave foranea proveniente de la tabla administrador.

    public Event() {
    }

    public Event(String title, String description, String date, String state, int idAmbient, int dni) {
        this.title = title;
        this.description = description;
        this.date = date;
        this.state = state;
        this.idAmbient = idAmbient;
        this.dni = dni;
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getIdAmbient() {
        return idAmbient;
    }

    public void setIdAmbient(int idAmbient) {
        this.idAmbient = idAmbient;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

}
