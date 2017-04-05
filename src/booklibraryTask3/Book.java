package booklibraryTask3;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.io.Serializable;

public class Book implements Externalizable{
	
	private String title;

	public Book(){}
	
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

	@Override
	public void readExternal(ObjectInput in) throws IOException,
			ClassNotFoundException {
		title = (String) in.readObject();	
	}

	@Override
	public void writeExternal(ObjectOutput out) throws IOException {
		out.writeObject(title);
	}

}
