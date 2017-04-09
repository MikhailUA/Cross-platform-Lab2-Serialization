package booklibraryTask2;

import java.io.Serializable;

public class BookOnHand implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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
}
