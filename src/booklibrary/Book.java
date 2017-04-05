package booklibrary;

import java.io.Serializable;

public class Book implements Serializable {
	
	private String title;
	//private Author author;

	public Book(String title) {
		this.title = title;
	}

	public String getTitle() {
		return this.title;
	}
	
	public void setTitle(String title){
		this.title = title;
	}
	
	public String toString(){		
		String classRepresentation = "Название книги: " + this.title + "\n";
		return classRepresentation;
	}

}
