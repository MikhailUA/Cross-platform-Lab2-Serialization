package booklibraryTask3;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.io.Serializable;

public class BookOnHand implements Externalizable {
	private Book title;
	private BookReader reader;
	
	public BookOnHand(){}

	public BookOnHand(Book title, BookReader reader){
		this.title = title;
		this.reader = reader;
	}

	public String getTitle() {
		return this.title.getTitle();
	}

	public String getName() {
		return this.reader.getName();
	}
	
	public String toString(){
		String classRepresentation = "Книга " + this.title.toString() + " Выдана " + this.reader.toString() + "\n";
		return classRepresentation;		
	}

	@Override
	public void readExternal(ObjectInput in) throws IOException,
			ClassNotFoundException {
		title = new Book();
		title.readExternal(in);
		
		reader = new BookReader();
		reader.readExternal(in);
		
	}

	@Override
	public void writeExternal(ObjectOutput out) throws IOException {
		title.writeExternal(out);
		reader.writeExternal(out);
		
	}
	
	

}
