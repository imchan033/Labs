package linkedlist;

// list�� node Ŭ����
public class Node{		
		
		private Object data;	// node�� data
		private Node nextNode;	// node�� ���� ���(����)
		
		public Node(Object data){		// ����� data�� ���� ��� �ʱ�ȭ
			
			this.data = data;
			this.nextNode = null;
		}

		public Object getData() {
			return data;
		}

		public void setData(Object data) {
			this.data = data;
		}

		public Node getNextNode() {
			return nextNode;
		}

		public void setNextNode(Node nextNode) {
			this.nextNode = nextNode;
		}
		
	
	
}