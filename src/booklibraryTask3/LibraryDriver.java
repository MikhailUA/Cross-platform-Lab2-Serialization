package booklibraryTask3;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class LibraryDriver {

	public static void serializeObject (String fileName, Object obj){
		try{
			ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName));
			out.writeObject(obj);
			out.close();
		}catch(IOException e){
			e.printStackTrace();
		}		
	}
	
	public static Object deSerializeObject (String fileName){
		Object obj = null;
		
		try{
			ObjectInputStream is = new ObjectInputStream(new FileInputStream(fileName));
			obj = is.readObject();
			is.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return obj;
	}
}
