package com.nagarro.tree;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class GenericTree<E> {

	private TreeNode<E> root;
	private int size;

	Queue<E> iteratorDepth;
	Queue<E> iteratorBreadth;

	public GenericTree() {
		iteratorDepth = new LinkedList<>();
		iteratorBreadth = new LinkedList<>();
		root = null;
		size = 0;
	}

	boolean iteratorCheck = false;

	public void printDepth() {
		try {
			if (root == null) {
				throw new Exception("Tree is Empty");
			}
		} catch (Exception e) {
			System.out.println(e);
			return;
		}

		TreeNode<E> temp = root;
		printDepth(temp);
	}

	private void printDepth(TreeNode<E> node) {
		String values = node.value + ":";
		for (int i = 0; i < node.children.size(); i++) {
			if (i == node.children.size() - 1)
				values += node.children.get(i).value;
			else
				values += node.children.get(i).value + ",";
		}
		System.out.println(values);
		for (int i = 0; i < node.children.size(); i++) {
			ArrayList<TreeNode<E>> child = node.children;
			printDepth(child.get(i));
		}

	}

	public void printBreadth() {
		try {
			if (root == null) {
				throw new Exception("Tree is empty!");
			}
		} catch (Exception e) {
			System.out.println(e);
			return;
		}
		System.out.println("The Breadth-wise traversal is:");

		Queue<TreeNode<E>> queue = new LinkedList<>();
		TreeNode<E> temp1 = root;
		queue.add(temp1);

		while (queue.size() != 0) {
			TreeNode<E> temp = queue.poll();
			String values = temp.value + ":";

			for (int i = 0; i < temp.children.size(); i++) {
				ArrayList<TreeNode<E>> child = temp.children;
				values += child.get(i).value + " ";
				queue.add(child.get(i));
			}
			System.out.println(values);

		}

	}

	public void getElementsByLevel(int level) {
		try {
			if (level < 0) {
				throw new Exception("Level can't be negative");
			}
			if (root == null) {
				throw new Exception("Can't find elements.tree is empty!");
			}
		} catch (Exception e) {
			System.out.println(e);
			return;
		}

		Queue<TreeNode<E>> queue = new LinkedList<>();
		TreeNode<E> temp1 = root;
		queue.add(temp1);
		queue.add(null);
		int count = 0;
		String value = "";
		while (queue.size() != 0) {
			TreeNode<E> temp = queue.poll();
			if (temp != null) {
				value = value + temp.value + " ";
				for (int i = 0; i < temp.children.size(); i++) {
					ArrayList<TreeNode<E>> child = temp.children;
					queue.add(child.get(i));
				}
			} else {
				if (queue.size() != 0) {
					queue.add(null);
				}
				if (level == count) {
					break;
				}
				count++;
				value = "";
			}
		}
		try {
			if (level == count)
				System.out.println(value);
			else
				throw new Exception("Not found");
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void insert(E data, E parent) {

		if (root == null) {
			TreeNode<E> childNode = new TreeNode<E>();
			childNode.parent = null;
			childNode.value = data;
			root = childNode;
			size++;
			return;
		}
		TreeNode<E> parentNode = findNode(parent);
		TreeNode<E> childNode = new TreeNode<E>();
		if (parentNode != null) {
			childNode.parent = parentNode;
			childNode.value = data;
			parentNode.children.add(childNode);
			size++;
			return;
		}
		try {
			throw new Exception("Parent is not present");
		} catch (Exception e) {
			System.out.println(e);
		}

	}

	private TreeNode<E> findNode(E nodeData) {

		return findNode(nodeData, root);
	}

	private TreeNode<E> findNode(E nodeData, TreeNode<E> root) {

		if (root.value == nodeData) {
			return root;
		}
		for (int i = 0; i < root.children.size(); i++) {
			ArrayList<TreeNode<E>> child = root.children;
			TreeNode<E> node = findNode(nodeData, child.get(i));
			if (node != null) {
				return node;
			}
		}
		return null;
	}

	public void deleteData(E data) throws Exception {
		TreeNode<E> node = findNode(data);
		if (node != null) {
			node.parent.children.remove(node);
			size--;
			return;
		}
		throw new Exception("Node is not present in the tree");
	}

	public boolean contains(E data) {
		TreeNode<E> node = findNode(data);
		if (node == null) {
			return false;
		} else
			return true;
	}

	public void getElementsByValue(E data) throws Exception {
		if (root == null) {
			throw new Exception("Tree is empty!");
		}
		TreeNode<E> node = findNode(data);
		if (node == null) {
			throw new Exception("Data is not present!");
		} else {
			System.out.print(node.value + ":");
			for (TreeNode<E> var : node.children) {
				System.out.print(var.value + " ");
			}
			System.out.println();
		}
	}

	public void insertRoot(E data) throws Exception {
		if (root == null) {
			TreeNode<E> childNode = new TreeNode<E>();
			childNode.parent = null;
			childNode.value = data;
			root = childNode;
			size++;
			return;
		}
		throw new Exception("Root is not null");
	}

	public Iterator<E> getIterator() {

		if (iteratorCheck)
			return new CustomIterator<E>(iteratorDepth);
		else
			return new CustomIterator<E>(iteratorBreadth);

	}

	public void iteratorDepth() {

		getDepth(root);
		iteratorCheck = true;
		Iterator<E> iterate = getIterator();

		while (iterate.hasNext()) {
			System.out.print(iterate.next() + " ");
		}
		System.out.println();
		iteratorCheck = false;
	}

	public void iteratorBreadth() {
		getBreadth();
		iteratorCheck = false;
		Iterator<E> iterate = getIterator();
		while (iterate.hasNext()) {
			System.out.print(iterate.next() + " ");
		}
		System.out.println();
	}

	private void getBreadth() {
		try {

			Queue<TreeNode<E>> queue = new LinkedList<>();
			queue.add(root);
			while (queue.size() != 0) {

				TreeNode<E> temp = queue.poll();

				iteratorBreadth.add(temp.value);
				for (int i = 0; i < temp.children.size(); i++) {
					ArrayList<TreeNode<E>> child = temp.children;
					queue.add(child.get(i));
				}
			}
		} catch (Exception e) {

		}
	}

	private void getDepth(TreeNode<E> node) {

		if (node != null) {
			iteratorDepth.add(node.value);
			for (int i = 0; i < node.children.size(); i++) {
				ArrayList<TreeNode<E>> child = node.children;
				getDepth(child.get(i));
			}
		}
	}

}
