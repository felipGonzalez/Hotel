package persistence;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

import model.Hotel;
import model.OpenForm;
import model.Site;



public class FileOption {

	private String filename;
	private File file;
	private RandomAccessFile randomAccessFile;
	private JFileChooser jFileChooser;
	private String pathName;
	
	public FileOption(String filename) {
		this.file = new File(filename);
	}
	public FileOption() {
		
	}
	
	public void openFile(){
		jFileChooser = new JFileChooser();
		jFileChooser.setApproveButtonText("Cargar");
		if (jFileChooser.showOpenDialog(null) == 0) {
			this.file = new File(jFileChooser.getSelectedFile() + "");
		}
	}
	
	public void savePaht() {
		jFileChooser = new JFileChooser();
		
		jFileChooser.setApproveButtonText("Guardar");
		jFileChooser.showSaveDialog(null);
		this.pathName = (jFileChooser.getSelectedFile()+"");
		
		if(!this.pathName.equals("")){
			delete(pathName);
			this.file = new File(pathName + "");
		}
	}
	
	public void open(OpenForm openForm) {
		try {
			this.randomAccessFile = new RandomAccessFile(file,
					(openForm == OpenForm.READ) ? "r" : "rw");
		} catch (FileNotFoundException ex) {
		}
	}

	public void close() {
		try {
			randomAccessFile.close();
		} catch (IOException ex) {
		}
	}

	
	public void delete(String pathName) {
		this.file = new File(pathName);
		this.open(OpenForm.WRITE);
		this.file.delete();
		this.close();
	}
	
	public String getAbreviate(String string){
		String abreviate ="";
		int count1= 0;
		int count2= 0;
		string = string.toUpperCase();
		abreviate+= string.charAt(count1);
		for (int i = 1; i < string.length(); i++) {
			if(count2 < 2){
				char j = string.charAt(i);
				if(j != 'A'&& j != 'E'&& j != 'I'&& j != 'O'&& j != 'U'){
					abreviate+= string.charAt(i);
					count2++;
				}
			}
		}
		
		return abreviate;
	}
	
	public void save(Site site, int index) {
		// convertir la logica a vinario
		DaoSite daoSite = new DaoSite(site);
		//System.out.println(daoSite.getCode());
		try {
			randomAccessFile.seek(index * daoSite.RECORD_SIZE);
			randomAccessFile.writeInt(daoSite.getCode());
			randomAccessFile.writeByte(daoSite.getLevel());
			randomAccessFile.write(daoSite.getName());// array
			randomAccessFile.write(daoSite.getAbreviate());// array
			randomAccessFile.writeLong(daoSite.getCodeParent()); // duplicidad
		} catch (IOException ex) {
		}
	}

	public Site load(int index) {
		DaoSite daoSite = new DaoSite();
		try {
			randomAccessFile.seek(index * daoSite.RECORD_SIZE);
			daoSite.setCode(randomAccessFile.readInt());
			daoSite.setLevel(randomAccessFile.readByte());
			byte[] data = new byte[daoSite.NAME_LENGHT];
			randomAccessFile.read(data);
			daoSite.setName1(data);// array
			data = new byte[daoSite.NAME_LENGHT];
			randomAccessFile.read(data);
			daoSite.setAbreviate1(data);// array
			daoSite.setCodeParent(randomAccessFile.readLong());
		} catch (IOException ex) {
		}
		return daoSite.getSite();
	}
	
	public boolean isSave() {
		if(file == null){
			return false;
		}
		return true;
	}

	
	public void saveHotel(Hotel hotel, int index) {
		DaoHotel daoHotel= new DaoHotel(hotel);
		try {
			randomAccessFile.seek(index * daoHotel.RECORD_SIZE);
			randomAccessFile.write(daoHotel.getName());// array
			randomAccessFile.write(daoHotel.getNamelarge());// array
			randomAccessFile.write(daoHotel.getAddress());
			randomAccessFile.write(daoHotel.getTelephone());
			randomAccessFile.write(daoHotel.getUrl());
			randomAccessFile.write(daoHotel.getEmail());
			} catch (IOException ex) {
		}
	}

	public Hotel loadHotel(int index) {
		DaoHotel daoHotel = new DaoHotel();
		try {
			randomAccessFile.seek(index * daoHotel.RECORD_SIZE);
			byte[] data = new byte[daoHotel.NAME_LENGHT];
			randomAccessFile.read(data);
			daoHotel.setNameArray(data);
			data = new byte[daoHotel.NAME_LARGE_LENGHT];
			randomAccessFile.read(data);
			daoHotel.setNamelargeArray(data);
			data = new byte[daoHotel.ADDRESS_LENGHT];
			randomAccessFile.read(data);
			daoHotel.setAddressArray(data);
			data = new byte[daoHotel.TELEPHONE_LENGHT];
			randomAccessFile.read(data);
			daoHotel.setTelephoneArray(data);
			data = new byte[daoHotel.URL_LENGHT];
			randomAccessFile.read(data);
			daoHotel.setUrlArray(data);
			data = new byte[daoHotel.EMAIL_LENGHT];
			randomAccessFile.read(data);
			daoHotel.setEmailArray(data);
			} catch (IOException ex) {
		}
		return daoHotel.getHotel();
	}
	
	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	/**
	 * ordena por el nombre, alfabeticamente ascendente burble....
	 */
	public void bubleSort() {
		this.open(OpenForm.WRITE);
		Site place1, place2;
		boolean isSorted = false;
		System.out.println("entro");
		while (!isSorted) {
			isSorted = true;
			for (int i = 0; i < this.file.length() / DaoSite.RECORD_SIZE - 1; i++) {
				System.out.println("entro");
				place1 = load(i);
				place2 = load(i + 1);
				if (place1.getName().compareTo(place2.getName()) > 0) {
					System.out.println("entro");
					this.save(place2, i);
					this.save(place1, i + 1);
					isSorted = false;
				}
			}

		}

		this.close();
	}

		
	public void ShellSort(){
		this.open(OpenForm.WRITE);
	    int gap = (int) (this.file.length() / DaoSite.RECORD_SIZE - 1/ 2);
	    Site place1, place2;
	    while (gap > 0) {
	        for (int i = 0; i < (this.file.length() / DaoSite.RECORD_SIZE - 1) - gap; i++) {
	            int j = i + gap;
	            place1 = load(j);
	            place2 = load(j + 1);
	            while (j >= gap && place1.getName().compareTo(place2.getName()) > 0) {//tmp < array[j-gap] otro orden
	            	this.save(load(j - 1), j); 
	                j -= gap;
	            }
	            this.save(place1 , j);  
	        }
	        if (gap == 2) {
	            gap = 1;
	        }else{
	            gap /= 2.2;
	        }
	    }
	    this.close();
	    
	}
}

//int[] ShellSort(int[] array){
//    int gap = array.length / 2;
//    while (gap > 0) {
//        for (int i = 0; i < array.length - gap; i++) {
//            int j = i + gap;
//            int tmp = array[j];
//            while (j >= gap && tmp > array[j - gap]) {//tmp < array[j-gap] otro orden
//                array[j] = array[j - gap];
//                j -= gap;
//            }
//            array[j] = tmp;
//        }
//        if (gap == 2) {
//            gap = 1;
//        }else{
//            gap /= 2.2;
//        }
//    }    
//    return array; 
//}

