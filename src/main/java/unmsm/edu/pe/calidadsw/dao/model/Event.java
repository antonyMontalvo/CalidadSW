package unmsm.edu.pe.calidadsw.dao.model;

/**
 *
 * @author antony
 */
public class Event {
    private int _idEvent;
    private String _title;
    private String _description;
    private String _date;
    private String _state;
    private int _idAmbient; // LLave foranea proveniente de la tabla ambiente.
    private int _dni; // Llave foranea proveniente de la tabla administrador.

    public Event() {
    }

    public Event(String title, String description, String date, String state, int idAmbient, int dni) {
        this._title = title;
        this._description = description;
        this._date = date;
        this._state = state;
        this._idAmbient = idAmbient;
        this._dni = dni;
    }

    public int getIdEvent() {
        return _idEvent;
    }

    public void setIdEvent(int idevent) {
        this._idEvent = idevent;
    }

    public String getTitle() {
        return _title;
    }

    public void setTitle(String title) {
        this._title = title;
    }

    public String getDescription() {
        return _description;
    }

    public void setDescription(String description) {
        this._description = description;
    }

    public String getDate() {
        return _date;
    }

    public void setDate(String date) {
        this._date = date;
    }

    public String getState() {
        return _state;
    }

    public void setState(String state) {
        this._state = state;
    }

    public int getIdAmbient() {
        return _idAmbient;
    }

    public void setIdAmbient(int idAmbient) {
        this._idAmbient = idAmbient;
    }

    public int getDni() {
        return _dni;
    }

    public void setDni(int dni) {
        this._dni = dni;
    }

}
