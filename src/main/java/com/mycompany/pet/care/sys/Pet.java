
package com.mycompany.pet.care.sys;

public class Pet {
    private String id, pet_owner_name, pet_owener_contact;      //init variabls

    public Pet(){
        id="";
        this.pet_owner_name="";
        this.pet_owener_contact="";
    }
    
    public Pet(String id, String pet_owner_name, String pet_owener_contact) {        // pet constructor
        this.id = id;
        this.pet_owner_name = pet_owner_name;
        this.pet_owener_contact = pet_owener_contact;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPet_owner_name() {
        return pet_owner_name;
    }

    public void setPet_owner_name(String pet_owner_name) {
        this.pet_owner_name = pet_owner_name;
    }

    public String getPet_owener_contact() {
        return pet_owener_contact;
    }

    public void setPet_owener_contact(String pet_owener_contact) {
        this.pet_owener_contact = pet_owener_contact;
    }

    @Override
    public String toString() {
        return "Pet{" + "id=" + id + ", pet_owner_name=" + pet_owner_name + ", pet_owener_contact=" + pet_owener_contact + '}';
    }
    
    
}
