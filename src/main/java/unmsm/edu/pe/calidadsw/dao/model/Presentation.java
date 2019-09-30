package unmsm.edu.pe.calidadsw.dao.model;

/**
 * Presentation
 */
public class Presentation { // Event_has_exhibitor

    private int idPresentation;
    private int startTime;
    private int endTime;
    private Event event;
    private Exhibitor exhibitor;

    public Presentation(int startTime, int endTime, Event event, Exhibitor exhibitor) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.event = event;
        this.exhibitor = exhibitor;
    }

    public Presentation(int idPresentation, int startTime, int endTime, Event event, Exhibitor exhibitor) {
        this.idPresentation = idPresentation;
        this.startTime = startTime;
        this.endTime = endTime;
        this.event = event;
        this.exhibitor = exhibitor;
    }

    public int getIdPresentation() {
        return idPresentation;
    }

    public void setIdPresentation(int idPresentation) {
        this.idPresentation = idPresentation;
    }

    public int getStartTime() {
        return startTime;
    }

    public void setStartTime(int startTime) {
        this.startTime = startTime;
    }

    public int getEndTime() {
        return endTime;
    }

    public void setEndTime(int endTime) {
        this.endTime = endTime;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public Exhibitor getExhibitor() {
        return exhibitor;
    }

    public void setExhibitor(Exhibitor exhibitor) {
        this.exhibitor = exhibitor;
    }

}