package booklibraryTask3;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.io.Serializable;

public class BookReader extends Human implements Externalizable{
	
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

	@Override
	public void readExternal(ObjectInput in) throws IOException,
			ClassNotFoundException {
		id = (int) in.readObject();
		this.setFirstname((String) in.readObject());
		this.setSurname((String) in.readObject());

	}

	@Override
	public void writeExternal(ObjectOutput out) throws IOException {
		out.writeObject(id);
		out.writeObject(super.getFirstname());
		out.writeObject(super.getSurname());		
		
	}
	
}
