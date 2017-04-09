package booklibrary;

import java.io.Serializable;

public class Book implements Serializable {	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private Author author;
	private String title;

	public Book(int id, String title, Author author) {
		this.id = id;
		this.title = title;
		this.author = author;
	}

	public String getTitle() {
		return this.title;
	}
	
	public void setTitle(String title){
		this.title = title;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String toString(){		
		String classRepresentation = "id:" + id
								   + " Название книги: " + title + " "
								   + " Автор: " + author.firstname + " " + author.surname;
		return classRepresentation;
	}

}
