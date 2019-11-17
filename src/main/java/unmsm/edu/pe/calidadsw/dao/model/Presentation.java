package unmsm.edu.pe.calidadsw.dao.model;

/**
 * Presentation
 */
public class Presentation {
    /**
     * Event_has_exhibitor
     */
    private int idPresentation;
    private String theme;
    private int startTime;
    private int endTime;
    private String date;
    private Event event;
    private Exhibitor exhibitor;

    /**
     * 
     * @return
     */
    public int getIdPresentation() {
        return idPresentation;
    }

    /**
     * 
     * @param idPresentation
     */
    public void setIdPresentation(int idPresentation) {
        this.idPresentation = idPresentation;
    }

    /**
     * 
     * @return
     */
    public String getTheme() {
        return theme;
    }

    /**
     * 
     * @param theme
     */
    public void setTheme(String theme) {
        this.theme = theme;
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
    public Event getEvent() {
        return event;
    }

    /**
     * 
     * @param event
     */
    public void setEvent(Event event) {
        this.event = event;
    }

    /**
     * 
     * @return
     */
    public Exhibitor getExhibitor() {
        return exhibitor;
    }

    /**
     * 
     * @param exhibitor
     */
    public void setExhibitor(Exhibitor exhibitor) {
        this.exhibitor = exhibitor;
    }

}