import sun.nio.cs.ext.TIS_620;

import java.util.Arrays;

/**
 * @author lin
 * @create 2020-09-30 14:31
 */
public class Main {
    public static void main(String[] args) {
        int[] scores = new int[] { 88, 77, 51, 66 };
        Score s = new Score(scores);
        s.printScores();
        scores[2] = 99;
        s.printScores();
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
