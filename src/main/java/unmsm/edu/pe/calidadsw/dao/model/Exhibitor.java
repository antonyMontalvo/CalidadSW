package unmsm.edu.pe.calidadsw.dao.model;

/**
 *
 * @author antony
 */
public class Exhibitor {
    private int _dni;
    private String _name;
    private String _lastname;
    private String _nationality;
    private String _specialty;

    public Exhibitor() {
    }

    public Exhibitor(int dni, String name, String lastname, String nationality, String specialty) {
        this._dni = dni;
        this._name = name;
        this._lastname = lastname;
        this._nationality = nationality;
        this._specialty = specialty;
    }

    public int getDni() {
        return _dni;
    }

    public void setDni(int dni) {
        this._dni = dni;
    }

    public String getName() {
        return _name;
    }

    public void setName(String name) {
        this._name = name;
    }

    public String getLastname() {
        return _lastname;
    }

    public void setLastname(String lastname) {
        this._lastname = lastname;
    }

    public String getNationality() {
        return _nationality;
    }

    public void setNationality(String nationality) {
        this._nationality = nationality;
    }

    public String getSpecialty() {
        return _specialty;
    }

    public void setSpecialty(String specialty) {
        this._specialty = specialty;
    }

}
