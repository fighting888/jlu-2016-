package OPDisplay;

/**
 * Created by PurpleWall on 2016/9/19.
 */
public class Data {

    private int dataId;

    private String data;

    public Data() {
        this.setData("null");
        this.setDataId(-1);
    }

    public Data(int dataId, String data) {
        this.setDataId(dataId);
        this.setData(data);
    }

    public int getDataId() {
        return dataId;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public void setDataId(int dataId) {
        this.dataId = dataId;
    }
}
