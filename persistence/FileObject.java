package persistence;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * 
 * @author RA302
 *Clasa parametrisadas o genericas
 * @param <T>
 */
public class FileObject <T>{

	private File file;// descriptor de archivos
	private FileInputStream fileInputStream;//archivo
	private FileOutputStream fileOutputStream;//archivo
	
	private ObjectOutputStream objectOutputStream;
	
	private ObjectInputStream objectInputStream;
	private OpenForm openForm;
		
	public FileObject(String fileName) {
		this.file = new File(fileName);
	}

	public void open(OpenForm openForm) {
		this.openForm = openForm;
		try {
			switch (this.openForm) {
			
			
			case WRITE:
				fileOutputStream = new FileOutputStream(file);
				objectOutputStream = new ObjectOutputStream(fileOutputStream);
				
				break;
			case READ:
				fileInputStream = new FileInputStream(file);
				objectInputStream = new ObjectInputStream(fileInputStream);
				break;
			case APPEND:
				fileOutputStream = new FileOutputStream(file, true);
				objectOutputStream = new ObjectOutputStream(fileOutputStream);
				break;	
			default:
				break;
			}
		} catch (IOException e) {
			System.out.println("existe un error al abrir");
		}
	}
	
	public void close() {
		try {
			switch (this.openForm) {
			case WRITE:
			case APPEND:
				objectOutputStream.close();
				fileOutputStream.close();
				break;
			case READ:
				objectInputStream.close();
				fileInputStream.close();
				break;
			default:
				break;
			}
		} catch (IOException e) {
			System.out.println("existe un error al cerrar");
		}
	}
	
	public void save(T object) {
		try {
			objectOutputStream.writeObject(object);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public T read() {
		try {
			return (T)objectInputStream.readObject();
		} catch (ClassNotFoundException e) {
			return null;
		} catch (IOException e) {
			return null;
		}
	}
}
