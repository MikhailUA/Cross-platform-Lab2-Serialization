package booklibrary;

import java.io.Serializable;

public class BookOnHand implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Book title;
	private BookReader reader;
	
	public BookOnHand(){}

	public BookOnHand(Book title, BookReader reader){
		this.title = title;
		this.reader = reader;
	}

	public String getTitle() {
		return this.title.getTitle();
	}

	public String getName() {
		return this.reader.getName();
	}
	
	public String toString(){
		String classRepresentation = "Книга " + this.title.toString() + " Выдана " + this.reader.toString() + "\n";
		return classRepresentation;		
	}

}
