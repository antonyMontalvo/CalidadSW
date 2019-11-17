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
    private String dateEnd;
    private String state;
    private int startTime; // Ambos en proceso para ser borrados
    private int endTime; // Ambos en proceso para ser borrados
    private Ambient ambient; // LLave foranea proveniente de la tabla ambiente.
    private Administrator administrator; // Llave foranea proveniente de la tabla administrador.
    private Type type; // Llave foranea proveniente de la tabla tipo.

    /**
     * 
     * @return
     */
    public int getIdEvent() {
        return idEvent;
    }

    /**
     * 
     * @param idevent
     */
    public void setIdEvent(int idevent) {
        this.idEvent = idevent;
    }

    /**
     * 
     * @return
     */
    public String getTitle() {
        return title;
    }

    /**
     * 
     * @param title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * 
     * @return
     */
    public String getDescription() {
        return description;
    }

    /**
     * 
     * @param description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * 
     * @return
     */
    public String getDate() {
        return date;
    }

    /**
     * 
     * @param date
     */
    public void setDate(String date) {
        this.date = date;
    }

    /**
     * 
     * @return
     */
    public String getDateEnd() {
        return dateEnd;
    }

    /**
     * 
     * @param date
     */
    public void setDateEnd(String dateEnd) {
        this.dateEnd = dateEnd;
    }

    /**
     * 
     * @return
     */
    public String getState() {
        return state;
    }

    /**
     * 
     * @param state
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * 
     * @return
     */
    public int getStartTime() {
        return startTime;
    }

    /**
     * 
     * @param startTime
     */
    public void setStartTime(int startTime) {
        this.startTime = startTime;
    }

    /**
     * 
     * @return
     */
    public int getEndTime() {
        return endTime;
    }

    /**
     * 
     * @param endTime
     */
    public void setEndTime(int endTime) {
        this.endTime = endTime;
    }

    /**
     * 
     * @return
     */
    public Ambient getAmbient() {
        return ambient;
    }

    /**
     * 
     * @param ambient
     */
    public void setAmbient(Ambient ambient) {
        this.ambient = ambient;
    }

    /**
     * 
     * @return
     */
    public Administrator getAdministrator() {
        return administrator;
    }

    /**
     * 
     * @param administrator
     */
    public void setAdministrator(Administrator administrator) {
        this.administrator = administrator;
    }

    /**
     * 
     * @return
     */
    public Type getType() {
        return type;
    }

    /**
     * 
     * @param type
     */
    public void setType(Type type) {
        this.type = type;
    }

}
