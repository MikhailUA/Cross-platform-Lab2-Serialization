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
	
	public void giveBook(String title, String name){
		
		Book book = getBookFromBookstore(title);
		BookReader reader= getReaderFromReadersList(name);
		
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
		for(Book b: this.Bookstore){
			System.out.println(b.getTitle());
		}
	}
	
	public void showReaders(){
		for(BookReader r: this.Readers){
			System.out.println(r.getName());
		}
	}
	
	public void showBooksOnHands(){
		for(BookOnHand b: this.OnHands){
			System.out.println(b.getTitle() + " " + b.getName());
		}
	}
	
	public Book getBookFromBookstore (String title){				
		for (Book b: this.Bookstore){
			if (b.getTitle().equals(title)){
				return b;
			}
		}		
		return null;
	}
	
	public BookReader getReaderFromReadersList (String name){
		for (BookReader r: this.Readers){
			if (r.getName().equals(name)){
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
				bookstore += b.toString();
			}
		}		
		
		if (Readers.isEmpty()){
			readers = "";
		}else{
			for(BookReader r: Readers){
				readers += r.toString();
			}
		}
		
		if (OnHands.isEmpty()){
			onHands = "";
		}else{
			for(BookOnHand onHand: OnHands){
				onHands += onHand.toString();
			}		
		}
		
		classRepresentation = bookstore + 
							  readers + 
							  onHands;
		
		return classRepresentation;		
	}
}
