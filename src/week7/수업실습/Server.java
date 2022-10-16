package week7.수업실습;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        // backlog 는 동시 접속자 수 (대기 큐의 길이)
        ServerSocket serverSocket = new ServerSocket();

        serverSocket.bind(new InetSocketAddress("172.16.36.30", 3000));

        // IP 주소 확인
        System.out.println(serverSocket.getInetAddress());
        System.out.println(serverSocket.isBound());
        System.out.println("----------------------------------------");

        while (true) {
            String createFilePath = "E:\\Priority\\Development\\SourceCode\\Backend\\NetworkProgramming-USW-22-2-MajorClass\\src\\week5\\static\\test.jpg";
            FileInputStream fis1 = new FileInputStream(createFilePath);

            // 나에게 연결한 소켓을 가지고 있는다. (Socket 내부에 Stream 을 읽어올 수 있음)
            Socket clientSocket = serverSocket.accept();
            DataInputStream inputStream = new DataInputStream(clientSocket.getInputStream());
            DataOutputStream outputStream = new DataOutputStream(clientSocket.getOutputStream());

            System.out.println(clientSocket.getInetAddress() + " Client Accept!");

            String message = inputStream.readUTF();
            System.out.println("Client가 전송한 데이터 : " + message);
            System.out.println("----------------------------------------");

            outputStream.writeUTF("[ECHO] " + message);
            clientSocket.close();
        }
    }
}