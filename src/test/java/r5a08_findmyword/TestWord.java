package r5a08_findmyword;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class TestWord {

    private static void checkAllCombinaison(Score score, Letter... expected) {
        Assertions.assertEquals(score.letters(), Arrays.asList(expected));
    }

    @Test
    public void should_check_one_incorrect_letter(){
        //Arrange
        Word word = new Word("E");
        //Act
        Score score = word.guess("B");
        //Assert
        checkAllCombinaison(score, Letter.INCORRECT);

    }

    @Test
    public void should_check_one_correct_letter(){
        //Arrange
        Word word = new Word("E");
        //Act
        Score score = word.guess("E");
        //Assert
        checkAllCombinaison(score, Letter.CORRECT);

    }

    @Test
    public void should_check_all_incorrect_letters(){
        //Arrange
        Word word = new Word("Te");
        //Act
        Score score = word.guess("ai");
        //Assert
        checkAllCombinaison(score,
                Letter.INCORRECT,
                Letter.INCORRECT);

    }

    @Test
    public void should_check_all_correct_letters(){
        //Arrange
        Word word = new Word("Test");
        //Act
        Score score = word.guess("Test");
        //Assert
        Assertions.assertTrue(score.allCorrect());

    }

    @Test
    public void should_check_one_correct_letter_one_incorrect_letter(){
        //Arrange
        Word word = new Word("Te");
        //Act
        Score score = word.guess("Ta");
        //Assert
        checkAllCombinaison(score,
                Letter.CORRECT,
                Letter.INCORRECT);
    }

    @Test
    public void should_check_one_correct_wrong_placed_letter_and_all_incorrect_letters(){
        //Arrange
        Word word = new Word("pris");
        //Act
        Score score = word.guess("Bien");
        //Assert
        checkAllCombinaison(score,
                Letter.INCORRECT,
                Letter.PART_CORRECT,
                Letter.INCORRECT,
                Letter.INCORRECT);
    }

    @Test
    public void should_check_all_correct_wrong_placed_letters(){
        //Arrange
        Word word = new Word("eT");
        //Act
        Score score = word.guess("Te");
        //Assert
        checkAllCombinaison(score,
                Letter.PART_CORRECT,
                Letter.PART_CORRECT);
    }


}
