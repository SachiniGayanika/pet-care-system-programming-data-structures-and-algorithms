
package com.mycompany.pet.care.sys;

class PNode{
    Pet pet;
    PNode next, pre;

    public PNode() {
    }

    public PNode(Pet pet) {
        this.pet = pet;
        next=null;
        pre=null;
    }
}

public class PetList {
    
    PNode head, tail;
    
    public PetList(){
        head=null;
        tail=null;
    }
    
    public void Insert(Pet pet){
        PNode node = new PNode(pet);
        
        if(head==null || tail == null){
            head = node;
            tail = node;
        }else{
            head.next=node;
            node.pre = head;
            head = node;
        }
        
    }
    
    public Pet SearchByID(String id){
        PNode temp = head;
        
        while(temp!=null){
            if(temp.pet.getId().equals(id)){
                return temp.pet;
            }
            temp = temp.pre;
        }
        return null;
    }
    
    public Pet SearchByContact(String contact){
        PNode temp = head;
        
        while(temp!=null){
            if(temp.pet.getPet_owener_contact().equals(contact)){
                return temp.pet;
            }
            temp = temp.pre;
        }
        return null;
    }
    
    // Inside PetList class
public void PrintAllPets() {
    PNode temp = head;

    while (temp != null) {
        System.out.println("Pet ID: " + temp.pet.getId());
        System.out.println("Owner Name: " + temp.pet.getPet_owner_name());
        System.out.println("Owner Contact: " + temp.pet.getPet_owener_contact());
        System.out.println("");

        temp = temp.pre;
    }
}

}