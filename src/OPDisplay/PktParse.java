package OPDisplay;

/**
 * Created by PurpleWall on 2016/9/22.
 */
public class PktParse {
    /**
     * 协议： type：0->sendprocess  1->recvprocess
     * id: sid, rid
     * signal: 0->start   1->finish  2->wait
     */

    private int type;

    private int id;

    private int signal;

    public int getId() {
        return id;
    }

    public int getSignal() {
        return signal;
    }

    public int getType() {
        return type;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setSignal(int signal) {
        this.signal = signal;
    }

    public void setType(int type) {
        this.type = type;
    }

    public PktParse(int type, int id, int signal) {
        this.type = type;
        this.id = id;
        this.signal = signal;
    }
}
