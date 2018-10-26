package dailyprogramming;

import java.util.Arrays;

public class Solution_032 {
    public String solution(Integer[] numbers) {
        String[] str_nums = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++)
            str_nums[i] = Integer.toString(numbers[i]);
        Arrays.sort(str_nums, (String o1, String o2) -> Integer.parseInt(o2 + o1) - Integer.parseInt(o1 + o2));

        StringBuilder sb = new StringBuilder();
        for (String str : str_nums)
            sb.append(str);

        String answer = sb.toString();
        if (Integer.parseInt(answer) == 0) return "0";
        else return answer;
    }
}