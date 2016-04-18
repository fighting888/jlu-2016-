package unitTest;

/**
 * Created by PurpleWall on 2016/4/14.
 */
public class JS {
    int[] D = {0,2,4,3,1,3,1,2};
    int[] J = new int[8];
    public void fun(int n, int k) {
        k = 1;
        J[0] = 0;
        J[1] = 1;
        int r;
        for (int i = 2;i < 8;++i) {
            r = k;
            while (D[J[r]] > D[i] && D[J[r]] != r) {

                r--;
            }
            if (D[J[r]] <= D[i] && D[J[i]] > r) {
                for (int l = k; l >= r+1; --l) {
                    J[l+1] = J[l];
                }
                J[r+1] = i;
                k++;
            }
        }
        for (int i = 0; i < J.length; i++) {
            System.out.println(J[i]);
        }

    }

    public static void main(String[] args) {
        JS js = new JS();
        js.fun(8, 0);
    }
}
