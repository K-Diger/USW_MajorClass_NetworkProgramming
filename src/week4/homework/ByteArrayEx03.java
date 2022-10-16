package week4.homework;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class ByteArrayEx03 {
    public static void main(String[] args) throws IOException {
        byte[] original = new byte[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        byte[] copy = null;
        byte[] temp = new byte[4];

        ByteArrayInputStream in = new ByteArrayInputStream(original);
        ByteArrayOutputStream out = new ByteArrayOutputStream();

        System.out.println("[Original Data] : " + Arrays.toString(original));
        System.out.println("--------------------------------------------------");

        int originalLength = original.length;
        while (in.available() > 0) {
            // 220924 - 과제 시작
            if (in.available() < 4) {
                byte[] customByteArray = new byte[in.available()];
                for (int i = originalLength - in.available(); i < originalLength; i++) {
                    out.write(original[i]);
                    customByteArray[i - originalLength + in.available()] = original[i];
                }
                System.out.println("[Custom TempArray Data In Try Catch In if] : " + Arrays.toString(customByteArray));
                copy = out.toByteArray();
                printArrays(customByteArray, copy);
                break;
            }
            // 220924 - 과제 종료
            else {
                in.read(temp);
                out.write(temp);

                System.out.println("[Temp Data In Try Catch In else] : " + Arrays.toString(temp));
                copy = out.toByteArray();
                printArrays(temp, copy);
            }
        }
    }

    public static void printArrays(byte[] temp, byte[] copy) {
        System.out.println("[Temp Data] : " + Arrays.toString(temp));
        System.out.println("[copy Data] : " + Arrays.toString(copy));
        System.out.println("--------------------------------------------------");
    }
}

