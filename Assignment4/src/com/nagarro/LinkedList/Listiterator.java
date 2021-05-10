package com.nagarro.LinkedList;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class Listiterator<T> implements Iterator<Node<T>> {

	Node<T> curr;

	Listiterator(Node<T> head) {
		curr = head;
	}

	@Override
	public boolean hasNext() {
		return curr != null;

	}

	@Override
	public Node<T> next() {

		if (curr == null)
			throw new NoSuchElementException();
		Node<T> res = curr;
		curr = curr.next;
		return res;
	}

}
