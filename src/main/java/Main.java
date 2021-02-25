
import java.util.Arrays;

/**
 * @author lin
 * @create 2020-09-30 14:31
 */
public class Main {
    public static void main(String[] args) {

    }
}

class Score {
    private int[] scores;
    public Score(int[] scores) {
        // this.scores = Arrays.copyOf(scores, scores.length);
        this.scores = scores;
    }

    public void printScores() {
        System.out.println(Arrays.toString(scores));
    }
}
