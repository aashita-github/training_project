package com.nagarro.mypriorityqueue;

public class main {

	public static void main(String p[]) {
		MyPriorityQueue<Integer, String> mq = new MyPriorityQueue<>();

		mq.Enqueue(2, "aman");
		mq.Enqueue(1, "smile");
		mq.Enqueue(5, "elvin");

		mq.print();
		System.out.println(mq.Dequeue());
		System.out.println(mq.peek());
		System.out.println(mq.size());
		mq.reverse();
		mq.print();

		PQIterator itr = mq.getIterator();
		while (itr.hasNext()) {
			System.out.println(itr.next());
		}

	}
}
