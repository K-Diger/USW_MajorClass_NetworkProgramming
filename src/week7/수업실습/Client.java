package week7.수업실습;

import java.io.*;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws IOException {

        // 클라이언트 소켓 (서버 주소, 서버 포트, 내 주소(null 시 자동으로 내 주소가 들어가긴함), 내 포트)
        // Socket clientSocket = new Socket("172.16.36.30", 3000, null, 5000);
        Socket clientSocket = new Socket("172.16.36.30", 3000);
        System.out.println("Is Socket Available? : " + clientSocket.isBound());

        // Client 소켓에 대한 OutputStream 연결
        DataOutputStream outputStream = new DataOutputStream(clientSocket.getOutputStream());
        // Server 에 메세지 보내기
        outputStream.writeUTF("Hello Diger's Server!!!!");

        // Client 소켓에 대한 InputStream 연결
        DataInputStream inputStream = new DataInputStream(clientSocket.getInputStream());
        // Server 에 ECHO 응답 받기
        System.out.println(inputStream.readUTF());
    }
}
