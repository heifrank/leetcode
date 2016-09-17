package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by heifrank on 16/8/3.
 */
public class P3 {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Boolean> map = new HashMap<Character, Boolean>();
        int res = 0;
        int st = 0;
        for(int i = 0; i < s.length(); i++){
            if(map.get(s.charAt(i)) != null){
                do{
                    map.remove(s.charAt(st));
                }while(s.charAt(st++) != s.charAt(i));
            }
            map.put(s.charAt(i), true);
            res = Math.max(res, i - st + 1);
        }
        return res;
    }
}
