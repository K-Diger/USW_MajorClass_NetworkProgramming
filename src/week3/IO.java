package week3;

import java.io.*;

public class IO {

    public static void main(String[] args) throws IOException {
        ByteArrayOutputStream out = new ByteArrayOutputStream();

        System.out.println("before = " + out.size());

        // 개선방안
        byte[] code = new byte[50];

        // 비효율적, 개선방안? : byte [] 를 직접 넣어주기
        for (int i = 65; i < 91; i++) {
            // 개선방안
            code[i - 65] = (byte) i;

            // 기존 방안
            // out.write(i);
        }
        // 개선방안 -> 오버로딩된 write 사용하기 (기존 write() 는 지금 사용하는 메서드를 상속받아 사용하기때문에 느림)
        out.write(code, 0, code.length);

        System.out.println("after = " + out.size());
        System.out.println(out.toString());

    }
}
