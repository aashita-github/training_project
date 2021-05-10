package com.nagarro.LinkedList;
public class Main {

	public static void main(String p[]) {
		LinkedList<Integer> ll = new LinkedList<Integer>();

		ll.insertAtBeg(2);
		ll.insertAtBeg(4);
		ll.insertAtBeg(5);
		ll.printList();
		ll.insertAtLast(6);
		ll.insertAtPosition(0, 2);
		ll.printList();
		ll.deleteFirstNode();
		ll.deleteLastNode();
		ll.deleteAtPosition(1);
		ll.Reverse();
		ll.printList();
		ll.Size();
		Listiterator itr = ll.Iterator();
		while (itr.hasNext()) {
			System.out.println(itr.next());
		}

	}
}
