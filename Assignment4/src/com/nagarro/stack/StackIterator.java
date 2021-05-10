package com.nagarro.stack;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class StackIterator<E> implements Iterator<E> {

	int i;
	E arr[];

	public StackIterator(E arr[]) {
		this.arr = arr;

		if (arr.length == 0) {
			i = -1;
		} else {
			i = arr.length - 1;
		}

	}

	@Override
	public boolean hasNext() {

		return (i > -1);
	}

	@Override
	public E next() {
		if (i < 0)
			throw new NoSuchElementException();

		return arr[i--];
	}

}
