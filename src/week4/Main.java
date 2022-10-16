package week4;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        byte[] testBytes = new byte[99999999];
        byte[] temp = new byte[3];
        byte[] original = new byte[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9};


        ByteArrayInputStream in = new ByteArrayInputStream(original);
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        int data = 0;


        // data = in.read()) != -1 -> in.read() 가 마지막 바이트까지 읽으면 -1 을 반환한다.
        // in.available() 내가 몇개를 읽을 수 있는지
        while (true) {
            if (in.available() > temp.length) {
                in.read(temp);
                System.out.println("temp = " + Arrays.toString(temp));
                out.write(temp);
            }
            else if (in.available() < temp.length) {
                System.out.println("in.available = " + in.available());
                in.read();
                byte [] newTemp = new byte [in.available()];
                out.write(newTemp);
                break;
            }
            else if (in.available() == 0) {
                break;
            }

        }

        System.out.println(Arrays.toString(out.toByteArray()));
    }
}
