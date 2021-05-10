package com.nagarro.hashtable;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class HashIterator<X, Y> implements Iterator {

	private HashEntry<X, Y>[] he;
	private int size;
	private int i = 0;
	private int last = 0;

	HashIterator(HashEntry<X, Y>[] he, int size) {
		this.he = he;
		this.size = size;
	}

	@Override
	public boolean hasNext() {

		return (i < size);
	}

	@Override
	public HashEntry<X, Y> next() {
		if (i >= size) {
			throw new NoSuchElementException();
		}

		for (int j = last; j < he.length; j++) {
			if (he[j] != null) {
				i++;
				last = j + 1;
				return he[j];
			}
		}
		return null;
	}

}
