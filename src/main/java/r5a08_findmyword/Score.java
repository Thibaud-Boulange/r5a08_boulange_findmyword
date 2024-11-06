package r5a08_findmyword;

import java.util.ArrayList;
import java.util.List;

public class Score {

    private final String correct;
    private ArrayList<Letter> result = new ArrayList<Letter>();
    private int position = 0;

    public Score(String correct) {
        this.correct=correct;
    }

    public Letter letter(int i) {
        return result.get(i);
    }

    public void assess(String attempt) {
        for(char current : attempt.toCharArray()){
            this.result.add(scoreForLetter(current));
            this.position ++;
            }
        }

    private Letter scoreForLetter(char current) {
        if(isCorrectLetter(current)){
            return Letter.CORRECT;
        }
        if(occursInWord(current)){
            return Letter.PART_CORRECT;
        }
        return Letter.INCORRECT;
    }

    private boolean isCorrectLetter(char current) {
        return this.correct.charAt(this.position)== current;
    }

    private boolean occursInWord(char current) {
            return this.correct.contains(String.valueOf(current));
    }

    public List<Letter> letters() {
        return this.result;
    }

    public boolean allCorrect() {
        for (Letter letter : this.result) {
            if (letter != Letter.CORRECT) {
                return false;
            }
        }
        return true;
    }
}
