package com.nagarro.mypriorityqueue;

public class Pair<Integer, X> {

	int priority;
	X value;

	Pair(int p, X v) {
		priority = p;
		value = v;
	}

	@Override
	public String toString() {
		return "Priority:- " + priority + " Value:- " + value;
	}
}
