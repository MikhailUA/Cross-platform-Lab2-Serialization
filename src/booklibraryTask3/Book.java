package booklibraryTask3;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public class Book implements Externalizable{
	
	private int id;
	private String title;
	private Author author;

	public Book() {}
	
	public Book(int id, String title, Author author) {
		this.id = id;
		this.title = title;
		this.author = author;
	}

	public String getTitle() {
		return this.title;
	}
	
	public void setTitle(String title){
		this.title = title;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	public String toString(){		
		String classRepresentation = "id:" + id
								   + " Название книги: " + title + " "
								   + " Автор: " + author.firstname + " " + author.surname;
		return classRepresentation;
	}

	@Override
	public void readExternal(ObjectInput in) throws IOException,
			ClassNotFoundException {
		this.setId( (Integer) in.readObject() );
		this.setTitle( (String) in.readObject() );
		Author a = new Author();
		a.readExternal(in);
		this.setAuthor(a);
	}

	@Override
	public void writeExternal(ObjectOutput out) throws IOException {
		out.writeObject(id);		
		out.writeObject(title);
		author.writeExternal(out);
	}

}
