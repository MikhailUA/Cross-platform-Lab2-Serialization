package booklibrary;

import java.io.Serializable;

public class Author extends Human implements Serializable{	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Author(){};
	
	public Author(String firstname, String surname){
		super(firstname, surname);		
	}
	
}
