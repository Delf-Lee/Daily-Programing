package backjoon;

import java.util.*;

public class Q12891 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int pwdLength = sc.nextInt();
        char[] str = sc.next().toCharArray();
        final char[] DNA = {'A', 'C', 'G', 'T'};

        // 조건 해시맵 초기화
        Map<Character, Integer> leastMap = new HashMap<>();
        for (int i = 0; i < DNA.length; i++) {
            int dna = sc.nextInt();
            if (dna != 0) {
                leastMap.put(DNA[i], dna);
            }
        }

        // 패스워드 해시맵 초기화
        Map<Character, Integer> pwdMap = new HashMap<>();
        for (int i = 0; i < pwdLength; i++) {
            char ch = str[i];
            pwdMap.put(ch, pwdMap.containsKey(ch) ? pwdMap.get(ch) + 1 : 1);
        }

        int cnt = 0;
        for (int i = pwdLength; i < str.length; i++) {
            //  조건 만족시 카운트
            if (check(pwdMap, leastMap)) cnt++;
            // 맨 앞 문자 제외
            if (pwdMap.containsKey(str[i - pwdLength])) {
                pwdMap.put(str[i - pwdLength], pwdMap.get(str[i - pwdLength]) - 1);
            }
            // 맨 뒤 문자 추가
            pwdMap.put(str[i], pwdMap.containsKey(str[i]) ? pwdMap.get(str[i]) + 1 : 1);
        }
        if (check(pwdMap, leastMap)) cnt++; // 마지막 카운트
        System.out.println(cnt);
    }

    static boolean check(Map<Character, Integer> pwdMap, Map<Character, Integer> leastMap) {
        try {
            for (Character dna : leastMap.keySet()) {
                if (pwdMap.get(dna) < leastMap.get(dna)) { // 패스워드 해시맵에 더 적으면 조건 불만족
                    return false;
                }
            }
        } catch (NullPointerException e) {
            return false; // 패스워드 해시맵에 없으면 조건 불만족
        }
        return true;
    }

    // 디버깅용 맵 출력
    static <K, V> void  printMap(Map<K, V> map) {
        System.out.println("-----");
        for (K k : map.keySet()) {
            System.out.println(k + "(" + map.get(k) + ")");
        }
        System.out.println("-----");
    }
}