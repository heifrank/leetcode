package leetcode;

/**
 * Created by heifrank on 16/9/17.
 */
public class P5 {
    public String longestPalindrome(String s) {
        int len = s.length();
        if(len == 0) return "";
        int ans = 1, pos = 0;
        for(int i = 0; i < len; i++) {
            int k = 1;
            while(i - k >= 0 && i + k < len && s.charAt(i - k) == s.charAt(i + k)) {
                if(2 * k + 1 > ans) {
                    ans = 2 * k + 1;
                    pos = i;
                }
                ++k;
            }
        }

        for(int i = 0; i < len - 1; i++) {
            int k = 0;
            while(i - k >= 0 && i + 1 + k < len && s.charAt(i - k) == s.charAt(i + 1 + k)) {
                if(2 * (k + 1) > ans) {
                    ans = 2 * (k + 1);
                    pos = i;
                }
                ++k;
            }
        }

        if((ans & 1) == 1) {
            return s.substring(pos - ans / 2, pos + ans / 2 + 1);
        } else {
            return s.substring(pos - ans / 2 + 1, pos + ans / 2 + 1);
        }
    }
}
