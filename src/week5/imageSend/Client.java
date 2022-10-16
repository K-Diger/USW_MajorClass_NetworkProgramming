package week5.imageSend;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.Inet4Address;
import java.net.Socket;

public class Client {


    Socket clientSocket;
    PrintWriter out;
    BufferedReader in;

    // 서버와 소켓 연결하기 위한 메서드
    public void connect() throws IOException {
        // IP Port 입력해야함 (연결할 상대의 소켓 IP/PORT)
        clientSocket = new Socket(Inet4Address.getByName("127.0.0.1"), 8080);
        out = new PrintWriter(clientSocket.getOutputStream(), true);
        in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
    }

    public static void main(String[] args) throws Exception {
        // 클라이언트 소켓 생성 및 연결 시작
        Client client = new Client();
        client.connect();
        // 클라이언트 소켓 생성 및 연결 구문 종료

        // logging
        System.out.println("소켓 연결 완료");

        // 파일 경로지정
        String filePath = "E:\\Priority\\Development\\SourceCode\\Backend\\NetworkProgramming-USW-22-2-MajorClass\\src\\week5\\static\\sendedImage.jpg";

        ByteArrayInputStream bais = new ByteArrayInputStream(client.clientSocket.getInputStream().readAllBytes());
        BufferedImage image = ImageIO.read(bais);

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ImageIO.write(image, "jpg", baos);
    }
}