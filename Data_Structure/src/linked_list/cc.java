package linked_list;
import java.util.Iterator;
import java.util.NoSuchElementException;

 


public class listIterator<T> implements Iterator<T>{
	Node<T> current,Head;
	LinkedList<Object> list=new LinkedList<>();
	 T Data;

	listIterator(LinkedList<T> list) {

	current =list.getHead() ;

	
	}

	 
	@Override
	public boolean hasNext() {
	
		return current!=null;
		
	}

	@Override
	public T next() {
		if(current==null)
			throw new NoSuchElementException();
		T res = current.getData();
		current = current.getNext();
		return res;
		}
}
