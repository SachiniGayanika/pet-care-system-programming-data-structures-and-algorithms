
package com.mycompany.pet.care.sys;

public class Checkup {
    Veterinarian vet;
    Pet petObj;
    
    int Priority;
    String Reccommedation, Date;

    public Checkup(Veterinarian vet, Pet petObj, int Priority, String Reccommedation, String Date) {
        this.vet = vet;
        this.petObj = petObj;
        this.Priority = Priority;
        this.Reccommedation = Reccommedation;
        this.Date = Date;
    }

    public Veterinarian getVet() {
        return vet;
    }

    public void setVet(Veterinarian vet) {
        this.vet = vet;
    }

    public Pet getPetObj() {
        return petObj;
    }

    public void setPetObj(Pet petObj) {
        this.petObj = petObj;
    }

    public int getPriority() {
        return Priority;
    }

    public void setPriority(int Priority) {
        this.Priority = Priority;
    }

    public String getReccommedation() {
        return Reccommedation;
    }

    public void setReccommedation(String Reccommedation) {
        this.Reccommedation = Reccommedation;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String Date) {
        this.Date = Date;
    }

    @Override
    public String toString() {
        return "Checkup{" + "vet=" + vet.toString() + ", petObj=" + petObj.toString() + ", Priority=" + Priority + ", Reccommedation=" + Reccommedation + ", Date=" + Date + '}';
    }
    
    
}
