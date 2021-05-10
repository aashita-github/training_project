package com.nagarro.queue;

public class main {

	public static void main(String p[]) {
		MyQueue<Integer> q = new MyQueue<>(3);

		q.enqueue(3);
		q.enqueue(1);
		q.enqueue(5);
		q.dequeue();
		q.print();
		System.out.println();
		q.peek();
		System.out.println(q.Contains(1));
		q.size();
		q.reverse();
		q.print();
		System.out.println();
		QueueIterator<Integer> itr = q.iterator();
		while (itr.hasNext()) {
			System.out.print(itr.next() + " ");
		}

	}
}
