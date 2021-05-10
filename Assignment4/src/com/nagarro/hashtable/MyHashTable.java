package com.nagarro.hashtable;

public class MyHashTable<X, Y> {

	private HashEntry[] data;
	private int capacity;
	private int size;

	public MyHashTable() {
		this.capacity = 10000;
		this.size = 0;
		this.data = new HashEntry[this.capacity];
	}

	public void insert(X key, Y value) {
		if (size == capacity) {
			expandCapacity();
		}

		int hash = calculateHash(key);

		data[hash] = new HashEntry<X, Y>(key, value);
		size++;
	}

	public boolean containskey(X key) {
		int hash = calculateHash(key);
		if (data[hash] == null) {
			return false;
		} else {
			if (data[hash].key.equals(key))
				return true;
		}
		return false;
	}

	public Y delete(X key) {
		Y value = get(key);

		if (value != null) {
			int hash = calculateHash(key);
			data[hash] = null;
			size--;
			hash = (hash + 1) % this.capacity;

			while (data[hash] != null) {
				HashEntry he = data[hash];
				data[hash] = null;
				insert((X) he.key, (Y) he.value);
				size--;
				hash = (hash + 1) % this.capacity;
			}
		}
		return value;

	}

	public int size() {
		return this.size;
	}

	public Y get(X key) {
		int hash = calculateHash(key);
		if (data[hash] == null)
			return null;
		else
			return (Y) data[hash].value;
	}

	private int calculateHash(X key) {
		int hash = (key.hashCode() % (this.capacity));///////////////

		while (data[hash] != null && !data[hash].key.equals(key)) {
			hash = (hash + 1) % this.capacity;

		}
		return hash;
	}

	private void expandCapacity() {
		HashEntry[] temp = new HashEntry[capacity * 2];
		capacity *= 2;

		for (int i = 0; i < data.length; i++) {
			temp[i] = data[i];
		}
		data = temp;
	}

	public void print() {
		for (int i = 0; i < capacity; i++) {
			if (data[i] != null) {
				System.out.println(data[i].key + " " + data[i].value);
			}
		}
	}

	public HashIterator getIterator() {
		HashIterator<X, Y> it = new HashIterator(data, size);
		return it;

	}
}
