import java.util.*;

public class Solution4 {

    public static void main(String[] args) {
        System.out.println(new Solution4().solution("우리 우리 우리 하나 우리 국민 삼성 농협 농협 농협 국민 저축"));
    }

    public String solution(String inputString) {
        List<String> list = new ArrayList<>();
        StringBuilder result = new StringBuilder();
        String[] banks = inputString.trim().split(" ");
        for (String bank : banks) {
            if (list.contains(bank)) {
                list.remove(bank);
                list.add(bank);
            } else {
                list.add(bank);
            }
            for (int i = list.size() - 1; i >= list.size() - 5 && i >= 0; i--) {
                result.append(list.get(i)).append(" ");
            }
            result.append("\n");
        }

        return result.toString();
    }
}
