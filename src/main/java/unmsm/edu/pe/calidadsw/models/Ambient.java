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
public class Ambient {
    int idambient;
    String name;
    String type;
    String floor;
    int capacity;
    String description;

    public Ambient(){
        
    }
    public Ambient(String name, String type, String floor, int capacity, String description) {
        this.name = name;
        this.type = type;
        this.floor = floor;
        this.capacity = capacity;
        this.description = description;
    }

    public int getIdambient() {
        return idambient;
    }

    public void setIdambient(int idambient) {
        this.idambient = idambient;
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
    
}
