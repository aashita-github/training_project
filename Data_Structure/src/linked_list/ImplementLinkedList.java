package linked_list;
import java.util.Scanner;


public class ImplementLinkedList {
	public static void main(String args[]) {
		@SuppressWarnings("resource")
		Scanner scanObj = new Scanner(System.in);
		int n,option;
		LinkedList<Object> list=new LinkedList<>();
		System.out.println("Enter Size Of linked list: ");
		while(true)
		{
    	try {
		n=Integer.parseInt(scanObj.next());
		break;
    	}
    	catch(NumberFormatException e) {
    		System.out.println("Enter a number!");
    		continue;
    	}
	}
	    while(true)
        { System.out.println("\nEnter yours choice \n1.INSERT 2.INSERT AT POSITION 3.DELETE ");
        System.out.println("4.DELETE AT POSITION 5.CENTER 6.REVERSE");
        System.out.println("7.SIZE   8.ITERATOR   9.PRINT   10.EXIT");
       
        
        while(true)
		{
    	try {
		 option=Integer.parseInt(scanObj.next());
		break;
    	}
    	catch(NumberFormatException e) {
    		System.out.println("Enter a number!");
    		continue;
    	}
		}
        switch(option)
        { case 1:
        	System.out.println("Enter Element");
        	for(int i=0;i<n;i++) {
        		Object x=scanObj.next();
        		list.push(x);
        	}break;
        case 2:
        	System.out.print("Enter element \n");
        	Object x=scanObj.next();
        	System.out.print("Position From Start: ");
        	int p=Integer.parseInt(scanObj.next());
        	list.insertNth(x,p-1);
        	System.out.println();
    		System.out.println("Updated Linked List:");
    		list.printLinkedList();
          	break;
        
        case 3:
        	System.out.print("Enter element to delete ");
        	Object deleteElement=scanObj.next();
        	list.deleteKeyNode(deleteElement);
    		System.out.println();
    		System.out.println("Updated Linked List:");
    		list.printLinkedList();
    		
        	
        	break;
        case 4:
        	System.out.print("Position From Start: ");
        	int position=Integer.parseInt(scanObj.next());;
        	list.deleteNodeAtPosition(position-1);
        	System.out.println();
    		System.out.println("Updated Linked List:");
    		list.printLinkedList();
            break;
        case 5:
        	
        	break;
        case 6:
        	 System.out.println();
        	 System.out.println("Reversed Linked List:");
     		 list.head=list.reverseLinkedList(list.head);
     		 list.printLinkedList();		
             System.out.println();
             break;
        case 7:
        	System.out.println("Size of Linked List is:"+ list.size());
            break;	
        case 8:
        	listIterator<Object> iterator = (listIterator<Object>) list.iterator();
    		System.out.println("******Iterate over the singly linked list while iterator is moving******");
    		
    		while (iterator.hasNext()) {
    			
    			System.out.print(iterator.next()+" ");
    			
    		}
    		
            break;	
        case 9:
        	System.out.println("Linked List-->");
    		list.printLinkedList();
            break;	
        case 10:
        	System.exit(0);
        default:System.out.println("Wrong option");
        }
        }
 }
	}

		
		
		
	 	
		
		
	
		
	    
	
	

