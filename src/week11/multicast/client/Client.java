package week11.multicast.client;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.SocketException;

// 멀티캐스트 그룹에 참여하는 입장이 되기 위해, 멀티캐스트 소켓이 되어야한다.
public class Client {

    public static void main(String[] args) {
        try (MulticastSocket socket = new MulticastSocket(4000)) {
            InetAddress multicastAddress = InetAddress.getByName("224.0.0.1");
            socket.joinGroup(multicastAddress);
            byte[] buffer = new byte[1024 * 1024];
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
            while (true) {
                socket.receive(packet);
                byte[] receiveData = packet.getData();
                String data = new String(receiveData, 0, packet.getLength());
                System.out.println(data);
            }
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
