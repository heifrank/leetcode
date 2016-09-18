package leetcode;

/**
 * Created by heifrank on 16/9/17.
 */
public class P7 {
    public int reverse(int x) {
        boolean flag = x >= 0;
        x = Math.abs(x);
        long virtAns = 0;
        while(x > 0) {
            virtAns = virtAns * 10 + x % 10;
            x /= 10;
        }
        if(virtAns > Integer.MAX_VALUE || virtAns < Integer.MIN_VALUE) {
            return 0;
        }
        return flag ? (int)virtAns : (int)-virtAns;
    }
}
