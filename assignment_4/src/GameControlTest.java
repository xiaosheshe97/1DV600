import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class GameControlTest {
    private ArrayList<String> strings = new ArrayList<>();
    GameControl gameControl = new GameControl();
    private ArrayList<Integer> history = new ArrayList<>();
    HighScore highScore = new HighScore();


    @Test
    //when guess the first letter, the arrayList is empty
    void guessed1() {
        boolean actual = gameControl.guessed(strings,"GuessOne");
        assertFalse(actual);
    }

    @Test
    //when one guess already be made, the arrayList is not empty, the arrayList contain the guess string
    void guessed2() {
        strings.add("Guessed");
        boolean actual = gameControl.guessed(strings,"Guessed");
        assertTrue(actual);
    }

    @Test
    //when one guess already be made, the arrayList is not empty the arrayList dosen't contain the guess string
    void guessed3() {
        boolean actual = gameControl.guessed(strings,"Guess");
        assertFalse(actual);
    }

    @Test
    void isLetter1(){
        String s = "word";
        boolean actual = gameControl.isLetter(s);
        assertFalse(actual);
    }
    @Test
    void isLetter2(){
        String s = "w";
        boolean actual = gameControl.isLetter(s);
        assertTrue(actual);
    }
    @Test
    void isLetter3(){
        String s = "1";
        boolean actual = gameControl.isLetter(s);
        assertFalse(actual);
    }
    @Test
    //test the method in HighScore class
    void getHistory(){
        history.add(3);
        history.add(1);
        history.add(5);

        int[] top5 = new int[5];
        top5 = highScore.getTop5(history);

        //the top5 should be sorted
        //implement the comment in HighScore class will let the test success
        for (int i = 0;i<4;i++) {
            assertTrue(top5[i] >= top5[i+1]);
        }
    }
}