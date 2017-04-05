package booklibraryTask2;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class Library implements Serializable{
	
	transient private ArrayList<Book> Bookstore;
	transient private ArrayList<BookReader> Readers;
	transient private ArrayList<BookOnHand> OnHands;
	
	public Library(){}
	
	public Library(ArrayList<BookReader> Readers, ArrayList<Book> Bookstore){
		this.OnHands = new ArrayList<BookOnHand>();
		
		this.Readers = Readers;
		this.Bookstore = Bookstore;
	}	
	
	
	private void writeObject(ObjectOutputStream out) throws IOException{
		out.defaultWriteObject();
		out.writeInt(Readers.size());
		for(BookReader r : Readers){
			out.writeObject(r.getName());			
		}
		
		out.writeInt(Bookstore.size());
		for(Book b : Bookstore){
			out.writeObject(b.getTitle());
		}
		
		out.writeInt(OnHands.size());
		for (BookOnHand b : OnHands){
			out.writeObject(b.getTitle());
			out.writeObject(b.getName());
		}
	}
	
	private void readObject(ObjectInputStream in) throws ClassNotFoundException, IOException{
		in.defaultReadObject();
		Readers = new ArrayList<>();
		int size = in.readInt();
		for (int i = 0; i < size; i++){
			BookReader reader = new BookReader((String) in.readObject());
			Readers.add(reader);
		}
		
		Bookstore = new ArrayList<>();
		int bookStoreSize = in.readInt();
		for (int i = 0; i < bookStoreSize; i++){
			Book b = new Book ((String) in.readObject());
			Bookstore.add(b);
		}
		
		OnHands = new ArrayList<>();
		int onHandsSize = in.readInt();
		for (int i = 0; i < onHandsSize; i++){
			Book book = new Book((String) in.readObject());
			BookReader reader = new BookReader((String) in.readObject());
			BookOnHand b = new BookOnHand(book, reader);			
		}
		
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
