package com.demo.linkedList;

public class CircularLinkedList {
	
	
Node head;
class Node{
	int data;
	Node next;
	public Node(int value) {
		data = value;
		this.next = null;
	}
}

public void addNode(int value) {
	Node newNode = new Node(value);
	if(head == null) {
		head = newNode;
		head.next=head;
	}else {
		Node temp = head;
		while(temp.next != head) {
			temp = temp.next;
		}
		temp.next= newNode;
		newNode.next = head;
	}
	
}

public void insertAtPosition(int value , int position) {
	if(position <= 0) {
		System.out.println("Invalid position Should be start from 1");
		return;
	}
	
	Node newNode = new Node(value);
	if (head == null) {
        if (position == 1) {
            head = newNode;
            head.next = head;
            return;
        } else {
            System.out.println("List is empty. Can only insert at position 1.");
            return;
        }
    }
	
	if(position == 1) {
		Node temp = head;
		while(temp.next != head) {
			temp = temp.next;
		}
		 newNode.next = head;
         temp.next = newNode;
         head = newNode;
         return;

	}
	 Node current = head;
     for (int i = 1; i < position - 1; i++) {
         current = current.next;
         if (current == head) { 
             System.out.println("Position out of bounds!");
             return;
         }
     }
     // Insert after current
     newNode.next = current.next;
     current.next = newNode;
}

public void deleteByData(int value) {
    if (head == null) {
        System.out.println("List is empty. Nothing to delete.");
        return;
    }

    // Case 1: Only one node
    if (head.data == value && head.next == head) {
        head = null;
        return;
    }

    // Case 2: Delete head node
    if (head.data == value) {
        Node temp = head;
        while (temp.next != head) {
            temp = temp.next;
        }
        temp.next = head.next;
        head = head.next;
        return;
    }

    // Case 3: Delete non-head node
    Node current = head;
    while (current.next != head && current.next.data != value) {
        current = current.next;
    }

    if (current.next == head) {
        System.out.println("Value " + value + " not found in the list.");
    } else {
        current.next = current.next.next;
        System.out.println("Deleted node with data: " + value);
    }
}

public void modifyNode(int oldData, int newData) {
    if (head == null) {
        System.out.println("List is empty. Cannot modify.");
        return;
    }

    Node current = head;
    do {
        if (current.data == oldData) {
            current.data = newData;
            System.out.println("Modified node from " + oldData + " to " + newData);
            return;
        }
        current = current.next;
    } while (current != head);

    System.out.println("Value " + oldData + " not found. Nothing to modify.");
}


    
public void displayData() {
if(head==null) {
	 System.out.println("list is empty");
}else {
	 Node temp=head;
	 do{
		 System.out.print(temp.data+",");
		 temp=temp.next;
	 }while(temp!=head);
	 System.out.println();
}
}

}
