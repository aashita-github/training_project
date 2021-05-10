package com.nagarro.stack;

public interface Stack<E> {

	public void push(E e);

	public E pop();

	public E peek();

	public boolean contains(E value);

	public int size();

	public void reverse();

	public void print();

}
