package week3;

import java.io.FileInputStream;
import java.io.FileOutputStream;

// File : README.md 를 사용

public class FileStreamIO {

    public static void main(String[] args) throws Exception {
        FileInputStream fis1 = new FileInputStream("E:\\Priority\\Development\\SourceCode\\Backend\\NetworkProgramming-USW-22-2-MajorClass\\src\\week3\\static\\wallpaperbetter.com_2560x1600.jpg");
        FileInputStream fis2 = new FileInputStream("E:\\Priority\\Development\\SourceCode\\Backend\\NetworkProgramming-USW-22-2-MajorClass\\src\\week3\\static\\README.md");

        // System.out.println(Arrays.toString(fis1.readAllBytes()));
        // System.out.println(Arrays.toString(fis2.readAllBytes()));

        FileOutputStream fos1 = new FileOutputStream("E:\\Priority\\Development\\SourceCode\\Backend\\NetworkProgramming-USW-22-2-MajorClass\\src\\week3\\test.jpg");
        FileOutputStream fos2 = new FileOutputStream("E:\\Priority\\Development\\SourceCode\\Backend\\NetworkProgramming-USW-22-2-MajorClass\\src\\week3\\fis2Stream.md");

        int data1 = 0;
        while ((data1 = fis1.read()) != -1) {
            fos1.write(data1);
        }

        int data2 = 0;
        while ((data2 = fis2.read()) != -1) {
            fos2.write(data2);
        }
    }
}