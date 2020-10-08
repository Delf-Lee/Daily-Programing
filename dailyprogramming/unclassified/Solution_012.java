package unclassified;

public class Solution_012 {
    private char[] friends = {'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T'};
    public int getCase(String[] conditions) {
        int cnt = 0;
        boolean isPass;
        char[][] arrConditions = toCharArrConditions(conditions);
        do {
            isPass = true;
            for (char[] c : arrConditions) {
                isPass &= check(friends, c);
            }
            if (isPass) cnt++;
        } while (nextPermutation(friends));
        return cnt;
    }

    private char[][] toCharArrConditions(String[] conditions) {
        char[][] arrConditions = new char[conditions.length][];
        for (int i = 0; i < conditions.length; i++) {
            arrConditions[i] = conditions[i].toCharArray();
        }
        return arrConditions;
    }

    private void swap(char[] arr, int c1, int c2) {
        char tmp = arr[c1];
        arr[c1] = arr[c2];
        arr[c2] = tmp;
    }

    private boolean check(char[] friends, char[] condition) {
        String sFriends = String.valueOf(friends);
        int diff = Math.abs(sFriends.indexOf(condition[0]) - sFriends.indexOf(condition[2])) - 1;
        int dist = Character.getNumericValue(condition[4]);
        boolean isPass = false;
        switch (condition[3]) {
            case '=':
                return diff == dist;
            case '>':
                return diff > dist;
            case '<':
                return diff < dist;
        }
        return isPass;
    }

    private boolean nextPermutation(char[] arr) {
        int n = arr.length;
        int i = n - 1, j = n - 1;
        while (i > 0 && arr[i - 1] >= arr[i]) i -= 1;
        if (i <= 0) return false;

        while (arr[i - 1] >= arr[j]) j -= 1;
        swap(arr, i - 1, j);
        j = n - 1;
        while (i < j) {
            swap(arr, i, j);
            i += 1;
            j -= 1;
        }
        return true;
    }

    /*public static void main(String args[]) {
        Scanner scnr = new Scanner(System.in);
        int nCondition = scnr.nextInt();
        String[] conditions = new String[nCondition];
        for (int i = 0; i < nCondition; i++)
            conditions[i] = scnr.next();
        char[] friends = {'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T'};
        // String[] conditions = {"N~F=0", "R~T>2"};
        System.out.println(new Solution_012().solution(friends, conditions));
    }*/
}