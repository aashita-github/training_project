package com.nagarro.stack;

public class main {

	public static void main(String[] args) {

		MyStack<Integer> st = new MyStack<>(5);
		st.push(5);
		st.push(2);
		st.push(3);
		st.push(6);
		st.pop();
		st.print();
		System.out.println(st.peek());
		System.out.println(st.contains(2));
		System.out.println(st.size());
		st.reverse();
		st.print();

		System.out.println();
//		StackIterator itr = st.iterator();
//		while (itr.hasNext()) {
//			System.out.print(itr.next() + " ");
//		}

	}

}
