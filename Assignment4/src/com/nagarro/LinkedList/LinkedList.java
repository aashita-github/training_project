package com.nagarro.LinkedList;

public class LinkedList<T> {

	private Node<T> head = null;

	public void insertAtBeg(T new_data) {
		Node<T> new_node = new Node<T>(new_data);

		new_node.next = head;
		head = new_node;

	}

	public void insertAtLast(T new_data) {
		Node<T> new_node = new Node<T>(new_data);

		if (head == null) {
			head = new Node<T>(new_data);
			return;
		}

		new_node.next = null;

		Node<T> last = head;
		while (last.next != null)
			last = last.next;

		last.next = new_node;
		return;
	}

	public void insertAtPosition(T data, int k) {
		Node<T> temp;
		int i;
		if (k == 1) {
			temp = new Node<T>(data);
			temp.next = head;
			head = temp;
			return;

		}
		Node<T> p = head;
		for (i = 0; i < k - 1; i++) {
			p = p.next;
		}
		if (p == null) {
			System.out.println("You can insert only upto " + i + "th position");

		} else {
			temp = new Node<T>(data);
			temp.next = p.next;
			p.next = temp;
		}

	}

	public void deleteFirstNode() {
		if (head == null) {
			System.err.println("No Node is present");
			return;
		}
		head = head.next;

	}

	public void deleteLastNode() {
		if (head == null) {
			System.err.println("No Node is present");
			return;
		}
		if (head.next == null) {
			head = null;
			return;
		}

		Node<T> p = head;
		while (p.next.next != null)

			p = p.next;
		p.next = null;
	}

	public void deleteAtPosition(int k) {

		if (head == null) {
			System.err.println("No Node is present");
			return;
		}

		Node<T> temp = head;

		if (k == 0) {
			head = temp.next;
			return;
		}
		for (int i = 0; temp != null && i < k - 1; i++)
			temp = temp.next;
		if (temp == null || temp.next == null)
			return;
		Node<T> next = temp.next.next;
		temp.next = next;
	}

	public void Center() {

		Node<T> slow_ptr = head;
		Node<T> fast_ptr = head;
		if (head == null) {
			try {
				throw new Exception("List is Empty");
			} catch (Exception e) {
				System.out.println(e);
				return;
			}
		}

		if (head != null) {
			while (fast_ptr != null && fast_ptr.next != null) {
				fast_ptr = fast_ptr.next.next;
				slow_ptr = slow_ptr.next;
			}
			System.out.println("The middle element is [" + slow_ptr.data + "]");
		}
	}

	public void Reverse() {
		if (head == null)
			return;

		Node<T> prev = null, current = head, nex = null;
		while (current != null) {
			nex = current.next;
			current.next = prev;
			prev = current;
			current = nex;
		}
		head = prev;
	}

	public Listiterator Iterator() {
		Node<T> temp = head;
		Listiterator<T> it = new Listiterator(temp);
		return it;
	}

	public void Size() {
		int count = 0;
		Node<T> p = head;
		if (head == null) {
			System.out.println("no element in the list");
		}
		while (p != null) {
			count++;
			p = p.next;

		}
		System.out.println("Number of Elements in the list are : " + count);

	}

	public void printList() {
		Node<T> tnode = head;
		while (tnode != null) {
			System.out.print(tnode.data + " ");
			tnode = tnode.next;
		}
		System.out.println();
	}

}
