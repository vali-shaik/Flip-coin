

/*
 * author: Vali Shaik-B00835822
 * 
 * */
public class DoublyLinkedList 
{ //Represent the head and tail of the doubly linked list  
	Node head, tail = null;  
	int size=0;

	public Node returnAddedNode(String data)
	{

		//Create a new node  
		Node newNode = new Node(data);  
		Node currentNode;
		int count=0;
		boolean flag=false;
		//If list is empty  
		if(head == null) {  
			//Both head and tail will point to newNode 
			newNode.up=null;
			newNode.below=null;
			head = tail = newNode;  
			//head's previous will point to null  
			head.previous = null;  
			//tail's next will point to null, as it is the last node of the list  
			tail.next = null;  
			flag=true;
			size++;
		} 
		else
		{
			//Current will point to head 
			Node current = null, index = null;  
			String temp=data;  
			for(current = head; current.next != null; current = current.next) 
			{  
				if(temp.equalsIgnoreCase(current.data))
				{
					count++;
				}//if

			} //for
			//sorted inserted-start
			if(count==0)
			{
				int compareFirstElement=head.data.compareToIgnoreCase(newNode.data);
				if(head==null)
				{
					head=newNode;
				}
				else if(compareFirstElement>0)
				{
					newNode.next=head;
					newNode.next.previous=newNode;
					head=newNode;
					size++;
				}//if
				else
				{
					currentNode=head;
					//int compareNextElement=currentNode.next.data.compareToIgnoreCase(newNode.data);
					while(currentNode.next!=null)
					{
						int compareNextElement=currentNode.next.data.compareToIgnoreCase(newNode.data);
						if( compareNextElement<0)
						{
							currentNode=currentNode.next;
						}//if
						else
						{
							break;
						}

					}//while
					newNode.next=currentNode.next;
					if(currentNode.next!=null)
					{
						newNode.next.previous = newNode; 
					}
					currentNode.next = newNode;  
					newNode.previous = currentNode;
					size++;

				}//else
				flag=true;

			}//if
			else
			{
				newNode=null;
			}
		}//else

		return newNode;


	}

	//addNode() will add a node to the list  
	public boolean addNode(String data) 
	{  
		//Create a new node  
		Node newNode = new Node(data);
		Node currentNode;
		int count=0;
		boolean flag=false;
		//If list is empty  
		if(head == null) {  
			//Both head and tail will point to newNode 
			newNode.up=null;
			newNode.below=null;
			head = tail = newNode;  
			//head's previous will point to null  
			head.previous = null;  
			//tail's next will point to null, as it is the last node of the list  
			tail.next = null;  
			flag=true;
			size++;
		} 
		else
		{
			//Current will point to head 
			Node current = null, index = null;  
			String temp=data;  
			for(current = head; current.next != null; current = current.next) 
			{  
				if(temp.equalsIgnoreCase(current.data))
				{
					count++;
				}//if

			} //for
			//sorted inserted-start
			if(count==0)
			{
				int compareFirstElement=head.data.compareToIgnoreCase(newNode.data);
				if(compareFirstElement>0)
				{
					newNode.next=head;
					newNode.next.previous=newNode;
					head=newNode;
					size++;
				}//if
				else
				{
					currentNode=head;
					int compareNextElement=currentNode.next.data.compareToIgnoreCase(newNode.data);
					while(currentNode.next!=null && compareNextElement<0)
					{
						currentNode=currentNode.next;

					}//while
						newNode.next=currentNode.next;
						if(currentNode.next!=null)
						{
							newNode.next.previous = newNode; 
						}
						currentNode.next = newNode;  
						newNode.previous = currentNode;
						size++;

				}//else
				flag=true;

			}//if
		}//else
		return flag;
	}//add  node 

	//sortList() will sort the given list in ascending order  
	public void sortList() {  
		Node current = null, index = null;  
		String temp;  
		//Check whether list is empty  
		if(head == null) {  
			return;  
		}  
		else {  
			//Current will point to head  
			for(current = head; current.next != null; current = current.next) {  
				//Index will point to node next to current  
				for(index = current.next; index != null; index = index.next) {  
					//If current's data is greater than index's data, swap the data of current and index  
					if(current.data.compareToIgnoreCase(index.data)>0) {  
						temp = current.data;  
						current.data = index.data;  
						index.data = temp;  
					}  
				}  
			}  
		}  
	}  

	//display() will print out the nodes of the list  
	public void display() {  
		//Node current will point to head  
		Node current = head;  
		if(head == null) {  
			System.out.println("List is empty");  
			return;  
		}  
		while(current != null) {  
			//Prints each node by incrementing the pointer.  

			System.out.print("[*"+current.data + "*] (up)-> "+current.up +  " (down)-> "+current.below+ " (next)-> " +current.next);  
			current = current.next;  
		}  
		System.out.println();  
	}


}//class
