package hackerrank;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author delf
 */
public class Gemstone {

    static int gemstones(String[] arr) {
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < arr[0].length(); i++) {
            for (char ch : arr[0].toCharArray()) {
                set.add(ch);
            }
        }
        for (int i = 1; i < arr.length; i++) {
            List<Character> list = new ArrayList<>();
            for (char c : arr[i].toCharArray()) {
                if (set.contains(c)) list.add(c);
            }
            set.clear();
            set.addAll(list);
        }
        return set.size();
    }

    public static void main(String[] args) {
        System.out.println(gemstones(new String[]{"abcdde", "baccd", "eeabg"}));
    }
}
