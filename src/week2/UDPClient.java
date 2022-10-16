package week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPClient {

    public static void main(String[] args) throws IOException {

        // String message = "Hello I'm Diger !!!";

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String message = br.readLine();

        // 클라이언트 소켓 생성
        try {
            // 생성자 파라미터에 포트번호를 붙이지 않으면 임의의 포트번호가 붙게된다.
            DatagramSocket clientSocket = new DatagramSocket(9000);

            // 서버주소 등록
            // InetAddress serverAddress = InetAddress.getByName("172.16.36.68");
            InetAddress serverAddress = InetAddress.getByName("127.0.0.1");

            // 클라이언트 데이터그램 형식 (버퍼에 담을 내용, 버퍼 길이, 서버 주소, 서버 포트)
            DatagramPacket datagram = new DatagramPacket(message.getBytes(), message.length(), serverAddress, 8080);

            // 데이터그램 보내기
            clientSocket.send(datagram);
            
            // 연결 닫기
            clientSocket.close();

        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
