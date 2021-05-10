package com.nagarro.queue;

public class MyQueue<E> implements Queue<E> {

	private E[] elements;
	private int front, rear;
	private int maxQueuesize;

	MyQueue(int maxQueuesize) {
		front = -1;
		rear = -1;

		this.maxQueuesize = maxQueuesize;
		elements = (E[]) new Object[maxQueuesize];
	}

	public MyQueue() {
		front = -1;
		rear = -1;

		maxQueuesize = 10000;
		elements = (E[]) new Object[maxQueuesize];
	}

	@Override
	public void enqueue(E item) {
		if (IsFull()) {

			try {
				throw new Exception("Overflow");
			} catch (Exception e) {
				System.err.println(e);
				return;
			}

		} else if (IsEmpty()) {
			rear = front = 0;
			elements[rear] = item;
		} else {
			elements[++rear] = item;
		}
	}

	public void dequeue() {
		if (IsEmpty()) {
			try {
				throw new Exception("queue is empty");
			} catch (Exception ex) {
				System.err.println(ex);
				return;
			}
		} else if (front == rear) {
			E data = elements[front];
			System.out.println(data);
			front = rear = -1;
		} else {

			E data = elements[front];

			System.out.println(data);
			front++;
		}
	}

	@Override
	public void peek() {
		if (IsEmpty()) {
			System.err.println("Queue is empty");
		} else
			System.out.println(elements[front]);
	}

	@Override
	public boolean Contains(E value) {
		if (IsEmpty()) {
			return false;
		} else {
			for (int i = front; i <= rear; i++) {
				E obj = elements[i];
				if (obj.equals(value))
					return true;
			}
			return false;
		}
	}

	@Override
	public void size() {
		if (IsEmpty()) {
			System.out.print("Queue is empty");
		} else
			System.out.println(rear - front + 1);
	}

	@Override
	public void reverse() {

		if (IsEmpty()) {
			try {
				throw new Exception("Queue is Empty");
			} catch (Exception e) {
				System.out.println(e);
				return;
			}
		} else {
			int start = front;
			int end = rear;
			while (start < end) {
				E temp = elements[start];
				elements[start] = elements[end];
				elements[end] = temp;
				start++;
				end--;

			}

		}
	}

	public QueueIterator<E> iterator() {
		QueueIterator<E> it = new QueueIterator(elements, rear, front);
		return it;
	}

	@Override
	public void print() {
		if (IsEmpty()) {
			System.out.println("Queue is empty");
		} else {
			for (int i = front; i <= rear; i++) {
				System.out.print(elements[i] + " ");
			}
		}
	}

	@Override
	public boolean IsFull() {
		if (rear == maxQueuesize - 1)
			return true;
		else {
			return false;
		}
	}

	@Override
	public boolean IsEmpty() {
		if (front == -1 && rear == -1)
			return true;
		else if (front > rear) {
			return true;
		} else {
			return false;
		}

	}
}
