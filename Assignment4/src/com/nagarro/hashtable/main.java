package com.nagarro.hashtable;

public class main {

	public static void main(String p[]) {
		MyHashTable<String, Integer> ht = new MyHashTable();

		ht.insert("aman", 1);
		ht.insert("parth", 8);
		ht.insert("sn", 5);
		// ht.print();
		ht.delete("aman");
		ht.print();
		System.out.println(ht.containskey("sn"));
		System.out.println(ht.delete("sn"));
		ht.print();
		System.out.println(ht.size());
		System.out.println(ht.get("parth"));
		HashIterator<String, Integer> itr = ht.getIterator();
		while (itr.hasNext()) {
			System.out.print(itr.next() + " ");
		}

	}
}
