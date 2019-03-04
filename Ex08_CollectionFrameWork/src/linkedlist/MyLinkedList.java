package linkedlist;
// LinkedList ��ü
public class MyLinkedList {	
	
	private Node header;	// list�� header
	private int size;		// list�� size
	
	// ����Ʈ�� header, size �ʱ�ȭ
	public MyLinkedList(){
		header = new Node(null);	
		size = 0;
	}
	
	// ����� ������ ����
	public Object getNodeData(int index){
	       return getNode(index).getData();
	}
	// ��� getter
	private Node getNode(int index){
		
		if(index < 0 || index >= size){
			throw new IndexOutOfBoundsException("Index : " + index + ", Size : " + size);
		}
		
		Node node = header.getNextNode();
		for(int i =0; i < index; i++){
			node = node.getNextNode();
		}
		
		return node;
	}
	
	
	/*public Object getFirst(){
		return get(0);
	}*/
	
	
	public int getNodeIndex(Object obj){
		
		if(size<=0){
			return -1;
		}
		
		int index=0;
		Node node = header.getNextNode();
		Object nodeData = node.getData();
		
		
		while(!obj.equals(nodeData)){
			node = node.getNextNode();
			
			if(node==null){
				return -1;
			}
			
			nodeData = node.getData();
			index++;
		}
		
		return index;
	}
	
	// ----------------------------------------------- ����
	// ����Ʈ ó���� ����
	public void addFirst(Object data){
		
		Node newNode = new Node(data);
		newNode.setNextNode(header.getNextNode());
		header.setNextNode(newNode);
		size++;
		
	}
	
	// ����Ʈ �߰��� ����
	public void addAtmiddle(int index, Object data){
		
		if(index==0){		// index �� 0 �̸�
			addFirst(data);	// ����Ʈ ó���� ����
			return;			// 
		}
		
		Node previous = getNode(index-1);
		Node nextnode = previous.getNextNode();
		
		Node newNode = new Node(data);
		previous.setNextNode(newNode);
		newNode.setNextNode(nextnode);
		size++;
	}
	
	// ����Ʈ ���� ����
	public void addLast(Object data){
		addAtmiddle(size, data);
	}
	
	
	/*// ���� �ֱ�
	public void add(Object data){
		addLast(data);
	}*/
	
	// ----------------------------------------------- ����
	// ����Ʈ ó���� ����
	public Object removeFirst(){
		
		Node firstNode = getNode(0);
		header.setNextNode(firstNode.getNextNode()); 
		size--;
		return firstNode.getData();
		
	}
	
	// ����Ʈ �߰��� ����
	public Object removeAtmiddle(int index){
		
		if(index<0 || index>=size){
			
			throw new IndexOutOfBoundsException("Index : " + index + ", Size : " +size);
		
		}else if(index ==0){
			
			return removeFirst();
		
		}
		
		Node previous = getNode(index-1);
		Node removeNode = previous.getNextNode();
		Node next = removeNode.getNextNode();
		previous.setNextNode(next);
		size--;
		
		return removeNode.getData();
	}
	
	//????? �����͸� �Է��ؼ� ���� 
	public void removeByData(Object data){
		
		int nodeIndex = getNodeIndex(data);
		
		if(nodeIndex == -1){
			System.out.println("no data");
			
		}else{
			removeAtmiddle(nodeIndex);
			
		}
	}
	
	// ����Ʈ �������� ����
	public Object removeLast(){
		return removeAtmiddle(size-1);
	}
	
	
	public int getListsize(){
		return size;
	}
	
	
	public String toString(){
		
		StringBuffer result = new StringBuffer("[");
		Node node = header.getNextNode();
		
		if(node!=null){
			result.append(node.getData());
			node = node.getNextNode();
			
			while(node != null){
				result.append(", ");
				result.append(node.getData());
				node = node.getNextNode();
			}
		}
		
		result.append("]");
		return result.toString();
	}

}
