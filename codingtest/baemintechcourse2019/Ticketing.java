package codingtest.baemintechcourse2019;

import java.time.LocalTime;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author delf
 */
public class Ticketing {
    private final LocalTime DEAD_LINE = LocalTime.of(10, 0, 0);
    private Pair<String, LocalTime> connectedClient = null;

    public String[] solution(int totalTicket, String[] logs) {

        Set<String> successClient = new HashSet<>();
        for (String log : logs) {
            String[] splited = log.split(" ");
            String name = splited[0];
            String type = splited[1];
            String time = splited[2];
            LocalTime requestTime = getLocalDateTime(time);

            // 티케팅 성공 체크
            if (connectedClient != null && connectedClient.getValue().plusSeconds(60).isBefore(requestTime)) {
                if(--totalTicket < 0) break; // 매진

                successClient.add(connectedClient.getKey()); // 성공
                connectedClient = null;
            }

            if (type.equals("request")) {
                if (connectedClient == null) { // 접속 가능한 상태
                    connectedClient = new Pair<>(name, requestTime);
                }
            } else {
                connectedClient = null; // leave 로그일 경우
            }
        }

        // 마지막 대기자 체크
        if (connectedClient != null && connectedClient.getValue().plusSeconds(60).isBefore(DEAD_LINE)) {
            if(totalTicket > 0) successClient.add(connectedClient.getKey());
        }

        String[] result = successClient.toArray(new String[0]);
        Arrays.sort(result);
        return result;
    }

    private LocalTime getLocalDateTime(String time) {
        String[] times = time.split(":");
        return LocalTime.of(Integer.parseInt(times[0]), Integer.parseInt(times[1]), Integer.parseInt(times[2]));
    }

    class Pair<K, V> {
        private K key;
        private V value;

        Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }

        K getKey() {
            return key;
        }

        V getValue() {
            return value;
        }
    }


    /*public static void main(String[] args) {
        System.out.println(Arrays.toString(
                new Ticketing().solution(
                        2,
                        new String[]{
                                "woni request 09:12:29",
                                "brown request 09:23:11",
                                "brown leave 09:23:44",
                                "jason request 09:33:51",
                                "jun request 09:33:56",
                                "cu request 09:34:02"})));
    }*/
}

