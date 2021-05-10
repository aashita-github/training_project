package com.nagarro.mypriorityqueue;

import java.util.Arrays;
import java.util.Iterator;

public class PQIterator<Integer, E> implements Iterator {
	private Pair<Integer, E>[] H;
	private int size;

	public PQIterator(Pair<Integer, E>[] H, int size) {
		this.H = Arrays.copyOf(H, H.length);
		this.size = size;
	}

	@Override
	public boolean hasNext() {
		return (size > -1);
	}

	@Override
	public Pair<Integer, E> next() {

		return PrintDequeue();

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
