package persistence;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import model.Room;
import model.Site;

public class FileSite {

	private File file;// descriptor de archivos
	private FileInputStream fileInputStream;//archivo
	private FileOutputStream fileOutputStream;//archivo
	
	private ObjectOutputStream objectOutputStream;
	
	private ObjectInputStream objectInputStream;
	private OpenForm openForm;
	
	
	public FileSite(String fileName, OpenForm openForm) {
		this.file = new File(fileName);
		this.openForm = openForm;
	}

	public void open() {
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
	
	public void save(Site site) {
		try {
			objectOutputStream.writeObject(site);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	public Site read() {
		try {
			return (Site)objectInputStream.readObject();
		} catch (ClassNotFoundException e) {
			return null;
		} catch (IOException e) {
			return null;
		}
		
	}

	public OpenForm getOpenForm() {
		return openForm;
	}

	public void setOpenForm(OpenForm openForm) {
		this.openForm = openForm;
	}
	
}
