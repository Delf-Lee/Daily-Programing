package codingtest.winterconding2018;

import java.util.HashSet;
import java.util.Set;

public class WinterCoding001 {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < skill.length(); i++) {
            set.add(skill.charAt(i));
        }
        for (String s : skill_trees) {
            boolean flag = true;
            int index = 0;
            for (int i = 0; i < s.length(); i++) {
                if (set.contains(s.charAt(i))) {
                    if (skill.charAt(index) == s.charAt(i)) {
                        index++;
                    } else {
                        flag = false;
                    }
                }
            }
            if(flag) {
                answer++;
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        WinterCoding001 main = new WinterCoding001();
        System.out.println(main.solution("CBD", new String[]{"BACDE", "CBADF", "AECB", "BDA"}));
    }
}
