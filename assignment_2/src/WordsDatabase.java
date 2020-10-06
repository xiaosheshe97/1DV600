import java.util.Random;

public class WordsDatabase {
    private String[] wordsDatabase = {"wave"};
    /* "axiom", "azure","bagpipes", "beekeeper", "bikini", "blitz" ,
                "blizzard", "boggle", "buxom" ,"caliph", "cobweb", "curacao", "disavow", "dizzying", "embezzle",
                "euouae", "fishhook", "fixable", "fluffiness", "flyby", "gabby", "glowworm", "glyph", "haphazard",
                "hyphen", "ivory", "jaundice", "jawbreaker", "jiujitsu", "kazoo", "larynx", "lengths", "microwave",
                "rhubarb", "strength", "topaz", "uptown", "wave", "witchcraft", "youthful", "zipper"

     */
    private String word;
    private int wLength;

    public WordsDatabase() {
        setWord();
    }

    public String getWord() {
        return word;
    }

    public void setWord() {
        Random rnd = new Random();
        int index = rnd.nextInt(wordsDatabase.length);
        this.word = wordsDatabase[index];
    }
    public int getwLength(){
        return word.length();
    }
}
