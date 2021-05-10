package com.nagarro.mypriorityqueue;

import java.util.Arrays;
import java.util.Comparator;

public class MyPriorityQueue<Integer, E> implements PriorityQueue<Integer, E> {

	private Pair[] H;
	private int capacity = 10000;
	private int size;

	MyPriorityQueue() {
		this.size = -1;

		H = new Pair[capacity];
	}

	@Override
	public void Enqueue(int pr, E value) {

		if (size == capacity) {
			expandCapacity();
		}
		size = size + 1;
		Pair<Integer, E> p = new Pair(pr, value);
		H[size] = p;

		shiftUp(size);
	}

	@Override
	public Pair<Integer, E> Dequeue() {
		try {
			if (size == -1) {
				throw new Exception("PriorityQueue is Empty!!!");
			}
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
		Pair result = H[0];

		H[0] = H[size];
		H[size] = null;

		size = size - 1;

		shiftDown(0);
		return result;
	}

	@Override
	public Pair<Integer, E> peek() {
		try {
			if (size == -1) {
				throw new Exception("Queue is Empty!!!");
			}
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
		return H[0];
	}

	@Override
	public int size() {
		return size + 1;
	}

	@Override
	public boolean contains(E value) {

		if (size == -1) {
			return false;
		}

		for (int i = 0; i < H.length; i++) {
			if (H[i] != null) {
				if (H[i].value.equals(value)) {
					return true;
				}
			}
		}

		return false;

	}

	@Override
	public void reverse() {
		Pair<Integer, E>[] cpy = Arrays.copyOf(H, capacity);
		int s = size;

		Arrays.sort(cpy, new Comparator<Pair<Integer, E>>() {

			@Override
			public int compare(Pair<Integer, E> o1, Pair<Integer, E> o2) {
				if (o1 != null && o2 != null)
					return o1.priority - o2.priority;

				return 0;
			}

		});

		int temp = capacity - 1;
		while (temp > -1 && cpy[temp] == null) {
			temp--;
		}

		if (temp == -1) {
			return;
		}

		int start = 0;
		int end = temp;
		while (start < end) {
			int p = cpy[start].priority;
			cpy[start].priority = cpy[end].priority;
			cpy[end].priority = p;
			start++;
			end--;
		}
		H = new Pair[capacity];
		size = -1;
		for (int i = 0; i <= temp; i++) {
			Enqueue(cpy[i].priority, cpy[i].value);
		}

	}

	@Override
	public PQIterator<Integer, E> getIterator() {
		PQIterator<Integer, E> it = new PQIterator<Integer, E>(H, size);
		return it;
	}

	public void print() {
		Pair<Integer, E>[] copy_Array = Arrays.copyOf(H, capacity);
		int s = size;
		for (int i = 0; i < capacity; i++) {
			Pair p = this.PrintDequeue();
			if (p != null)
				System.out.println(p);

		}
		this.size = s;
		H = Arrays.copyOf(copy_Array, capacity);
	}

	private void shiftDown(int i) {
		int maxIndex = i;

		int l = leftChild(i);

		if (l <= size && H[l].priority > H[maxIndex].priority) {
			maxIndex = l;
		}

		int r = rightChild(i);

		if (r <= size && H[r].priority > H[maxIndex].priority) {
			maxIndex = r;
		}

		if (i != maxIndex) {
			swap(i, maxIndex);
			shiftDown(maxIndex);
		}
	}

	private void expandCapacity() {
		Pair[] temp = new Pair[capacity * 2];
		capacity *= 2;

		for (int i = 0; i < H.length; i++) {
			temp[i] = H[i];
		}

		H = temp;

	}

	private Pair<Integer, E> PrintDequeue() {
		if (size == -1) {
			return null;
		}

		Pair result = H[0];

		H[0] = H[size];
		size = size - 1;

		shiftDown(0);
		return result;
	}

	private void shiftUp(int i) {
		while (i > 0 && H[parent(i)].priority < H[i].priority) {
			swap(parent(i), i);

			i = parent(i);
		}
	}

	private void swap(int i, int j) {
		Pair p = H[i];
		H[i] = H[j];
		H[j] = p;
	}

	private int parent(int i) {
		return (i - 1) / 2;
	}

	private int leftChild(int i) {
		return ((2 * i) + 1);
	}

	private int rightChild(int i) {
		return ((2 * i) + 2);
	}

}
