package r5a08_findmyword;

public class Score {

    private String word;
    private Letter score = Letter.INCORRECT;
    public Score(){
    }

    public Score(String word) {
        this.word = word;
    }

    public Letter letter(int i){
        return this.score;
    }

    public void assess(int i, String attempt) {
        if (this.word.equals(attempt)){
            this.score = Letter.CORRECT;
        }
    }

}
