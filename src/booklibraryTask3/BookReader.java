package booklibraryTask3;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.io.Serializable;

public class BookReader implements Externalizable{
	
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

	@Override
	public void readExternal(ObjectInput in) throws IOException,
			ClassNotFoundException {
		name = (String) in.readObject();		
	}

	@Override
	public void writeExternal(ObjectOutput out) throws IOException {
		out.writeObject(name);
	}
	
}
