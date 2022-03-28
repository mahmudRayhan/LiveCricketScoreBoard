package Project_Essential;

import java.io.*;

public class Write_AppendFile {
    public static void main(String[] args) {
        try{
            //Here FileWriter is enough to write
            //We Use File and BufferWriter to add the function
            File myFile=new File("Mahmud.txt");
            FileWriter fw=new FileWriter(myFile,true);
            BufferedWriter bw=new BufferedWriter(fw);
            PrintWriter pw=new PrintWriter(bw);

            int a=90;

            if(myFile.exists()==false){
                myFile.createNewFile();
                System.out.println("The File has been created");;
            }else{
                System.out.println("The file is already exists");
            }
            pw.println("I am Shajib");
            pw.println("I read in CSE,Dept");
            pw.println("I read in Buet "+a);

            pw.close();
        }catch(IOException e){
            System.out.println("Error");
        }
    }
}
