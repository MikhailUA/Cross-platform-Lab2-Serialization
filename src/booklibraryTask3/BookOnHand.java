package booklibraryTask3;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class BookOnHand implements Externalizable {
	private Book book;
	private BookReader reader;
	
	public BookOnHand(){}

	public BookOnHand(Book book, BookReader reader){
		this.book = book;
		this.reader = reader;
	}	

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public BookReader getReader() {
		return reader;
	}

	public void setReader(BookReader reader) {
		this.reader = reader;
	}

	public String toString(){
		String classRepresentation = "Книга " + this.book.toString() + " Выдана " + this.reader.toString() + "\n";
		return classRepresentation;	
	}

	@Override
	public void readExternal(ObjectInput in) throws IOException,
			ClassNotFoundException {
		book = new Book();
		book.readExternal(in);
		
		reader = new BookReader();
		reader.readExternal(in);
	}

	@Override
	public void writeExternal(ObjectOutput out) throws IOException {
		book.writeExternal(out);
		reader.writeExternal(out);
	}
}
