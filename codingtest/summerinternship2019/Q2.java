package codingtest.summerinternship2019;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author delf
 */
public class Q2 {
    private List<String> result = new ArrayList<>();
    private static final char OPENED = '(';
    private static final char CLOSED = ')';

    public String Solution(int n) {
        append("", n, 0, 0);
        return Arrays.toString(result.toArray());
    }

    private void append(String s, int length, int nOpened, int nClosed) {
        if (s.length() >= length * 2) {
            result.add(s);
            return;
        }

        if (nOpened < length) {
            append(s + OPENED, length, nOpened + 1, nClosed);
        }

        if (nClosed < nOpened) {
            append(s + CLOSED, length, nOpened, nClosed + 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(new Q2().Solution(3));
    }
}