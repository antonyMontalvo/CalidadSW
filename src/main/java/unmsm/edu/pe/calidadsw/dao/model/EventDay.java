package unmsm.edu.pe.calidadsw.dao.model;

/**
 * EventDay
 */
public class EventDay {
    private int idEventDay;
    private int startTime;
    private int endTime;
    private String date;
    private Event event;

    /**
     * 
     * @return
     */
    public int getIdEventDay() {
        return idEventDay;
    }

    /**
     * 
     * @param idEventDay
     */
    public void setIdEventDay(int idEventDay) {
        this.idEventDay = idEventDay;
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

}