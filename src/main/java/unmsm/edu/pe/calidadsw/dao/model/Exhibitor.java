package unmsm.edu.pe.calidadsw.dao.model;

import java.util.Date;

/**
 *
 * @author antony
 */
public class Exhibitor extends User {
    private int idExhibitor;
    private String nationality;
    private String specialty;

    public Exhibitor() {
    }

    public Exhibitor(String dni, String name, String lastname, Date birthdate, String nationality, String specialty) {
        super(dni, name, lastname, birthdate);
        this.nationality = nationality;
        this.specialty = specialty;
    }

    public Exhibitor(String dni, String name, String lastname, Date birthdate, int idExhibitor, String nationality,
            String specialty) {
        super(dni, name, lastname, birthdate);
        this.idExhibitor = idExhibitor;
        this.nationality = nationality;
        this.specialty = specialty;

    }

    public int getIdExhibitor() {
        return idExhibitor;
    }

    public void setIdExhibitor(int idExhibitor) {
        this.idExhibitor = idExhibitor;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

}
