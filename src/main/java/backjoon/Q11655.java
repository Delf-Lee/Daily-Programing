package backjoon;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

// https://www.acmicpc.net/problem/11655
public class Q11655 {
    public static void main(String[] args) throws IOException {
        char[] alph = {'a', 'A'};
        Map<Character, Character> rot13 = new HashMap<>();
        for (int j = 0; j < 2; j++)
            for (int i = 0; i < 26; i++)
                rot13.put((char) (alph[j] + i), (char) (alph[j] + (i + 13) % 26));
        String input = new Scanner(System.in).nextLine();
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            result.append(rot13.getOrDefault(ch, ch));
        }
        System.out.println(result);
    }
}
