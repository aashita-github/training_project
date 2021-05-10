package com.nagarro.queue;

import java.util.Iterator;

public class QueueIterator<E> implements Iterator {

	private int front;
	private int rear;
	private E[] arr;

	public QueueIterator(E[] arr, int rear, int front) {
		this.front = front - 1;
		this.rear = rear;
		this.arr = arr;
	}

	@Override
	public boolean hasNext() {

		return (rear > front);
	}

	@Override
	public Object next() {

		E el = arr[++front];
		return el;
	}

}
