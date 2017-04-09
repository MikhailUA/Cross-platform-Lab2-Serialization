package booklibraryTask3;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class Library implements Externalizable{
	
	private ArrayList<Book> Bookstore;
	private ArrayList<BookReader> Readers;
	private ArrayList<BookOnHand> OnHands;
	
	public Library(){}
	
	public Library(ArrayList<BookReader> Readers, ArrayList<Book> Bookstore){
		this.Readers = Readers;
		this.Bookstore = Bookstore;
		
		this.OnHands = new ArrayList<BookOnHand>();
	}	
	
	@Override
	public void readExternal(ObjectInput in) throws IOException,
			ClassNotFoundException {
		
		int s = (int) in.readObject();
		this.Bookstore = new ArrayList<Book>(); 
		for (int i=0; i < s; i++){
			Book b = new Book();
			b.readExternal(in);
			Bookstore.add(b);
		}
		
		s = (int) in.readObject();
		this.Readers = new ArrayList<BookReader>();
		for (int i=0; i < s; i++){
			BookReader reader = new BookReader();
			reader.readExternal(in);
			Readers.add(reader);
		}
		
		s = (int) in.readObject();
		this.OnHands = new ArrayList<BookOnHand>();
		for (int i=0; i < s; i++){
			BookOnHand h = new BookOnHand();
			h.readExternal(in);
			OnHands.add(h);
		}
	}

	@Override
	public void writeExternal(ObjectOutput out) throws IOException {
		out.writeObject(Bookstore.size());
		for (Book b: Bookstore){
			b.writeExternal(out);
		}
		
		out.writeObject(Readers.size());
		for (BookReader r: Readers){
			r.writeExternal(out);
		}
		
		out.writeObject(OnHands.size());
		for (BookOnHand h : OnHands){
			h.writeExternal(out);
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
