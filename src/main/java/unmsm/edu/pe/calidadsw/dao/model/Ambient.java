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

    public Ambient(String name, String type, String floor, int capacity, String description, String state) {
        this.name = name;
        this.type = type;
        this.floor = floor;
        this.capacity = capacity;
        this.description = description;
        this.state = state;
    }

    public int getIdAmbient() {
        return idAmbient;
    }

    public void setIdAmbient(int idAmbient) {
        this.idAmbient = idAmbient;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getFloor() {
        return floor;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

}
