package booklibraryTask2;

public class Book{
	
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

}
