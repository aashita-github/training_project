package com.nagarro.hashtable;

public interface HashTableFunctions<X, Y> {

	public void insert(X key, Y value);

	public Y delete(X key);

	public Y get(X key);

	public int size();

	public boolean containskey(X key);

	public HashIterator getIterator();

	public void print();

}
