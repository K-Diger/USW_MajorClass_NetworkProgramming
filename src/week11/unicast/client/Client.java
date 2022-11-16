package week11.unicast.client;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class Client {

    public static void main(String[] args) {
        try (DatagramSocket socket = new DatagramSocket(4000)) {
            byte[] buffer = new byte[1024 * 1024];
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
            socket.receive(packet);

            byte[] receiveData = packet.getData();
            String data = new String(receiveData, 0, packet.getLength());
            System.out.println("receiveData = " + data);
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
