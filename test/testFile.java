package test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class testFile {

	public static void main(String[] args) {
		try {
			RandomAccessFile randomAccessFile = new RandomAccessFile("e:/prueba/test.xyz", "rw");
			randomAccessFile.writeChars("felipe");
			randomAccessFile.close();
			
			RandomAccessFile randomAccessFileWrite = new RandomAccessFile("e:/prueba/test.xyz", "r");
			System.out.println("Leido " + randomAccessFileWrite.readChar());
			System.out.println("Leido " + randomAccessFileWrite.readChar());
			System.out.println("Leido " + randomAccessFileWrite.readChar());
			randomAccessFileWrite.close();
		} catch (IOException e) {

		}
	}

}
