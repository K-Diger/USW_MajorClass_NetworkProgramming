package week7.homework_retry.imageSend;

import javax.imageio.ImageIO;
import javax.imageio.stream.FileImageOutputStream;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.Inet4Address;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Server {

    ServerSocket serverSocket;
    Socket clientSocket;
    PrintWriter out;
    BufferedReader in;

    // 파라미터 : 포트(입력하지 않으면 임의의 포트가 입력됨), 백로그(몇 명까지 접속하게 할 것인지?)
    // 서버에도 주소를 할당하구 싶으면 Bind 를 하면된다.
    public void startServer() throws IOException {
        // 서버 소켓 오픈 및 포트 할당
        serverSocket = new ServerSocket();

        // 서버 주소 할당
        serverSocket.bind(new InetSocketAddress(Inet4Address.getByName("127.0.0.1"), 8080));

        // 서버 소켓이 허가하면, 상대방의 소켓을 얻을 수 있음
        clientSocket = serverSocket.accept();

        String serverImagePath = "E:\\Priority\\Development\\SourceCode\\Backend\\NetworkProgramming-USW-22-2-MajorClass\\src\\week7\\homework_retry\\imageSend\\static\\test.jpg";

        byte [] buffer = new byte[1024];
        FileImageOutputStream imageOutput = new FileImageOutputStream(new File(serverImagePath));
        imageOutput.write(buffer, 0, buffer.length);
        imageOutput.close();

        imageOutput.flush();
    }

    public void stopServer() throws IOException {
        in.close();
        out.close();
        clientSocket.close();
        serverSocket.close();
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        Server server = new Server();
        server.startServer();
    }
}
