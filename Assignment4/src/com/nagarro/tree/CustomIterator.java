package com.nagarro.tree;

import java.util.Iterator;
import java.util.Queue;

public class CustomIterator<E> implements Iterator<E> {

	Queue<E> root = null;

	public CustomIterator(Queue<E> queueIterator) {
		this.root = queueIterator;
	}

	@Override
	public boolean hasNext() {

		if (this.root == null || root.size() == 0) {
			return false;
		} else {
			return true;
		}
	}

	@Override
	public E next() {

		E data = null;
		try {
			data = this.root.poll();
		} catch (Exception e) {

		}
		return data;
	}

}
