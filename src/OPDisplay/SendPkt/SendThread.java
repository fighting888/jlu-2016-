package OPDisplay.SendPkt;

import OPDisplay.util.Header;

import javax.swing.*;
import javax.swing.text.StringContent;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * Created by PurpleWall on 2016/9/26.
 */
public class SendThread extends Thread {

    private static int sid = 0;

    private int PORT = 5000;

    private int[] recvPorts = {45005, 45006, 45007, 45008, 45009};

    private DatagramSocket socket;

    private DatagramPacket packet;

    private byte[] bufBytes = new byte[1024];

    private String bufStr = null;

    private static SendFrame s = new SendFrame(3);

    /**
     * If this thread was constructed using a separate
     * <code>Runnable</code> run object, then that
     * <code>Runnable</code> object's <code>run</code> method is called;
     * otherwise, this method does nothing and returns.
     * <p>
     * Subclasses of <code>Thread</code> should override this method.
     *
     * @see #start()
     * @see #stop()
     */
    @Override
    public void run() {
        try {
            socket = new DatagramSocket();
            while (true) {


                if (s.getHeaders().isEmpty()) {
                    Thread.sleep(1000);
                    System.out.println("the header queue is empty ");//tssc
                } else {
                    Thread.sleep(3000);
                    Header h = s.getHeaders().removeFirst();
                    bufBytes = ("2" + String.valueOf(h.getSendId())).getBytes();
                    packet = new DatagramPacket(bufBytes, bufBytes.length, InetAddress.getByName("127.0.0.1"), 5000);
                    socket.send(packet);
                    System.out.println("send the remove signal");//tssc

                    /*------------发往接收端------------------*/

                    byte[] bytes = new byte[1024];
                    bytes = (String.valueOf(h.getSendId()) + String.valueOf(h.getRecvId()) + s.getDatas().removeFirst().getData()).getBytes();
                    packet = new DatagramPacket(bytes, bytes.length, InetAddress.getByName("127.0.0.1"), recvPorts[h.getRecvId()]);
                    socket.send(packet);
                    System.out.println("send to recv part");
                }


//                if (!s.getHeaders().isEmpty()) {
//                    Thread.sleep(1000);
//                    Header h = s.getHeaders().removeFirst();
//                    bufBytes = ("2" + String.valueOf(h.getSendId())).getBytes();
//                    packet = new DatagramPacket(bufBytes, bufBytes.length, InetAddress.getByName("127.0.0.1"), 5000);
//                    socket.send(packet);

//                    s.getHeaders().removeFirst();
//                    System.out.println("send remove signal");
//                }


//                socket = new DatagramSocket(PORT);
//                bufBytes = "0".getBytes();
//                packet = new DatagramPacket(bufBytes, bufBytes.length, InetAddress.getByName("127.0.0.1"), PORT);
//                socket.send(packet);
//                System.out.println("send 0 done"); // tssc
//
//                socket.receive(packet);
//                System.out.println("recv 0 done " + packet); // tssc
//                if (packet.getData().equals(0)) {
//                    JOptionPane.showMessageDialog(null, "Buffer is full, wait a minute");
//                } else {
//                    System.out.println("Done!!!");
//                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public SendThread(int sid) {
        s.setVisible(true);
        sid = sid;
//        (new SendThread(sid)).start();
    }


    public static void main(String[] args) {
        s.setVisible(true);
        (new SendThread(sid)).start();
    }
}
