package unclassified;

public class Solution_001 {

    public String getPrefix(String[] words) {

        for (int i = 0; ; i++) {
            for (int j = 1; j < words.length; j++) {
                try {
                    if (!(words[0].charAt(i) == words[j].charAt(i))) { // 첫 번째 단어를 기준으로 각 글자들을 비교
                        return words[0].substring(0, i);
                    }
                } catch (StringIndexOutOfBoundsException e) { // 어느 단어가 가장 짧은지 모르니 예외처리
                    return words[0].substring(0, i);
                }
            }
        }
    }
}
