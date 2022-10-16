package week2;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Arrays;

public class UDPServer {

    public static void main(String[] args) {

        try {
            // 데이터그램 소켓 생성 (포트번호 : 8080)
            DatagramSocket serverSocket = new DatagramSocket(8080);

            // 소켓 버퍼 크기 (소켓이 데이터를 받을 크기를 지정하는 것이다.)
            byte[] buf = new byte[2000];

            // 데이터그램 패킷 생성
            // (서버는 전송할 작업이 필요하지 않기 때문에, 통신 대상의 주소와 포트가 생성자에 들어갈 필요 없다.)
            DatagramPacket datagram = new DatagramPacket(buf, buf.length);

            // 서버 켜졌는지 확인
            System.out.println("Server Listening");

            // 데이터가 들어오는 것을 받는 구문
            while (true) {

                // 서버 소켓에게, 들어온 데이터그램을 가지도록 하는 구문
                // IOException, TimeOut, PortNumber Exception
                serverSocket.receive(datagram);

                // Client IP 조회 및 출력
                InetAddress clientAddress = datagram.getAddress();
                int clientPort = datagram.getPort();

                System.out.println("DatagramData : " + Arrays.toString(datagram.getData()));
                System.out.println("ClientAddress : " + clientAddress);
                System.out.println("ClientPort : " + clientPort);

                // 데이터그램의 실제 데이터부분을 가져오기 (바이트)
                byte[] datagramData = datagram.getData();
                // 데이터그램의 실제 데이터부분을 가져오기 (문자열)
                String message = new String(datagramData);

                System.out.println("Client가 전송한 메세지 : " + message);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
