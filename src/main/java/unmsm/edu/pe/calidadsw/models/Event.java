package unmsm.edu.pe.calidadsw.models;

/**
 *
 * @author antony
 */
public class Event {
    int idevent;
    String title;
    String description;
    String date;
    String state;
    int idambiente; // LLave foranea proveniente de la tabla ambiente.
    int dni; // Llave foranea proveniente de la tabla administrador.

    public Event() {

    }

    public Event(String title, String description, String date, String state, int idambiente, int dni) {
        this.title = title;
        this.description = description;
        this.date = date;
        this.state = state;
        this.idambiente = idambiente;
        this.dni = dni;
    }

    public int getIdevent() {
        return idevent;
    }

    public void setIdevent(int idevent) {
        this.idevent = idevent;
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

    public int getIdambiente() {
        return idambiente;
    }

    public void setIdambiente(int idambiente) {
        this.idambiente = idambiente;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

}
