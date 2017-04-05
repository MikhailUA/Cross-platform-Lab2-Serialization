package booklibrary;

import java.io.Serializable;
import java.util.ArrayList;

public class Library implements Serializable{
	
	private ArrayList<Book> Bookstore;
	private ArrayList<BookReader> Readers;
	private ArrayList<BookOnHand> OnHands;
	
	public Library(){}
	
	public Library(ArrayList<BookReader> Readers, ArrayList<Book> Bookstore){
		this.OnHands = new ArrayList<BookOnHand>();
		
		this.Readers = Readers;
		this.Bookstore = Bookstore;
	}	
	
	public void giveBook(int bookId, int readerId){
		
		Book book = getBookFromBookstore(bookId);
		BookReader reader= getReaderFromReadersList(readerId);
		
		OnHands.add(new BookOnHand(book,reader));
		Bookstore.remove(book);

	}
	
	public void returnBook(Book title, BookReader reader){
		OnHands.remove(new BookOnHand(title, reader));
		Bookstore.add(title);
	}
	
	
	public void addBook(Book book){
		Bookstore.add(book);
	}
	
	public void registerBookreader(BookReader reader){
		Readers.add(reader);
	}
	
	public void showAvailableBooks(){
		for(Book b: Bookstore){
			System.out.println(b.toString());
		}
	}
	
	public void showReaders(){
		for(BookReader r: Readers){
			System.out.println(r.toString());
		}
	}
	
	public void showBooksOnHands(){
		for(BookOnHand b: OnHands){
			System.out.println(b.toString());
		}
	}
	
	public Book getBookFromBookstore (int id){				
		for (Book b: this.Bookstore){
			if (b.getId() == id){
				return b;
			}
		}		
		return null;
	}
	
	public BookReader getReaderFromReadersList (int id){
		for (BookReader r: Readers){
			if ( r.getId() == id ){
				return r;
			}
		}		
		return null;
	}
	
	public String toString(){		
		String classRepresentation = "";
		String bookstore = "Список книг:\n"; 
		String readers = "Список читателей:\n";
		String onHands = "Список выданных книг:\n";
		
		if (Bookstore.isEmpty()){
			bookstore = "";
		}else{
			for(Book b: Bookstore){
				bookstore += b.toString() + "\n";
			}
		}		
		
		if (Readers.isEmpty()){
			readers = "";
		}else{
			for(BookReader r: Readers){
				readers += r.toString() + "\n";
			}
		}
		
		if (OnHands.isEmpty()){
			onHands = "";
		}else{
			for(BookOnHand onHand: OnHands){
				onHands += onHand.toString() + "\n";
			}		
		}
		
		classRepresentation = bookstore + 
							  readers + 
							  onHands;
		
		return classRepresentation;		
	}
}
