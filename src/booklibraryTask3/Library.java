package booklibraryTask3;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.io.Serializable;
import java.util.ArrayList;

public class Library implements Externalizable{
	
	private ArrayList<Book> Bookstore;
	private ArrayList<BookReader> Readers;
	private ArrayList<BookOnHand> OnHands;
	
	public Library(){System.out.println("constr");}
	
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
		String bookstore = "������ ����:\n"; 
		String readers = "������ ���������:\n";
		String onHands = "������ �������� ����:\n";
		
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

	@Override
	public void readExternal(ObjectInput in) throws IOException,
			ClassNotFoundException {
		System.out.println("readEx");
		Bookstore = new ArrayList<Book>();
		System.out.println("readEx2");
		int bookstoreSize = in.readInt();
		System.out.println("readEx3");
		for (int i = 0; i < bookstoreSize; i++){
			Book book = new Book();
			book.readExternal(in);
			Bookstore.add(book);
		}
		
		Readers = new ArrayList<>();
		int readersSize = in.readInt();
		for (int i = 0; i < readersSize; i++){
			BookReader bookreader = new BookReader();
			bookreader.readExternal(in);
			Readers.add(bookreader);
		}
		
		OnHands = new ArrayList<>();
		int onhandsSize = in.readInt();
		for (int i = 0; i < onhandsSize; i++){
			BookOnHand bookonhand = new BookOnHand();
			bookonhand.readExternal(in);
			OnHands.add(bookonhand);
		}
				
	}

	@Override
	public void writeExternal(ObjectOutput out) throws IOException {
		
		out.writeInt(Bookstore.size());
		for (Externalizable b : Bookstore){
			b.writeExternal(out);
		}
		
		out.writeInt(Readers.size());
		for (Externalizable r : Readers){
			r.writeExternal(out);
		}
				
		out.writeInt(OnHands.size());
		for (Externalizable h : OnHands){
			h.writeExternal(out);
		}
		
	}
}
