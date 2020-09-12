public class Q1 {
    public int[] solution(String[] info, String[] query) {

        int[] queryScore = new int[query.length];
        for (int i = 0; i < query.length; i++) {
            queryScore[i] = Integer.parseInt(query[i].replaceAll("[^0-9]", ""));
            query[i] = query[i].replaceAll("and |- |[0-9]", "").trim();
        }

        int[] dbScore = new int[info.length];
        for (int i = 0; i < info.length; i++) {
            dbScore[i] = Integer.parseInt(info[i].replaceAll("[^0-9]| ", ""));
        }

        int[] result = new int[query.length];
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < info.length; j++) {
                if (find(info[j], query[i]) && dbScore[j] >= queryScore[i]) {
                    result[i]++;
                }
            }
        }

        return result;
    }

    private boolean find(String origin, String query) {
        String q[] = query.split(" ");
        for (String s : q) {
            if (s.isEmpty()) {
                continue;
            }
            if (!origin.contains(s)) {
                return false;
            }
        }
        return true;
    }
}
