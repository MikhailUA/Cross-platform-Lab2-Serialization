package booklibrary;

import java.io.Serializable;

public class Author extends Human implements Serializable{
	
	public Author(){};
	
	public Author(String firstname, String surname){
		super(firstname, surname);		
	}
	
}
