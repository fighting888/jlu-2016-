package OPDisplay;

/**
 * Created by PurpleWall on 2016/9/19.
 */
public class Header {

    private int sendId;

    private int recvId;

    private int dataId;

    public Header() {
        this.setDataId(-1);
        this.setRecvId(-1);
        this.setDataId(-1);
    }

    public Header(int sendId, int recvId, int dataId) {
        this.setDataId(dataId);
        this.setRecvId(recvId);
        this.setSendId(sendId);
    }

    public int getDataId() {
        return dataId;
    }

    public int getRecvId() {
        return recvId;
    }

    public int getSendId() {
        return sendId;
    }

    public void setDataId(int dataId) {
        this.dataId = dataId;
    }

    public void setRecvId(int recvId) {
        this.recvId = recvId;
    }

    public void setSendId(int sendId) {
        this.sendId = sendId;
    }
}
