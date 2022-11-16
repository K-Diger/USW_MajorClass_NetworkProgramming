package week10.udpclient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class Client {

    // DatagramSocket : 소켓 생성
    // DatagramPacket : UDP 패킷
    // UDP 관련된 요구사항은 위 두가지 클래스 선에서 해결가능하다.
    public static void main(String[] args) {
        // 클라이언트는 소켓을 만들 때 굳이 IP 랑 포트를 받을 필요가없다.
        // 연결이 필요없기 때문에 굳이 필요없기도 하고
        // 패킷을 보낼때 자동으로 들어간다.
        // ** 서버와 달리 누구한테 보낼지를 지정해야한다. **
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             DatagramSocket socket = new DatagramSocket()) {

            while (true) {
                byte[] buffer = br.readLine().getBytes();
                InetAddress address = InetAddress.getByName("172.16.39.188");
                DatagramPacket packet = new DatagramPacket(buffer, buffer.length, address, 8080);
                socket.send(packet);
            }
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}