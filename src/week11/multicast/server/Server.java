package week11.multicast.server;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;


// 멀티캐스트 (파티) 주소를 설정해주기만 하면됨
public class Server {

    public static void main(String[] args) {
        try (DatagramSocket socket = new DatagramSocket()) {
            String message = "Hello UDP Client";
            byte[] buffer = message.getBytes();
            while (true) {
                try {
                    InetAddress groupAddress = InetAddress.getByName("224.0.0.1x");
                    DatagramPacket packet = new DatagramPacket(buffer, buffer.length, groupAddress, 4000);
                    socket.send(packet);
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
