package OPDisplay.DisplayPart;

import OPDisplay.util.Data;
import OPDisplay.util.Header;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * Created by PurpleWall on 2016/9/21.
 */
public class DiagramServer extends Thread {

    private static final int PORT = 5000;

    private int did = 0;

    private DatagramSocket serverSocket;

    private DatagramPacket recvPacket;

    private DatagramPacket sendPacket;

    private byte recvByte[];

    private String recvStr;

    private byte sendByte[];

    private static DisplayFrame frame = new DisplayFrame();

    private static PoolFrame frame1 = new PoolFrame();

    /**
     * 此处启动监听器，单线程顺序执行
     */
    public void UDPListner() {
        try {
            serverSocket  = new DatagramSocket(PORT);
            recvByte = new byte[1024];
            recvPacket = new DatagramPacket(recvByte, recvByte.length);
            recvStr = "";

            while (true) {

                serverSocket.receive(recvPacket);
                recvStr = new String(recvByte, 0, recvByte.length);
                System.out.println("recv0 : " + recvStr); // 调试输出

//                frame.getSendPanel0().addQueue(new Header(1, 1, 0));
//                frame1.addBufferData(new Data(1, "test"));
                /*
                添加分析器，分析信息，执行动作
                 */

                if (recvStr.substring(0,1).equals("0")) {
                    if (frame1.isFull()) { //检测缓冲区满，返回等待
                        sendByte = "0".getBytes();
                        sendPacket = new DatagramPacket(sendByte, sendByte.length, recvPacket.getAddress(), recvPacket.getPort());

                        System.out.println("reflect : " + new String(sendPacket.getData(), 0, sendPacket.getData().length));//tssc


                        serverSocket.send(sendPacket);
                    } else {  //检测缓冲区不满， 返回1，要求发送数据
                        sendByte = "1".getBytes();
                        sendPacket = new DatagramPacket(sendByte, sendByte.length, recvPacket.getAddress(), recvPacket.getPort());


                        System.out.println("reflect : " + new String(sendPacket.getData(), 0, sendPacket.getData().length));//tssc


                        serverSocket.send(sendPacket);
                        /*------------------------------------------------*/
                        serverSocket.receive(recvPacket);
                        recvStr = new String(recvByte, 0, recvByte.length);


                        System.out.println("recv1 : " + recvStr); // 调试输出


                        //信息整理
                        int sendId = Integer.parseInt(recvStr.substring(1,2));
                        int recvId = Integer.parseInt(recvStr.substring(2,3));
                        int dataId = did++;
                        String dContent = recvStr.substring(4);

                        frame.getSendPanel(sendId).addQueue(new Header(sendId, recvId, dataId));
                        frame1.addBufferData(new Data(dataId, dContent));
                    }

                } else if (recvStr.substring(0,1).equals("2")) {  // 收到
//                    serverSocket.receive(recvPacket);
//                    recvStr = new String(recvByte, 0, recvByte.length);
                    System.out.println("recv1 : " + recvStr); // 调试输出,程序故障原因是重复接收，应该和recv0的数据一致
                    int sendId = Integer.parseInt(recvStr.substring(1,2));
                    int recvId = Integer.parseInt(recvStr.substring(2,3));
                    frame1.popBufferData();
                    frame.getSendPanel(sendId).popQueue();
                    System.out.println("pop successfully!!");
                    /*-----------------开始向接收进程那里写数据---------------------------------*/
                    frame.getRecvPanel(recvId).addQueue(new Header(sendId, recvId, 0));

                } else if (recvStr.substring(0,1).equals("3")) {
//                    recvStr = new String(recvByte, 0, recvByte.length);
                    int recvId = Integer.parseInt(recvStr.substring(1,2));
                    frame.getRecvPanel(recvId).popQueue();
                }
            }
        } catch (SocketException e) {
            e.printStackTrace();
            System.out.println("Socket error");
        } catch (IOException e) {
            e.printStackTrace();
        }
        serverSocket.close();
    }

    @Override
    public void run() {
        UDPListner();
    }

    public DiagramServer() {
        frame.setVisible(true);
        frame1.setVisible(true);
//        (new DiagramServer()).start();
    }


    /**
     * 单元测试
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {

        (new DiagramServer()).start();
        frame.setVisible(true);
        frame1.setVisible(true);
    }
}
