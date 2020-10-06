import java.util.ArrayList;
import java.util.Random;

/**
 * this class define the word used in game
 * the word is came from words database by extends WordsData class
 *
 * <li>{@link WordsData}</li>
 * @author Xiaohe Zhu
 * @since 2020-02-02
 */
public class Word extends WordsData{
    private int numOfLetter;
    private String word;

    public Word() {
        numOfLetter = 0;
        word = "";
    }

    //get random word
    public String getWord() {
        return word;
    }

    public void setWord(){
        Random rnd = new Random();
        int rndNum = rnd.nextInt(words.size());
        this.word = words.get(rndNum);
    }

    public int getNumOfLetter(){
        numOfLetter = word.length();
        return numOfLetter;
    }
}
