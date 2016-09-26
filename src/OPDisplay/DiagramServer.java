package OPDisplay;

import sun.security.x509.IPAddressName;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.ArrayList;

/**
 * Created by PurpleWall on 2016/9/21.
 */
public class DiagramServer {

    private static final int PORT = 5000;

    private DatagramSocket serverSocket;

    private DatagramPacket recvPacket;

    private DatagramPacket sendPacket;

    private byte recvByte[];

    private String recvStr;

    private byte sendByte[];

    /**
     * 此处启动监听器，单线程顺序执行
     */
    public void UDPListner() {
        try {
            serverSocket  = new DatagramSocket(5000);
            recvByte = new byte[1024];
            recvPacket = new DatagramPacket(recvByte, recvByte.length);
            recvStr = "";

            while (true) {

                serverSocket.receive(recvPacket);
                recvStr = new String(recvByte, 0, recvByte.length);
                System.out.println("recv : " + recvStr); // 调试输出


                /*
                添加分析器，分析信息，执行动作
                 */
                sendByte = "recv successfully".getBytes();
                sendPacket = new DatagramPacket(sendByte, sendByte.length, recvPacket.getAddress(), recvPacket.getPort());
                serverSocket.send(sendPacket);

            }
        } catch (SocketException e) {
            e.printStackTrace();
            System.out.println("Socket error");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public PktParse genePkt(byte[] bytes) {
        String str = new String(bytes);
        return new PktParse(Integer.parseInt(str.substring(0,1)),
                Integer.parseInt(str.substring(1,2)), Integer.parseInt(str.substring(2)));
    }

    public boolean relaction(PktParse pkt) {
        if (pkt.getType() == 0)  {
            // 发送端
            if (pkt.getSignal() == 0) {
                // add() a new header   return 0s to wait
            } else if (pkt.getSignal() == 1) {
                // remove a head of the queue
            }
        }


        return true;
    }

    public DiagramServer() {
        UDPListner();
    }

    public static void main(String[] args) throws Exception {

        new DiagramServer();
    }
}
