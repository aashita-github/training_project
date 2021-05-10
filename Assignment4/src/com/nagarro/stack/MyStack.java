package com.nagarro.stack;

public class MyStack<E> implements Stack<E> {

	private E elements[];

	private int top;
	private int size;

	public MyStack() {
		size = 10000;
		top = -1;
		elements = (E[]) new Object[size];
	}

	public MyStack(int size) {
		this.size = size;
		top = -1;
		elements = (E[]) new Object[size];
	}

	@Override
	public void push(E e) {

		if (top == size - 1) {
			try {
				throw new Exception("Stack is Full You can't add more data");
			} catch (Exception ex) {
				System.out.println(ex);
				return;
			}

		} else {
			elements[++top] = e;

		}
	}

	@Override
	public E pop() {
		if (top == -1) {
			try {
				throw new Exception("Stack is Empty");
			} catch (Exception ex) {
				System.err.println(ex);
				return null;
			}
		} else {
			E poped = elements[top];
			top--;
			return poped;
		}
	}

	@Override
	public E peek() {
		if (top == -1) {
			try {
				throw new Exception("Stack is Empty");
			} catch (Exception ex) {
				System.err.println(ex);
				return null;
			}

		} else {
			return elements[top];
		}
	}

	@Override
	public boolean contains(E value) {
		for (int i = 0; i <= top; i++) {
			E obj = elements[i];
			if (obj.equals(value))
				return true;
		}
		return false;
	}

	@Override
	public int size() {
		return top + 1;
	}

	@Override
	public void reverse() {

		if (top == -1) {
			try {
				throw new Exception("Stack is Empty");
			} catch (Exception ex) {
				System.err.println(ex);

			}
		} else {

			int start = 0;
			int end = top;
			while (start < end) {
				E temp = elements[start];
				elements[start] = elements[end];
				elements[end] = temp;
				start++;
				end--;

			}

		}
	}

	public StackIterator iterator() {
		StackIterator<E> it = new StackIterator(elements);
		return it;
	}

	@Override
	public void print() {
		if (top == -1) {
			try {
				throw new Exception("Stack is Empty");
			} catch (Exception ex) {
				System.err.println(ex);

			}
		} else {
			for (int i = top; i >= 0; i--) {
				System.out.print(elements[i] + " ");
			}
		}

	}

}
