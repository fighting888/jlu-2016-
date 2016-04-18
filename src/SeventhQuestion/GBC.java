package SeventhQuestion;

import java.awt.*;

/**
 * Created by PurpleWall on 2016/4/13.
 */
public class GBC extends GridBagConstraints {

    public GBC(int x, int y) {
        this.gridx = x;
        this.gridy = y;
    }

    public GBC(int x, int y, int width, int height) {
        this.gridx = x;
        this.gridy = y;
        this.gridwidth = width;
        this.gridheight = height;
    }

    public GBC setAnchor(int anchor) {
        this.anchor = anchor;
        return this;
    }

    public GBC setWeight(double weightx, double weighty) {
        this.weightx = weightx;
        this.weighty = weighty;
        return this;
    }
}
