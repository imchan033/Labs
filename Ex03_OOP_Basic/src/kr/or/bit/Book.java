package kr.or.bit;

public class Book {
	
	public String bookName;		//책이름
	public String bookPage;		//페이지
	public int ISBN; 			//국제표준도서번호
	public int bookPrice;		//책가격
	public int bookDate;		//출판일
	
	public String user;			//사용자
	public int currentPage;		//페이지
	public int bookmark;		//북마크
	
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
		if(user==null) {           //사용자가 null일때
			this.user="주인없음";
		}else {
			this.user = user;
		}
	}
	
	public void setCurrentPage(int currentPage) {
		if(currentPage<0) {		 //음수값일때 1페이지로
			this.currentPage=1;
		}else {
			this.currentPage = currentPage;
		}
	}
	
	public void getInformation() {
		System.out.println("책이름 : "+this.bookName+" 저자 : "+author.name);
	}
	
	public void getBookmark() {
		System.out.println("저장된 북마크는 "+this.bookmark+"page 입니다.");		
	}
	
}
