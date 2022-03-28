package Project_Essential;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;

public class AppendFileUsingBufferReader {
    public static void main(String[] args) {
        String text = "Mahmud Rayhan";
        try {
            File f=new File("AppendUsingBuffer.txt");
            FileWriter fw=new FileWriter(f,true);
            BufferedWriter bw = new BufferedWriter(fw);


            bw.write(text);
            bw.write("\n");
            bw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
