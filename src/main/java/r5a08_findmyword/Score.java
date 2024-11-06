package r5a08_findmyword;

import java.util.ArrayList;
import java.util.List;

public class Score {

    private final String correct;
    private ArrayList<Letter> result = new ArrayList<Letter>();

    public Score(String correct) {
        this.correct=correct;
        for(int i=0; i < correct.length(); i++){
            result.add(Letter.INCORRECT);
        }
    }

    public Letter letter(int i) {
        return result.get(i);
    }

    public void assess(String attempt) {
        for(int position=0; position < attempt.length() && position < this.correct.length(); position++)
            if (this.correct.charAt(position)==attempt.charAt(position)){
                result.set(position, Letter.CORRECT);
            }
            else if (occursInWord(attempt.charAt(position)) && attempt.indexOf(attempt.charAt(position)) == position){
                result.set(position, Letter.PART_CORRECT);
            }

        }

    private boolean occursInWord(char current) {
        for (int position=0;position<this.correct.length();position++){
            if (this.correct.charAt(position)==current){
                return true;
            }
        }
        return false;
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
