import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Solution7 {

    public static void main(String[] args) {
        System.out.println(new Solution7().solution("4; 1 30 0 6 0 2 1 3"));
    }

    public String solution(String space) {

        String[] rawData = space.split(";");
        int startingPoint = Integer.parseInt(rawData[0]);
        List<Integer> payload = Arrays.stream(rawData[1].trim().split(" ")).map(Integer::parseInt).collect(Collectors.toList());

        List<Integer> resultPayload = new ArrayList<>();

        while (payload.get(startingPoint) == 0) {
            resultPayload.add(0);
            startingPoint = payload.get(startingPoint + 1);
            resultPayload.add(resultPayload.size() + 1);
        }
        resultPayload.add(1);
        resultPayload.add(payload.get(startingPoint + 1));

        StringBuilder result = new StringBuilder("0;");
        for (int i = 0; i < payload.size(); i++) {
            if (i < resultPayload.size()) {
                result.append(" ").append(resultPayload.get(i));
            } else {
                result.append(" " + 0);
            }
        }

        return result.toString();
    }
}
