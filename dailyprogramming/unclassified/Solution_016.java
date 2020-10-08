package unclassified;

import java.util.*;
// HaEaLaLaObWORLDb

// 0123456789012345
// HaEaLaLaObWORLDb
// a:4

/*- 꺼냄
 * - 특수문자? 아니면 패스
 * - 맵에 있음? 차이가 얼마임? // 있는데 -1이면 invalid
 * - 일정 간격보다 멀면 지우고 맵에서 -1으로 바꿈
 * - 일정 간격이면 지우고 인덱스 갱신
 * - 지움, 맵에 저장
 * -. */
public class Solution_016 {
    private HashMap<Character, Integer> characters = new HashMap<Character, Integer>();

    // private Stack<Character> characters = new Stack<Character>();
    public String getClearText(String adString) {
        char[] chArrAdStr = adString.toCharArray();

        for (int i = 0; i < adString.length(); i++) {
            char target = adString.charAt(i);
            if (!isSpecialCharacter(target)) continue;
            System.out.println("target: " + target + " " + i);
            if (!characters.containsKey(target)) {
                characters.put(target, i);
                continue;
            }
            int diff = i - characters.get(target);
            if (diff > 3) {
                characters.put(target, -1);
            } else if (diff == 2) {
                characters.put(target, i);
            } else if (diff == -1) {
                return "invalid";
            } else if (diff == 1) {
                return "invalid";
            }
        }


        Set set = characters.keySet();
        Iterator<Character> it = set.iterator();
        while (it.hasNext()) {
            char ch = it.next();
            if (characters.get(ch) == -1) {
                adString = adString.replace(ch, ' ');
                adString = adString.trim();
            } else {

                StringBuffer sb = new StringBuffer(adString);
                try {
                    adString = sb.insert(adString.indexOf(ch) - 1, " ").toString();
                } catch (IndexOutOfBoundsException e) {

                }
                adString = sb.insert(adString.lastIndexOf(ch) + 1, " ").toString();
                adString = adString.replaceAll("  ", " ");
                adString = adString.replaceAll(ch + "", "");
                adString = adString.trim();
            }
        }
        characters.clear();
        return adString;
    }


    private boolean isSpecialCharacter(char c) {
        return Character.isLowerCase(c);
    }

    private String removeRuleOne(String adString) {
        return "-AqOqA-";
    }

    public static void main(String[] args) {

    }
}
