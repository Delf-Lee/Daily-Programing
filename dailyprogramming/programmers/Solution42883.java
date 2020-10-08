package programmers;

public class Solution42883 {
    public static void main(String[] args) {
        System.out.println(new Solution42883().solution("1924", 2));
    }
    String solution(String number, int k) {
        StringBuilder answer = new StringBuilder();
        //필요한 글자수만큼 반복하기
        for (int j = 0, index = -1; j < number.length() - k; j++) {
            char max = 0;
            //앞에서 남겨야 되는 숫자 중에 제일 큰수 체크
            for (int i = index + 1; i <= k + j; i++) {
                if (max < number.charAt(i)) {
                    index = i;
                    max = number.charAt(i);
                }            }
            //제일 큰수를 정답에 추가
            answer.append(max);
        }
        return answer.toString();
    }
}
