package leetcode;

/**
 * Created by heifrank on 16/9/17.
 */
public class P9 {
    public boolean isPalindrome(int x) {
        if(x < 0) return false;
        int dig = 1;
        while(dig <= x / 10) {
            dig *= 10;
        }

        while(dig > 0) {
            if(dig < 10) {
                return true;
            }
            if(x % 10 != x / dig) {
                return false;
            }
            x = (x - (x % 10) * dig) / 10;
            dig /= 100;
        }
        return true;
    }

    public static void main(String[] args) {
        P9 p9 = new P9();
        p9.isPalindrome(1874994781);
    }
}
