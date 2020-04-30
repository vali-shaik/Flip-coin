

/*
 * author: Vali Shaik-B00835822
 * 
 * */
public class DoublyLinkedListLevels {

	//Represent the head and tail of the doubly linked list that can be used for refering the levels  
	NodeLevels head, tail = null;  
	static int size=0;

	//addNode() will add a node to the list  
	public boolean addDoubleLinkedList(DoublyLinkedList data) 
	{  
		//Create a new node  
		NodeLevels newNode = new NodeLevels(data);  
		int count=0;
		boolean flag=false;
		//If list is empty  
		if(head == null) {  
			//Both head and tail will point to newNode  
			head = tail = newNode;  
			//head's previous will point to null  
			head.up = null;  
			//tail's next will point to null, as it is the last node of the list  
			tail.below = null;  
			flag=true;
			size++;
		} 
		else
		{
			//newNode will be added after tail such that tail's next will point to newNode  
			tail.up = newNode;  
			//newNode's previous will point to tail  
			newNode.below = tail; 
			//newNode.up=null;
			//newNode will become new tail  
			tail = newNode;  
			//As it is last node, tail's next will point to null  
			tail.up = null;
			flag=true;
			size++;
		}//else

		return flag;
	}//add  



	//display() will print out the nodes of the list  
	public void display() {  
		//Node current will point to head  
		NodeLevels current = head;  
		if(head == null) {  
			System.out.println("List is empty");  
			return;  
		}  
		while(current != null) {  
			//Prints each node by incrementing the pointer.  
			System.out.println("================");
			current.purchase.display(); 
			System.out.println("===============");
			current = current.up; 

		}  
		System.out.println();  
	}


}//class
