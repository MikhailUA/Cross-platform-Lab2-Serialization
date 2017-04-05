package booklibraryTask2;

import java.io.Serializable;

public class BookReader{
	
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
