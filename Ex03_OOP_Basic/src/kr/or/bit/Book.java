package kr.or.bit;

public class Book {
	
	public String bookName;		//å�̸�
	public String bookPage;		//������
	public int ISBN; 			//����ǥ�ص�����ȣ
	public int bookPrice;		//å����
	public int bookDate;		//������
	
	public String user;			//�����
	public int currentPage;		//������
	public int bookmark;		//�ϸ�ũ
	
	public Publisher publisher;
	public Author author;
	
	
	
	public Publisher getPublisher() {
		return publisher;
	}

	public void setPublisher(Publisher publisher) {
		this.publisher = publisher;
	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	public void setUser(String user) {
		if(user==null) {           //����ڰ� null�϶�
			this.user="���ξ���";
		}else {
			this.user = user;
		}
	}
	
	public void setCurrentPage(int currentPage) {
		if(currentPage<0) {		 //�������϶� 1��������
			this.currentPage=1;
		}else {
			this.currentPage = currentPage;
		}
	}
	
	public void getInformation() {
		System.out.println("å�̸� : "+this.bookName+" ���� : "+author.name);
	}
	
	public void getBookmark() {
		System.out.println("����� �ϸ�ũ�� "+this.bookmark+"page �Դϴ�.");		
	}
	
}
