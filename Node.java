public class Node {
	
		//Name of the purchased item
		String data;
		//Link to the next and previous data items
		Node next, previous,up,below;

		Node(String data)
		{
			this.data=data;
		}//Node	

		public Node() {
			// TODO Auto-generated constructor stub
		}

		public void displayNodeData() {
			// TODO Auto-generated method stub
			System.out.println(data+"->");
			
		}

		@Override
		public String toString() {
			return "Node [data=" + data + "]";
			//, next=" + next + ", previous=" + previous + "]";
		}
		
	}//classx
