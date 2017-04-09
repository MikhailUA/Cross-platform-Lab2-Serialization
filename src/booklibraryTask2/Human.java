package booklibraryTask2;


abstract public class Human{
	public String firstname;
	public String surname;
	
	public Human(){};
	
	public Human(String firstname, String surname){
		this.firstname = firstname;
		this.surname = surname;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}
	
	
}
