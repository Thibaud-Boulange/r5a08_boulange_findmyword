package r5a08_findmyword;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
public class TestWord {

    @Test
    public void should_check_one_incorrect_letter(){
        //Arrange
        Word word = new Word("E");
        //Act
        Score score = word.guess("B");
        Letter actual = score.letter(0);
        Letter expected = Letter.INCORRECT;
        //Assert
        Assertions.assertEquals(expected,actual);

    }

    @Test
    public void should_check_one_correct_letter(){
        //Arrange
        Word word = new Word("E");
        //Act
        Score score = word.guess("E");
        Letter actual = score.letter(0);
        Letter expected = Letter.CORRECT;
        //Assert
        Assertions.assertEquals(expected,actual);

    }
}
