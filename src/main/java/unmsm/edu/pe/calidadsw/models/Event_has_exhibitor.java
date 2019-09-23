/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unmsm.edu.pe.calidadsw.models;

/**
 *
 * @author antony
 */
public class Event_has_exhibitor {
    int idevent;
    int dni;

    public Event_has_exhibitor(){}
    
    public Event_has_exhibitor(int idevent, int dni) {
        this.idevent = idevent;
        this.dni = dni;
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
