import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class Solution1Test {

    private String[] input;
    private String expected;
    private Solution soln = new Solution2();

    public Solution1Test(String[] in, String out) {
        input = in;
        expected = out;
    }

    @Parameterized.Parameters
    public static Collection parameters() {
        return Arrays.asList(new Object[][]{
                {new String[]{"flower", "flow", "flight"}, "fl"},
                {new String[]{"dog", "racecar", "car"}, ""},
                {new String[]{"", "b"}, ""},
                {new String[]{"ca", "a"}, ""},
                {new String[]{""}, ""}
        });
    }

    @Test
    public void testLongestCommonPrefix() {
        System.out.print("Input: ");
        for (int i = 0; i < input.length; i++) {
            System.out.print(input[i]+" ");
        }
        System.out.print(", ");
        System.out.println(String.format("expected = %s, actual = %s",
                expected, soln.longestCommonPrefix(input)));
        assertEquals(expected, soln.longestCommonPrefix(input));
    }
}