

/*
 * author: Vali Shaik-B00835822
 * 
 * */
public class NodeLevels {

		//This field represent the list of keys in each level
		DoublyLinkedList purchase;
		//Link to the next and previous data items
		public NodeLevels up, below;

		NodeLevels(DoublyLinkedList purchase)
		{
			this.purchase=purchase;
		}//Node	

		public NodeLevels() {
			// TODO Auto-generated constructor stub
		}

		public void displayNodeData() {
			// TODO Auto-generated method stub
			System.out.println(purchase.toString()+"->");
			
		}

		public DoublyLinkedList getPurchase() {
			return purchase;
		}

		public void setPurchase(DoublyLinkedList purchase) {
			this.purchase = purchase;
		}

		public NodeLevels getUp() {
			return up;
		}

		public void setUp(NodeLevels up) {
			this.up = up;
		}

		public NodeLevels getBelow() {
			return below;
		}

		public void setBelow(NodeLevels below) {
			this.below = below;
		}
		
		
		
		
	}//class


