package dailyprogramming;

public class Solution_008 {
    public String getReverseWord(String str) {
        char[] chArr = str.toCharArray(); // 문자열 -> 문자 배열로 변환(문자 스왑을 위해)
        int cursor = 0; // 단어의 첫 인덱스
        int blank; // 다음 공백(' ')의 인덱스
        char tmp; // 문자 스왑을 위한 변수
        while (cursor < chArr.length) { // 문자열이 끝날 때까지 순회
            blank = getIndexOf(chArr, ' ', cursor);
            for (int i = 0; i < (blank - cursor) / 2; i++) { // 단어의 절반까지 순회하며 문자 스왑
                tmp = chArr[cursor + i];
                chArr[cursor + i] = chArr[blank  - i - 1];
                chArr[blank - i -1] = tmp;
            }
            cursor = blank + 1; // 다음 단어의 첫 인덱스
        }
        return String.valueOf(chArr);
    }

    // String 클래스에 유시한 동작을 하는 IndexOf라는 매소드가 존재하나 임의로 직접 구현.
    public int getIndexOf(char[] str, char c, int from) {
        for (int i = from; i < str.length; i++) {
            if (str[i] == c)
                return i;
        }
        return str.length; // 해단 문자가 없다면 문자열 길이를 리턴
    }
}