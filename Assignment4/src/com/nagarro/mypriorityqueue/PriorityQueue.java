package com.nagarro.mypriorityqueue;

public interface PriorityQueue<Integer, E> {

	public void Enqueue(int pr, E value);

	public Pair<Integer, E> Dequeue();

	public Pair<Integer, E> peek();

	public int size();

	public boolean contains(E value);

	public void reverse();

	public PQIterator<Integer, E> getIterator();

}
