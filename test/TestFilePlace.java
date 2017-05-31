package test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import model.OpenForm;
import model.Site;
import persistence.FileOption;

public class TestFilePlace {
    public static void main(String[] args) {
        try {
            Site place0=new Site(57,(byte)1,"Colombia","COL",null);
            FileOption filePlace = new FileOption("e:/Sitios/MySitios.xyz");
            filePlace.open(OpenForm.WRITE);
            filePlace.save(place0, 0); // PAIS.....
            FileReader fileReader = new FileReader("e:/Sitios/cd.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            FileReader fileReaderN = new FileReader("e:/Sitios/nD.txt");
            BufferedReader bufferedReaderN = new BufferedReader(fileReaderN);
            
            FileReader fileReaderC = new FileReader("e:/Sitios/cm.txt");
            BufferedReader bufferedReaderC = new BufferedReader(fileReaderC);
            FileReader fileReaderM = new FileReader("e:/Sitios/nM.txt");
            BufferedReader bufferedReaderM = new BufferedReader(fileReaderM);
            int r = 1;
            int code = 0; // 
            Site placeD = null;
            Site placeM = null;
            do {
               int codeD = Integer.parseInt(bufferedReader.readLine());
               String nameD = bufferedReaderN.readLine();
               int codeM = Integer.parseInt(bufferedReaderC.readLine());
               String nameM = bufferedReaderM.readLine();
               if (code!=codeD) {              
                  System.out.println("*"+codeD+" - "+nameD+" 57");
                  placeD=new Site(codeD,(byte)2,nameD,filePlace.getAbreviate(nameD),place0);
                  filePlace.save(placeD,r);
                  code = codeD;
                  r++;
               }   
               System.out.println(" "+codeM+" - "+nameM+" "+code);
               placeM=new Site(codeM,(byte)3,nameM,filePlace.getAbreviate(nameM),placeD);
               filePlace.save(placeM,r);
               r++;
            } while (r<1126);
            bufferedReaderM.close();
            fileReaderM.close();
            bufferedReaderC.close();
            fileReaderC.close();
            bufferedReaderN.close();
            fileReaderN.close();
            bufferedReader.close();
            fileReader.close();
            filePlace.close();
            // leer .................
            filePlace.open(OpenForm.READ);
            Site place;
            for (int i = 0; i < 2; i++) {
                place = filePlace.load(i);
                System.out.println("Registro : "+i);
                System.out.println("Codigo : "+place.getCode());
                System.out.println("Nivel : "+place.getLevel());
                System.out.println("Nombre : "+place.getName());
                System.out.println("Abreviado : "+place.getAbreviate());
                System.out.println("Parent  : "+place.getParent());
                //System.out.println("codigo completo  : "+place.getfullCode());
            }     
            filePlace.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(TestFilePlace.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(TestFilePlace.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
        }
    }    
}
