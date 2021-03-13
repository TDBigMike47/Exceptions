package org.example;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.Scanner;
/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {

        File newFile;
        newFile = new File("Ejercicio.txt");
        createFile(newFile);
        writeContent(newFile,"Writting testing");
        readContent(newFile);

        //Path
        String path = "";
        boolean bool =false;
        try{
            bool = newFile.exists();
            if(bool){
                path = newFile.getAbsolutePath();
                System.out.println("Absolute Pathname: "+ path);
            }
        }catch (Exception e){
            System.out.println("An error occurred: " + e);
        }


    }

    public static void createFile(File newFile){
        try{
            if (newFile.createNewFile()){
                System.out.println("File created" + newFile.getName());
            }

        }catch (IOException e){
            System.out.println("An error occurred: " + e);

        }

    }

    public static  void writeContent(File newFile, String contents){
        FileWriter writer = null;
        try{
            writer = new FileWriter(newFile);
            writer.write(contents);
            writer.close();
        }catch (IOException e){
            System.out.println("An error occurred while writting: "+e.getMessage());
        }
    }

    public  static void readContent(File newFile){
        try{
            Scanner myReader = new Scanner(newFile);
            while(myReader.hasNextLine()){
                String data = myReader.nextLine();
                System.out.println(data);
            }
            myReader.close();
        }catch (FileNotFoundException e){
            System.out.println("An error occurred while reading the file: "+ e.getMessage());
        }

    }
}
