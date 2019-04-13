package codingtest.naverhackday2019;


import java.util.HashSet;
import java.util.Set;

public class Q2 {

    Set<Integer> set = new HashSet<>();

    public int solution(Tree tree) {

        return find(tree);
    }

    private int find(Tree t) {
        System.out.println(set);
        if (set.contains(t.x)) {
            return set.size();
        }

        set.add(t.x);
        int r = 0;
        int l = 0;
        if (t.l != null) {
            l = find(t.l);
        }

        if (t.r != null) {
            r = find(t.r);
        }
        int size = set.size();
        set.remove(t.x);
        return Math.max(Math.max(l, r), size);
    }

    static class Tree {
        int x;
        Tree l;
        Tree r;

        Tree(int x, Tree l, Tree r) {
            this.x = x;
            this.l = l;
            this.r = r;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            if (l != null) {
                sb.append(l.x);
            }
            sb.append("-" + x + "-");
            if (r != null) {
                sb.append(r.x);
            }
            return sb.toString();
        }
    }

    public static void main(String[] args) {
        // (4, (5, (4, (5, None, None), None), None), (6, (1, None, None), (6, None, None)))
        Tree t = new Tree(4, new Tree(5, new Tree(4, new Tree(5, null, null), null), null), new Tree(6, new Tree(1, null, null), new Tree(6, null, null)));

        System.out.println(new Q2().solution(t));
    }
}

