package booklibrary;

import java.io.Serializable;

public class BookReader extends Human implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	
	public BookReader(){}
	
	public BookReader(int id, String name, String surname){
		super(name, surname);
		this.id = id;
	}

	public String getName(){
		return this.firstname;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String toString(){
		String classRepresentation = "id:" + id
								   + " Имя читателя: " + firstname + " Фамилия: " + surname;
		return classRepresentation;
	}
	
}
