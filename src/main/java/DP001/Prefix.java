package DP001;/*
문자열 배열(string array)이 주어지면, 제일 긴 공통된 접두사(prefix)의 길이를 찾으시오.
        예제)
        Input: [“apple”, “apps”, “ape”]
        Output: 2 // “ap”

        Input: [“hawaii”, “happy”]
        Output: 2 // “ha”

        Input: [“dog”, “dogs”, “doge”]
        Output: 3 // “dog”
*/

public class Prefix {

    public String getPrefix(String[] words) {

        for (int i = 0; ; i++) {
            for (int j = 1; j < words.length; j++) {
                try {
                    if (!(words[0].charAt(i) == words[j].charAt(i))) {
                        return words[0].substring(0, i);
                    }
                } catch (StringIndexOutOfBoundsException e) {
                    return words[0].substring(0, i);
                }
            }
        }
    }
}
