import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

public class Solution {

    public static void main(String[] args) {
        System.out.println5(new Solution().solution("100 300 10 0 40 0 0 70 65", "40 300 20 10 10 20 100 10 0"));

    }

    public String solution5(String kimToss, String leeToss) {
        List<Integer> kimTossList = record(kimToss);
        List<Integer> leeTossList = record(leeToss);
        List<Integer> result = new ArrayList<>();
        int stack = 0;
        for (int i = 0; i < kimTossList.size(); i++) {
            int kimMoney = kimTossList.get(i);
            int leeMoney = leeTossList.get(i);
            if (kimMoney - leeMoney + stack > 0) {
                result.add(kimMoney - leeMoney + stack);
                stack = 0;
                continue;
            }
            result.add(0);
            stack += (kimMoney - leeMoney);
        }
        return result.toString();
    }

    public List<Integer> record(String record) {
        return Arrays.stream(record.split(" ")).map(Integer::parseInt).collect(Collectors.toList());
    }
}
