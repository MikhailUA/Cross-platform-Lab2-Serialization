package booklibraryTask3;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

public class Application{
		
	public static void main(String[] args) {
		
		ArrayList<Book> Bookstore = new ArrayList<Book>();
		Bookstore.add(new Book("book1"));
		Bookstore.add(new Book("book2"));
		Bookstore.add(new Book("book3"));
		Bookstore.add(new Book("book4"));
		
		ArrayList<BookReader> Readers = new ArrayList<BookReader>();
		Readers.add(new BookReader("reader1"));
		Readers.add(new BookReader("reader2"));
		Readers.add(new BookReader("reader3"));		
		
		Library library = new Library(Readers, Bookstore);
		
		System.out.println(library.toString());
		
		Scanner scn = new Scanner (System.in);
		int i;
		
		while(true){
			
			System.out.println("������� �������");
			System.out.println("0: ����� �� ���������\n"
					+ "1: �������� ������ ��������� ����\n"
					+ "2: �������� ������ ���������\n"
					+ "3: ������ ����� �������� (�������� �����, ��� ��������)\n"
					+ "4: �������� ������ �������� ����\n"
					+ "5: ������������� ������ ����������\n"
					+ "6: ������������ �� ����� ������ ����������");
			i = scn.nextInt();
						
			switch (i){
			
				case 0 :
					System.exit(0);
				break;
				
				case 1 :
					library.showAvailableBooks();
				break;		
				
				case 2 :
					library.showReaders();
				break;
				
				case 3 :
					String title = scn.next();
					String name = scn.next();
					library.giveBook(title, name);
				break;
				
				case 4 :
					library.showBooksOnHands();
				break;
				
				case 5 :
					LibraryDriver.serializeObject("libraryTask3.txt", library);
					break;
					
				case 6 :
					library = (Library) LibraryDriver.deSerializeObject("libraryTask3.txt");
					break;
			}
			
			
		}	
		
	}

}
