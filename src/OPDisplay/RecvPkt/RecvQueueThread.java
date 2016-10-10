package OPDisplay.RecvPkt;

import OPDisplay.util.Header;
import OPDisplay.util.pkt;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.util.ArrayDeque;
import java.util.Random;

/**
 * Created by PurpleWall on 2016/10/8.
 */
public class RecvQueueThread extends Thread {

    private DatagramPacket packet;

    private DatagramSocket socket;

    private byte[] bufByte = new byte[1024];

    private String bufStr = null;

    private ArrayDeque<pkt> queue = new ArrayDeque<>();

    public ArrayDeque<pkt> getQueue() {
        return queue;
    }

    private int port;

    public RecvQueueThread(int port) {
        this.port = port;
    }

    @Override
    public void run() {
        try {
            socket = new DatagramSocket(port);
            packet = new DatagramPacket(bufByte, bufByte.length);
            System.out.println("recv Socket start!!!"); //tssc
            while (true) {
                socket.receive(packet);
                bufByte = packet.getData();
                bufStr = new String(bufByte, 0, bufByte.length);
                System.out.println("recv get : " + bufStr); // 调试输出

                int sendId = Integer.parseInt(bufStr.substring(0,1));
                int recvId = Integer.parseInt(bufStr.substring(1,2));
                String dContent = bufStr.substring(2);

                queue.addLast(new pkt(sendId,recvId, dContent));
                System.out.println("add queue successfully!!" + queue.toString());
            }


        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
