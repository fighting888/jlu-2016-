package OPDisplay.util;

/**
 * Created by PurpleWall on 2016/10/8.
 */
public class pkt {

    public int sendId = 0;

    public int recvId = 0;

    public String content = null;

    public pkt(int sid, int rid, String cont) {
        sendId = sid;
        content = cont;
        recvId = rid;
    }
}
