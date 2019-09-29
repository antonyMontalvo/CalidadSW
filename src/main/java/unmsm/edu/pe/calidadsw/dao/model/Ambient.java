package unmsm.edu.pe.calidadsw.dao.model;

/**
 *
 * @author antony
 */
public class Ambient {
    private int _idAmbient;
    private String _name;
    private String _type;
    private String _floor;
    private int _capacity;
    private String _description;

    public Ambient() {
    }

    public Ambient(String name, String type, String floor, int capacity, String description) {
        this._name = name;
        this._type = type;
        this._floor = floor;
        this._capacity = capacity;
        this._description = description;
    }

    public int getIdAmbient() {
        return _idAmbient;
    }

    public void setIdAmbient(int idAmbient) {
        this._idAmbient = idAmbient;
    }

    public String getName() {
        return _name;
    }

    public void setName(String name) {
        this._name = name;
    }

    public String getType() {
        return _type;
    }

    public void setType(String type) {
        this._type = type;
    }

    public String getFloor() {
        return _floor;
    }

    public void setFloor(String floor) {
        this._floor = floor;
    }

    public int getCapacity() {
        return _capacity;
    }

    public void setCapacity(int capacity) {
        this._capacity = capacity;
    }

    public String getDescription() {
        return _description;
    }

    public void setDescription(String description) {
        this._description = description;
    }

}
