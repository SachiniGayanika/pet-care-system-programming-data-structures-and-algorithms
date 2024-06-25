
package com.mycompany.pet.care.sys;

class VNode{
    Veterinarian veterinarian;
    VNode next, pre;

    public VNode() {
    }

    public VNode(Veterinarian veterinarian) {
        this.veterinarian = veterinarian;
        next=null;
        pre=null;
    }
}


public class VeterinarianList {
    VNode head, tail;
    
    public VeterinarianList(){
        head=null;
        tail=null;
    }
    
    public void Insert(Veterinarian veterinarian){
        VNode node = new VNode(veterinarian);
        
        if(head==null || tail == null){
            head = node;
            tail = node;
        }else{
            head.next=node;
            node.pre = head;
            head = node;
        }
    }
    
    public Veterinarian SearchByID(String id){
        VNode temp = head;
        
        while(temp!=null){
            if(temp.veterinarian.getId().equals(id)){
                return temp.veterinarian;
            }
            temp = temp.pre;
        }
        return null;
    }
    
    public Veterinarian SearchByContact(String contact){
        VNode temp = head;
        
        while(temp!=null){
            if(temp.veterinarian.getContact().equals(contact)){
                return temp.veterinarian;
            }
            temp = temp.pre;
        }
        return null;
    }
    
    public void AllVeterinarianInfo(){
        VNode temp = head;
        
        while(temp!=null){
            System.out.println("Veterinarian id : "+temp.veterinarian.getId());
            System.out.println("Speciality is : "+temp.veterinarian.getSpeciality());
            System.out.println("");
            
            temp = temp.pre;
        }
    }
}
