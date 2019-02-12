import kr.or.bit.*;

public class Hw01_Book {

	public static void main(String[] args) {
		Author author = new Author();
	
		author.name ="이힘찬";
		author.birth = "19930729";
		
		Publisher publisher = new Publisher();
		
		publisher.name = "비트";
		publisher.address = "강남";
		publisher.ceo = "??";
		
		
		Book book = new Book();
		
		book.author = author;
		book.publisher = publisher;
		book.bookName = "Java";
		book.bookPrice = 15000;
		book.bookmark = 125;
		
		System.out.println(book.getPublisher());
		System.out.println(book.publisher.name);
		System.out.println(book.author.birth);
		
		book.getInformation();
		book.getBookmark();
		
		book.setUser(null);
		
		

	}

}
