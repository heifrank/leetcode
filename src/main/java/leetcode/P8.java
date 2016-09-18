package leetcode;

/**
 * Created by heifrank on 16/9/17.
 */
public class P8 {
    public int myAtoi(String str) {
        long ans = 0;
        int beg = 0;
        if(str.length() == 0) return 0;

        while(str.charAt(beg) == ' ') {
            beg++;
        }

        boolean flag = str.charAt(beg) == '-';
        if(str.charAt(beg) == '-' || str.charAt(beg) == '+') {
            beg++;
        }

        for(int i = beg; i < str.length(); i++) {
            if(str.charAt(i) < '0' || str.charAt(i) > '9') {
                break;
            }
            ans = ans * 10 + (str.charAt(i) - '0') * (flag ? -1 : 1);

            if(ans > Integer.MAX_VALUE) {
                ans = Integer.MAX_VALUE;
                break;
            }

            if(ans < Integer.MIN_VALUE) {
                ans = Integer.MIN_VALUE;
                break;
            }
        }
        return (int)ans;
    }
}
