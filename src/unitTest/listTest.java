package unitTest;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by PurpleWall on 2016/4/20.
 */
public class listTest {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
//        System.out.println(list.remove(3));
        list.remove(3);
        list.remove(1);
        System.out.println(list.get(0));
    }
}
