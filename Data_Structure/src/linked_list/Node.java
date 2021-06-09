package linked_list;


public class Node<T> {
	public	T data;
	public 	Node<T> next;
	

	private Node<T> node;
	public Node(T x) {
		// TODO Auto-generated constructor stub
	this.data=x;
	this.next=null;
	
	}
	public Node<T> getNode() {
		return node;
	}
	public Node<T> getNext() {
		return next;
	}
	public void setNext(Node<T> next) {
		this.next = next;
	}
	public void setNode(Node<T> node) {
		this.node = node;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
}

	

