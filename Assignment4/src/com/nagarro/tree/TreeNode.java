package com.nagarro.tree;

import java.util.ArrayList;

public class TreeNode<E> {

	E value;
	ArrayList<TreeNode<E>> children;
	TreeNode<E> parent;

	public TreeNode() {
		this.parent = null;
		this.children = new ArrayList<>();
	}

	public TreeNode(E value) {
		this.value = value;
		this.children = new ArrayList<>();
	}

}
