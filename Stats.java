import java.util.ArrayList;

public class Stats {
    private ArrayList<ScoreInfo> scoreList;

    // listed in increasing score order; no two ScoreInfo objects contain the same
    // score
    /**
     * Records a score in the database, keeping the database in increasing score
     * order. If no other ScoreInfo object represents score, a new ScoreInfo object
     * representing score is added to the database; otherwise, the frequency in the
     * ScoreInfo object representing score is incremented.
     * 
     * @param score a score to be recorded in the list
     * @return true if a new ScoreInfo object representing score was added to the
     *         list; false otherwise
     */
    public boolean record(int score) {
        int pos = scoreList.size();
        while(pos-1 >= 0 && scoreList.get(pos-1).getScore() >= score) {
          pos--;
        }
        if(pos == scoreList.size() || scoreList.get(pos).getScore() != score) {
            scoreList.add(pos, new ScoreInfo(score));
            return true;
        }
        scoreList.get(pos).increment();
        return false;
    }

    /**
     * Records all scores in stuScores in the database, keeping the database in
     * increasing score order
     * 
     * @param stuScores an array of student test scores
     */
    public void recordScores(int[] stuScores) {
        for (int i : stuScores) {
            record(i);
        }
    }

}
