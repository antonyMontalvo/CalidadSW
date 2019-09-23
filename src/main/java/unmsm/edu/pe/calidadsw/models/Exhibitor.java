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
public class Exhibitor {
    int dni;
    String name;
    String lastname;
    String nationality;
    String specialty;

    public Exhibitor(){}
    
    public Exhibitor(int dni, String name, String lastname, String nationality, String specialty) {
        this.dni = dni;
        this.name = name;
        this.lastname = lastname;
        this.nationality = nationality;
        this.specialty = specialty;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
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
