package week4;

import java.io.*;
import java.util.*;

public class FileStream {

    // 한글 테스트
    public static void main(String[] args) throws IOException {
        String createFilePath = "E:\\Priority\\Development\\SourceCode\\Backend\\NetworkProgramming-USW-22-2-MajorClass\\src\\week5\\static\\test.jpg";
//        try {
//            File file = new File(createFilePath);
//            file.createNewFile();
//        }
//        catch (IOException e) {
//            e.printStackTrace();
//        }

        // FileOutputStream out = new FileOutputStream(createFilePath);
        // for (int i = 65; i < 91; i++) out.write((char) i);


        // FileInputStream in = new FileInputStream(createFilePath);
        FileReader inFileReader = new FileReader(createFilePath);
        int data = 0;
        while ((data = inFileReader.read()) != -1) {
            // System.out.print((char) in.read());
            System.out.print((char) data);
        }
    }
}
