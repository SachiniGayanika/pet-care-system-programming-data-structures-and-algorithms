
package com.mycompany.pet.care.sys;

class CNode{
    Checkup checkup;
    CNode next, pre;
    
    public CNode(Checkup checkup){
        this.checkup = checkup;
        next=null;
        pre=null;
    }
}

public class CheckupList {
    CNode head, tail;
    
    public CheckupList(){
        head=null;
        tail=null;
    }
    
    public void Enqueue(Checkup checkup){
        CNode node = new CNode(checkup);
        if(head==null || tail==null){
            head = node;
            tail = node;
        }else if(head.checkup.getPriority() < checkup.getPriority()){
            head.next = node;
            node.pre = head;
            head = node;
        }else if(tail.checkup.getPriority() >= checkup.getPriority()){
            tail.pre = node;
            node.next = tail;
            tail = node;
        }else{
            CNode temp = tail;
            while(temp != null){
                if(temp.checkup.getPriority() >= checkup.getPriority()){
                    break;
                }
                temp = temp.next;
            }
            node.next = temp;
            node.pre = temp.pre;
            temp.pre.next = node;
            temp.pre = node;
        }
    }
    
  public Checkup dequeue() {
    if (head == null) {
        return null;
    }

    CNode dequeuedNode = head;
    head = head.next;

    if (head != null) {
        head.pre = null; // Set the previous node of the new head to null
    } else {
        tail = null; // If the queue is empty after dequeue, set tail to null
    }

    if (dequeuedNode != null) {
        dequeuedNode.next = null; // Ensure the dequeued node is disconnected from the list
        dequeuedNode.pre = null; // Disconnect the dequeued node's previous reference
    }

    return (dequeuedNode != null) ? dequeuedNode.checkup : null;
}
    
    public void print()
    {
        CNode temp=head;
        while(temp !=null)
        {
            System.out.print("Priority is : ");
            System.out.println(temp.checkup.getPriority());
            temp=temp.pre;   
        }
    }
}
