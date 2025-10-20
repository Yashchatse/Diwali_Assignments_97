package com.demo.testList;

import com.demo.linkedList.CircularLinkedList;

public class TestCircularLinkedList {
	public static void main(String[] args) {
	CircularLinkedList list = new CircularLinkedList();
	
	list.addNode(10);
    list.addNode(20);
    list.addNode(30);
    list.displayData();

    list.insertAtPosition(15, 2);
    list.displayData(); 

    list.deleteByData(20);
    list.displayData(); 

    list.modifyNode(15, 25);
    list.displayData();
	}
}
