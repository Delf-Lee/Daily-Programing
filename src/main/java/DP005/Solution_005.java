package DP005;

import java.util.HashMap;

public class Solution_005 {
    private HashMap<Character, Integer> hm = new HashMap<Character, Integer>();
    private String tmpStr = ""; // 순회 과정에서 만들어질 중복 없는 서브스트링
    private String subStr = ""; // 중복 없는 서브스트링 중 가장 짧은 문자열(결과 값)

    public String getNotLongestSubStringWithoutDuplicate(String str) {
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (!hm.containsKey(ch)) { // 중복되지 않음
                hm.put(ch, i); // 해당 문자를 HashMap에 추가
                tmpStr += ch;
                continue;
            }
            i = hm.get(ch); // 같은 문자가 있던 바로 다음 문자부터 다시 순회
            initSubString(); // 중복 조건(HashMap) 초기화, 문자열 변수 초기화
        }
        return subStr; // 본 문제는 원래 문자열의 길이를 반환하는 것이지만 임의로 문자열을 반환함
    }

    private void initSubString() {
        hm.clear();
        // 이번 순회의 문자열 길이와 전 순회의 문자열 길이를 비교
        if(subStr.length() < tmpStr.length()) { // [<]와 [<=]의 결과 값이 다를 수 있음("aba"에서 "ab"인지 "ba"인지의 차이)
            subStr = tmpStr;
        }
        tmpStr = "";
    }
}