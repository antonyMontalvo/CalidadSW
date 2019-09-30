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

    public Assistant() {
    }

    public Assistant(Client client, Event event) {
        this.client = client;
        this.event = event;
    }

    public Assistant(int idAssistant, Client client, Event event) {
        this.idAssistant = idAssistant;
        this.client = client;
        this.event = event;
    }

    public int getIdAssistant() {
        return idAssistant;
    }

    public void setIdAssistant(int idAssistant) {
        this.idAssistant = idAssistant;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

}
