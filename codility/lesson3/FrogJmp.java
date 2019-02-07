package codility.lesson3;

/**
 * @author delf
 */
public class FrogJmp {
    public int solution(int X, int Y, int D) {
        if (D == 1) {
            return Y - X;
        }
        return (int) Math.ceil((double) (Y - X) / D);
    }
}
