package dailyprogramming;

import javax.swing.text.html.HTMLDocument;
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
public class Solution_013 {
    private HashMap<Character, Integer> characters = new HashMap<Character, Integer>();

    // private Stack<Character> characters = new Stack<Character>();
    public String getClearText(String adString) {

        return null;
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
