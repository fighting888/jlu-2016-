package OPDisplay.util;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/**
 * Created by PurpleWall on 2016/9/21.
 */
public class UDPClient {

    private static final int PORT = 5000;



    public UDPClient() {
        Init();
    }

    public void Init() {

        DatagramSocket dataSocket;
        DatagramPacket dataPacket;
        byte sendDataByte[];
        String sendStr;

        DatagramPacket recvPacket;
        byte recvDataByte[];
        try {
            // 指定端口号，避免与其他应用程序发生冲突

            dataSocket = new DatagramSocket(5002);
            sendDataByte = new byte[1024];
            sendStr = "UDP方式发送数据";
            sendDataByte = sendStr.getBytes();
            dataPacket = new DatagramPacket(sendDataByte, sendDataByte.length,
                    InetAddress.getByName("localhost"), PORT);
            dataSocket.send(dataPacket);

            recvDataByte = new byte[1024];
            //recvPacket = new DatagramPacket(recvDataByte, recvDataByte.length);
            dataSocket.receive(dataPacket);
            System.out.println("recv : "  + new String(dataPacket.getData(), 0, dataPacket.getData().length));

            dataSocket.close();

        } catch (SocketException se) {
            se.printStackTrace();
        } catch (IOException ie) {
            ie.printStackTrace();
        }
    }



    public static void main(String args[]) throws Exception {
        // BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
//        DatagramSocket clientSocket = new DatagramSocket();
//        InetAddress IPAdress = InetAddress.getByName("localhost");
//
//        byte[] sendData = new byte[1024];
//        byte[] receiveData = new byte[1024];
//
//        String sentence = "test";
//        sendData = sentence.getBytes();
//        DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAdress, 5000);
//        clientSocket.send(sendPacket);
//        System.out.println("send : " + sendPacket.getData().toString());
//
//        DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
//        clientSocket.receive(receivePacket);
//
//        System.out.println("From server : " + receiveData.toString());
//        clientSocket.close();

        new UDPClient();
    }

}
