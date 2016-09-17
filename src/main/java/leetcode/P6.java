package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by heifrank on 16/9/17.
 */
public class P6 {
    public String convert(String s, int numRows) {
        if(numRows == 1) return s;
        List<List<Character>> rows = new ArrayList<List<Character>>(numRows);
        for(int i = 0; i < numRows; i++) {
            rows.add(new ArrayList<Character>());
        }

        int curRow = 0, dir = 1;
        for(int i = 0; i < s.length(); i++) {
            rows.get(curRow).add(s.charAt(i));
            if(curRow + dir >= numRows || curRow + dir < 0) {
                dir = -dir;
            }
            curRow += dir;
        }

        StringBuilder builder = new StringBuilder();
        for(int i = 0; i < numRows; i++) {
            if(rows.get(i).isEmpty()) {
                break;
            }
            for(Character c : rows.get(i)) {
                builder.append(c);
            }
        }
        return builder.toString();
    }
}
