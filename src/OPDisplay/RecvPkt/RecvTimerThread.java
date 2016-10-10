package OPDisplay.RecvPkt;

import OPDisplay.util.pkt;

import java.io.IOException;
import java.net.*;

/**
 * Created by PurpleWall on 2016/10/8.
 */
public class RecvTimerThread extends Thread {

    private static int[] recvPorts = {45005, 45006, 45007, 45008, 45009};

    private static int rid = 3;

    private static RecvQueueThread queueThread = new RecvQueueThread(recvPorts[rid]);

    private static RecvFrame r = new RecvFrame(rid);

    private DatagramPacket packet;

    private DatagramSocket socket;

    private byte[] bufByte = new byte[1024];

    private String bufStr = null;

    public RecvTimerThread(int Rid) {
        rid = Rid;
        queueThread.start();
//        (new RecvTimerThread(rid)).start();
    }

    @Override
    public void run() {
        try {
            socket = new DatagramSocket();

            while (true) {

                if (queueThread.getQueue().isEmpty()) {
                    Thread.sleep(1000);
                    System.out.println("recv  queue is empty");//tssc
                } else {
                    Thread.sleep(3000);
                    pkt p = queueThread.getQueue().removeFirst();
                    r.refreshCont(String.valueOf(p.sendId), p.content);
                    bufByte = ("3" + String.valueOf(p.recvId)).getBytes();
                    packet = new DatagramPacket(bufByte, bufByte.length, InetAddress.getByName("127.0.0.1"), 5000);
                    socket.send(packet);
                    System.out.println("remove the recv signal");
                }

            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        (new RecvTimerThread(rid)).start();
        queueThread.start();
    }
}
