package booklibrary;

import java.io.Serializable;

public class BookReader extends Human implements Serializable{
	
	private String name;
	
	public BookReader(){}
	
	public BookReader(String name){
		this.name = name;
	}

	public String getName(){
		return this.name;
	}

	public String toString(){
		String classRepresentation = "Имя читателя: " + this.name + "\n";
		return classRepresentation;
	}
	
}
