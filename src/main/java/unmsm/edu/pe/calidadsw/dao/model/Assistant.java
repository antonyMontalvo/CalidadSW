package unmsm.edu.pe.calidadsw.dao.model;

/**
 *
 * @author antony
 */
public class Assistant {
    /**
     * Client_has_Event
     */
    private int idAssistant;
    private Client client;
    private Event event;

    /**
     * 
     * @return
     */
    public int getIdAssistant() {
        return idAssistant;
    }

    /**
     * 
     * @param idAssistant
     */
    public void setIdAssistant(int idAssistant) {
        this.idAssistant = idAssistant;
    }

    /**
     * 
     * @return
     */
    public Client getClient() {
        return client;
    }

    /**
     * 
     * @param client
     */
    public void setClient(Client client) {
        this.client = client;
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
