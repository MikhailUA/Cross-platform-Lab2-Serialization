package booklibraryTask3;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

public class Application{
		
	public static void main(String[] args) {
		
		ArrayList<Book> Bookstore = new ArrayList<Book>();
		Bookstore.add(new Book(1, "book1", new Author("first1", "surname2")));
		Bookstore.add(new Book(2, "book2", new Author("first3", "surname1")));
		Bookstore.add(new Book(3, "book3", new Author("first4", "surname5")));
		Bookstore.add(new Book(4, "book4", new Author("first1", "surname3")));
		
		ArrayList<BookReader> Readers = new ArrayList<BookReader>();
		Readers.add(new BookReader(1, "reader1" , "surn9"));
		Readers.add(new BookReader(2, "reader2" , "surn10"));
		Readers.add(new BookReader(3, "reader3" , "surn11"));		
		
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
					System.out.println("������� id �����");
					int bookId = scn.nextInt();
					System.out.println("������� id ��������");
					int readerId = scn.nextInt();
					library.giveBook(bookId, readerId);
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
