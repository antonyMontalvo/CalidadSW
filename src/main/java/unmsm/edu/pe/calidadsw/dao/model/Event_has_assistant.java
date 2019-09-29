package unmsm.edu.pe.calidadsw.dao.model;

/**
 *
 * @author antony
 */
public class Event_has_assistant {
    int idevent;
    int dni;
    
    public Event_has_assistant(int idevent,int dni){
        this.idevent=idevent;
        this.dni=dni;
    }

    public int getIdevent() {
        return idevent;
    }

    public void setIdevent(int idevent) {
        this.idevent = idevent;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }
    
    
}
