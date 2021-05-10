package com.nagarro.tree;

public class main {

	public static void main(String p[]) {
		try {

			GenericTree<Integer> gt = new GenericTree<Integer>();
			gt.insertRoot(5);
			gt.insert(1, 5);

			gt.insert(7, 1);
			gt.insert(9, 5);
			gt.printBreadth();
			System.out.println();
			gt.printDepth();
			gt.getElementsByLevel(1);
			gt.getElementsByValue(1);
			System.out.println();
			gt.iteratorDepth();
			gt.iteratorBreadth();
			gt.deleteData(1);
			gt.printBreadth();

		} catch (Exception e) {
			System.out.print(e);
		}
	}
}
