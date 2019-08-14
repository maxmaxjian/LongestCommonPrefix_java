import java.util.Arrays;

public class Solution2 implements Solution {
    @Override
    public String longestCommonPrefix(String[] strs) {

        if (strs.length == 0) {
            return "";
        }
        Arrays.sort(strs, (s, t)->s.length()-t.length());
        String first = strs[0];
        int i = 0;
        while (i <= first.length()) {
            String s = first.substring(0, i);
            for (int j = 1; j < strs.length; j++) {
                if (strs[j].indexOf(s) != 0) {
                    if (i > 0) {
                        return first.substring(0, i - 1);
                    } else {
                        return "";
                    }
                }
            }
            i++;
        }

        return first;
    }
}
