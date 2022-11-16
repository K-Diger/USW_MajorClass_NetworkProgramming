package week11.unicast.server;

import java.io.IOException;
import java.net.*;

public class Server {

    public static void main(String[] args) {
        try (DatagramSocket socket = new DatagramSocket(new InetSocketAddress("127.0.0.1",3000))) {
            String message = "Hello UDP Client";
            byte[] buffer = message.getBytes();
            while (true) {
                InetAddress client = InetAddress.getByName("127.0.0.1");
                DatagramPacket packet = new DatagramPacket(buffer, buffer.length, client, 4000);
                socket.send(packet);
            }
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
