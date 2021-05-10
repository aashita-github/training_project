package com.nagarro.hashtable;

public class HashEntry<X, Y> {

	X key;
	Y value;

	public HashEntry(X key, Y value) {
		this.key = key;
		this.value = value;
	}

	@Override
	public String toString() {
		return "KEY:- " + key + " Value:- " + value;
	}

}
