package unmsm.edu.pe.calidadsw.dao.model;

/**
 *
 * @author antony
 */
public class Ambient {
    private int idAmbient;
    private String name;
    private String type;
    private String floor;
    private int capacity;
    private String description;
    private String state;

    public Ambient() {

    }

    /**
     * 
     * @param idAmbient
     */
    public Ambient(int idAmbient) {
        this.idAmbient = idAmbient;
    }

    /**
     * 
     * @return
     */
    public int getIdAmbient() {
        return idAmbient;
    }

    /**
     * 
     * @param idAmbient
     */
    public void setIdAmbient(int idAmbient) {
        this.idAmbient = idAmbient;
    }

    /**
     * 
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * 
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 
     * @return
     */
    public String getType() {
        return type;
    }

    /**
     * 
     * @param type
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * 
     * @return
     */
    public String getFloor() {
        return floor;
    }

    /**
     * 
     * @param floor
     */
    public void setFloor(String floor) {
        this.floor = floor;
    }

    /**
     * 
     * @return
     */
    public int getCapacity() {
        return capacity;
    }

    /**
     * 
     * @param capacity
     */
    public void setCapacity(int capacity) {
        this.capacity = capacity;
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

}
