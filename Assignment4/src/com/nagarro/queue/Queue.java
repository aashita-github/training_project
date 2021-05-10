package com.nagarro.queue;

interface Queue<E> {

	public void enqueue(E e);

	public void print();

	public void peek();

	public boolean Contains(E value);

	public void size();

	public boolean IsFull();

	public boolean IsEmpty();

	public void reverse();
}
