package unmsm.edu.pe.calidadsw.dao.model;

/**
 *
 * @author antony
 */
public class Exhibitor extends User {
    private int idExhibitor;
    private String nationality;
    private String specialty;

    /**
     * 
     * @return
     */
    public int getIdExhibitor() {
        return idExhibitor;
    }

    /**
     * 
     * @param idExhibitor
     */
    public void setIdExhibitor(int idExhibitor) {
        this.idExhibitor = idExhibitor;
    }

    /**
     * 
     * @return
     */
    public String getNationality() {
        return nationality;
    }

    /**
     * 
     * @param nationality
     */
    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    /**
     * 
     * @return
     */
    public String getSpecialty() {
        return specialty;
    }

    /**
     * 
     * @param specialty
     */
    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

}
