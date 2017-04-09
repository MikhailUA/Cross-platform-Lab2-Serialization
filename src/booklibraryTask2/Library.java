package booklibraryTask2;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class Library implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	transient private ArrayList<Book> Bookstore;
	transient private ArrayList<BookReader> Readers;
	transient private ArrayList<BookOnHand> OnHands;
	
	public Library(){}
	
	public Library(ArrayList<BookReader> Readers, ArrayList<Book> Bookstore){
		this.Readers = Readers;
		this.Bookstore = Bookstore;
		
		this.OnHands = new ArrayList<BookOnHand>();
	}	
	
	private void writeObject(ObjectOutputStream out) throws IOException{
		
		out.defaultWriteObject();
		
		out.writeObject(Readers.size());
		for(BookReader r : Readers){			
			out.writeObject(r.getId());
			out.writeObject(r.getFirstname());
			out.writeObject(r.getSurname());
		}
		
		out.writeObject(Bookstore.size());
		for(Book b : Bookstore){
			out.writeObject(b.getId());
			out.writeObject(b.getTitle());
			out.writeObject(b.getAuthor().firstname);
			out.writeObject(b.getAuthor().surname);
		}
		
		out.writeObject(OnHands.size());
		for (BookOnHand b : OnHands){
			Book book = b.getBook();
			out.writeObject(book.getId());
			out.writeObject(book.getTitle());
			out.writeObject(book.getAuthor().firstname);
			out.writeObject(book.getAuthor().surname);
						
			BookReader reader = b.getReader();
			out.writeObject(reader.getId());
			out.writeObject(reader.firstname);
			out.writeObject(reader.surname);
		}			
			
	}
	
	private void readObject(ObjectInputStream in) throws ClassNotFoundException, IOException{
		in.defaultReadObject();
		
		Readers = new ArrayList<>();
		int size = (Integer) in.readObject();
		for (int i = 0; i < size; i++){
			BookReader reader = new BookReader();
			reader.setId((Integer)in.readObject());
			reader.setFirstname((String) in.readObject());
			reader.setSurname((String) in.readObject());
			Readers.add(reader);
		}
		
		Bookstore = new ArrayList<>();
		int bookStoreSize = (Integer) in.readObject();
		for (int i = 0; i < bookStoreSize; i++){
			Book b = new Book ();
			b.setId((Integer)in.readObject());
			b.setTitle((String)in.readObject());
			b.setAuthor(new Author((String) in.readObject(), (String) in.readObject()));
			Bookstore.add(b);
		}
		
		OnHands = new ArrayList<>();
		int onHandsSize = (Integer)in.readObject();
		for (int i = 0; i < onHandsSize; i++){
			Book b = new Book ();
			b.setId((Integer)in.readObject());
			b.setTitle((String)in.readObject());
			b.setAuthor(new Author((String) in.readObject(), (String) in.readObject()));			
			BookReader reader = new BookReader((Integer)in.readObject(), (String) in.readObject(), (String) in.readObject());
		
			BookOnHand bookOnHand = new BookOnHand(b, reader);			
		}
		
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
