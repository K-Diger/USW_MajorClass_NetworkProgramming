package week5.ipaddress;

import java.io.IOException;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class Main {


    public static void main(String[] args) throws IOException {
        InetAddress inetAddress = InetAddress.getLocalHost();
        System.out.println(inetAddress);
        System.out.println("-----------------------------------------------");
        System.out.println(InetAddress.getLoopbackAddress());
        System.out.println("-----------------------------------------------");
        System.out.println(InetAddress.getByName("Diger"));
        System.out.println("-----------------------------------------------");
        System.out.println(InetAddress.getByName("localhost"));
        System.out.println("-----------------------------------------------");
        System.out.println(InetAddress.getByName("naver.com"));
        System.out.println("-----------------------------------------------");
        System.out.println(InetAddress.getByName("suwon.ac.kr"));
        System.out.println("-----------------------------------------------");
        byte[] naverAddress = InetAddress.getByName("www.naver.com").getAddress();
        for (int i = 0; i < naverAddress.length; i++) {
            if (naverAddress[i] < 0) System.out.println(naverAddress[i] + 256);

            else if (naverAddress[i] >= 0) System.out.println(naverAddress[i]);
        }
        System.out.println(InetAddress.getByName("google.co.kr").isReachable(100));
        System.out.println(InetAddress.getByName("suwon.ac.kr").isReachable(100));
        System.out.println(InetAddress.getByName("naver.com").isReachable(100));
        System.out.println(InetAddress.getByName("suwiki.kr").isReachable(100));
        System.out.println(InetAddress.getByName("127.0.0.1").isReachable(100));
        System.out.println(InetAddress.getByAddress(naverAddress));
        System.out.println("-----------------------------------------------");

        System.out.println("Inet6Address : " + Inet6Address.getByName("suwon.ac.kr"));
        System.out.println("Inet4Address : " + Inet4Address.getByName("suwon.ac.kr"));

    }
}
