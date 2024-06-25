
package com.mycompany.pet.care.sys;


public class Veterinarian {
    private String id, name, contact, speciality;
    private float fees;
    
    public Veterinarian(){
        
    }

    public Veterinarian(String id, String name, String contact, String speciality, float fees) {
        this.id = id;
        this.name = name;
        this.contact = contact;
        this.speciality = speciality;
        this.fees = fees;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public float getFees() {
        return fees;
    }

    public void setFees(float fees) {
        this.fees = fees;
    }

    @Override
    public String toString() {
        return "Veterinarian{" + "id=" + id + ", name=" + name + ", contact=" + contact + ", speciality=" + speciality + ", fees=" + fees + '}';
    }
    
    
    
}
