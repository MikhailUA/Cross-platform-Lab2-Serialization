package booklibraryTask3;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public class Author extends Human implements Externalizable{
	
	public Author(){};
	
	public Author(String firstname, String surname){
		super(firstname, surname);		
	}

	@Override
	public void readExternal(ObjectInput in) throws IOException,
			ClassNotFoundException {
		this.setFirstname( (String)in.readObject() );
		this.setSurname( (String)in.readObject() );		
	}

	@Override
	public void writeExternal(ObjectOutput out) throws IOException {
		out.writeObject(firstname);
		out.writeObject(surname);
	}
	
}
