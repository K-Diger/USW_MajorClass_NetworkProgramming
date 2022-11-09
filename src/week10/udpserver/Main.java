package week10.udpserver;

import java.io.IOException;
import java.net.DatagramSocket;
import java.net.DatagramPacket;
import java.net.SocketException;

public class Main {

    // DatagramSocket : 소켓 생성
    // DatagramPacket : UDP 패킷
    // UDP 관련된 요구사항은 위 두가지 클래스 선에서 해결가능하다.

    // UDP 를 쓴다?
    // ->
    // 연결 필요없으니 소켓만 만들고, 내 포트만 설정한다.
    // 그리고 나서, 소켓에 있는 데이터를 버퍼 단위로 받아온다.
    public static void main(String[] args) {
        // 192.168.137.1
        // 다음과 같이 try-with-resource 를 활용하면
        // 내부에 open/close 형태의 메서드를 사용하면 try 가 끝나면 알아서 close 해줌
        try (DatagramSocket socket = new DatagramSocket(8080)) {
            // 버퍼 크기 지정 : 1MB
            byte[] buffer = new byte[1024 * 1024];
            while (true) {
                System.out.println("UDP ON!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                // 전달받을 데이터그램 정의하기
                DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
                // 패킷 수신하기
                socket.receive(packet);
                // 수신받은 패킷 까보기
                byte[] receivedData = packet.getData();
                System.out.printf("클라이언트 IP : %s, 포트 : %s\n", packet.getAddress().getHostAddress(), packet.getPort());
                System.out.printf("데이터그램(패킷) 오프셋 : %d, 데이터그램(패킷) 길이 : %d\n", packet.getOffset(), packet.getLength());
                String message = new String(receivedData, packet.getOffset(), packet.getLength());
                System.out.println("message = " + message);
            }
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
