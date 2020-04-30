import java.util.regex.Matcher;
import java.util.regex.Pattern;


/*
 * author: Vali Shaik-B00835822
 * 
 * */

public class ListHierarchy {

	//Double linked List data structure for all the keys
	//Data Structure for keys
	public static DoublyLinkedList purchases;
	//Data Structure used to add keys in upper level
	public static DoublyLinkedList nextPurchases;
	public static DoublyLinkedListLevels levels;
	//creating a reference for flip 
	static Coin flip;
	static int levelSize=0;

	//Constructor to accept Coin reference value
	public  ListHierarchy( Coin flip ) {
		if(flip!=null)
		{
			ListHierarchy.flip=flip;
		}
		//instantiating List for adding nodes and their levels
		purchases =new DoublyLinkedList();
		levels=new DoublyLinkedListLevels();
	}

	/*
	 * Function used to add the given key to the levels and checks for the flip value, if the flip value is 1 then adding the key to next levels.
	 * This process continues recursively until the single key is present in the top most level
	 * 
	 * input:- String
	 * output:- boolean
	 * */
	public static boolean nextLevelFlip(String key)
	{

		try {
			//Creating reference for node levels
			NodeLevels headNode = levels.head;
			NodeLevels tail=levels.tail;
			//creating a new node for the key
			Node currentKey=new Node();
			//adding new key to the lowest level and getting that node back for reference
			currentKey=purchases.returnAddedNode(key);
			//checking if the key is not added into the lowest or above level
			if(currentKey==null)
			{
				return false;
			}
			//taking head node as current node for further reference
			NodeLevels currentNode = headNode;
			//if there are no levels, then create a new level
			if(headNode==null)
			{
				NodeLevels newNode=new NodeLevels();
				newNode.below=null;
				newNode.up=null;
				newNode.setPurchase(purchases);
				levels.head=newNode;
				levels.tail=newNode;
			}//if
			else
			{
				//if there are existing levels then adding key to next levels
				while(currentNode!=null)
				{
					//checking for flip value to check for null
					if(flip!=null)
					{

						if(flip.flip()==1)
						{
							//flip is positive so add key to either existing upper level or  new level
							if(currentNode.up!=null)
							{
								//adding key to the existing upper level
								currentNode =currentNode.up;
								//Adding key to the existing upper level
								Node newlyCreatedNode=currentNode.getPurchase().returnAddedNode(key);
								//Assigning references to the node with its upper and below nodes
								newlyCreatedNode.below=currentKey;
								currentKey.up=newlyCreatedNode;
								newlyCreatedNode.up=null;
								currentKey =newlyCreatedNode;
							} //if
							else
							{
								//creating a new level and adding key to that level and exit
								NodeLevels newNode=new NodeLevels();
								//creating a new node
								nextPurchases=new DoublyLinkedList();
								Node newlyCreatedNode=nextPurchases.returnAddedNode(key);
								//Assigning references to the node with its upper and below nodes
								newlyCreatedNode.below=currentKey;
								currentKey.up=newlyCreatedNode;
								newlyCreatedNode.up=null;
								newNode.setPurchase(nextPurchases);
								levelSize++;
								newNode.below=currentNode;
								currentNode.up=newNode;
								newNode.up=null;
								levels.tail=newNode;
								break;
							}//else
						}//if
						else
						{
							//flip value is negative or 0 then stop adding the key to the upper levels
							break;
						}//else

					}//if-flip null

				}//while
			}//else
			return true;
		}
		catch (Exception e) 
		{
			return false;
		}
	}//nextLevels


	/*Function to check if the value in the String input contains only alphabets
	 * 
	 * Input: String
	 * Output: Boolean
	 * */
	public static boolean isString(String strNum) 
	{
		boolean flag=false;
		try {
			Matcher m=Pattern.compile("[a-zA-Z]").matcher(strNum);
			if(m.find())
			{
				flag=true;
			}
		}//try
		catch (Exception e) 
		{
			flag=false;
		}//catch
		return flag;
	}//isString


	/*
	 *Function boolean add(String) method is used to add new item into the level and checks the flip count to add the same element in the further level
	 * 
	 *input : String
	 *output : boolean
	 *
	 */
	/**
	 * @param key
	 * @return
	 */
	public static boolean add( String key ) 
	{
		boolean ack=false;
		try 
		{
			//checking whether input key is of null
			if(key!=null)
			{
				//validating the given input string if it is aplhabetic or numeric
				if(isString(key))
				{
					//calling a method to add the key
					ack=nextLevelFlip(key.trim());
					//Print for debugging 
					/*System.out.println("[ Total levels :- "+levelSize+" ]");
					levels.display();*/
				}//if
			}//if
		}//try
		catch (Exception e)//Handling unexpected exceptions 
		{
			ack=false;
		}//catch
		//returning the acknowledgement value to the console
		return ack;
	}//add


	/*
	 * 
	 * Function boolean find(String) is used to find the key from the levels in minimum time.
	 * The search starts from the upper level with minimum nodes and follows to the below levels.Its similar to binary search tree.
	 * If element found in the upper levels then the search stops and return true as the element is found.
	 * 
	 * input:- String
	 * output:- boolean
	 * 
	 * */

	public static boolean find( String key ) 
	{

		try {
			//checking whether the string is alphabetic or numeric
			if(!isString(key))
			{
				return false;
			}
			//Creating the reference of the levels and start traversing from the top most level with minimal nodes
			NodeLevels currentLevel=levels.tail;
			if(currentLevel!=null&&currentLevel.getPurchase()!=null)
			{
				//Fetching the top level nodes from the levels and traversing each and every nodes for search
				Node currentNodeInLevel=currentLevel.getPurchase().head;
				if(currentNodeInLevel.data.equalsIgnoreCase(key))
				{
					//If the key is present in the first level with single node
					return true;
				}
				while(currentNodeInLevel.next!=null)
				{
					//Traversing the other nodes in the current level
					currentNodeInLevel=currentNodeInLevel.next;
					//Comparing the key with the node value, so that search time and no of searches with be minimized as a binary search tree concept
					int compareLimit=currentNodeInLevel.data.compareToIgnoreCase(key);
					if(compareLimit>0)
					{
						while(currentNodeInLevel.below!=null)
						{
							//Traversing to the below level of same node
							currentNodeInLevel=currentNodeInLevel.below;
							while(currentNodeInLevel.previous!=null)
							{
								//Traversing to the previous nodes for finding the key
								int compareAtLastLevel=currentNodeInLevel.previous.data.compareToIgnoreCase(key);
								if(compareAtLastLevel==0)
								{
									//If key matches with any of the nodes then return true as key is founf
									return true;
								}//if
								else
								{
									//If the key is not present in the level then go to the below level
									currentNodeInLevel=currentNodeInLevel.previous;
								}//else

							}//while
						}//while
						return false;
					}//if
					else if(compareLimit<0)
					{
						//Travesing the levels
						currentNodeInLevel=currentNodeInLevel.next;

					}//else if
					else
					{
						return true;
					}
					//Traversing the levels
					currentNodeInLevel=currentNodeInLevel.next;	
				}//while

				//start searhing and reaching last
				while(currentNodeInLevel.below!=null)
				{
					//Travesing to the same node in below level 
					currentNodeInLevel=currentNodeInLevel.below;
				}//while
				while(currentNodeInLevel.next!=null)
				{
					//Travesed to the last lower level and return false if the elemnent is not found
					int compareAtLastLevel=currentNodeInLevel.next.data.compareToIgnoreCase(key);
					if(compareAtLastLevel==0)
					{
						return true;
					}//if
					else
					{
						//Traversing the last lower level
						currentNodeInLevel=currentNodeInLevel.next;
					}//else

				}//while
				return false;
			}//if
			return false;
		} 
		catch (Exception e) 
		{
			return false;
		}
	}//find



}
