import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class GameControl {
    private WordsDatabase w = new WordsDatabase();
    private DrawHangman d = new DrawHangman();
    private String word;
    private HighScore highScore = new HighScore();
    private int wLength;
    private Scanner sc = new Scanner(System.in);
    private int guessTime;
    private int point;
    private PlayerDatabase playerDatabase = new PlayerDatabase();

    public GameControl() {
        word = w.getWord();
        wLength = w.getwLength();
        guessTime = 0;
        point = 0;
    }

    public void start(){
        System.out.println("Do you want to play? (Enter play or quit): ");
        String st = sc.nextLine();
        if (st.equalsIgnoreCase("play")){
            login();
        }
        else if (st.equalsIgnoreCase("quit")){
            ConfirmQuit();
            start();
        }
        else{
            System.out.println("Invalid input");
            start();
        }
    }
    public void login(){
        System.out.println("Do you want to login or create account? (Enter login, create account or quit): ");
        String st = sc.nextLine();
        if (st.equalsIgnoreCase("login")){
            System.out.print("Enter your name: ");
            String name = sc.nextLine();
            System.out.print("Enter your password: ");
            String password = sc.nextLine();
            Player player = new Player(name,password);
            boolean login = playerDatabase.login(player);
            if (!login){
                login();
                PlayGame();
            }
            else
                System.out.println("Wrong name or password");
                login();
        }
        else if (st.equalsIgnoreCase("create account")){
            System.out.print("Enter your name: ");
            String name = sc.nextLine();
            System.out.print("Enter your password: ");
            String password = sc.nextLine();
            Player player = new Player(name,password);
            playerDatabase.add(player);
            PlayGame();
        }
        else if (st.equalsIgnoreCase("quit")){
            start();
        }
        else{
            System.out.println("Invalid input");
            login();
        }
    }
    public void PlayGame(){
        //guessed word
        System.out.println("Welcome");
        String[] guess = new String[wLength];
        for (int i = 0; i < wLength; i ++){
            guess[i] = " ";
        }
        //convert word to array
        String[] wordArray = new String[wLength];
        for (int i = 0; i < wLength; i ++){
            wordArray[i] = word.charAt(i) +"";
        }
        for (int i = 0; i < wLength; i++){
            System.out.print("_ ");
        }
        //all the letter that guessed already
        ArrayList<String> letters = new ArrayList<>();
        do {
            System.out.println();
            System.out.println("Guess a letter: ");
            String st = sc.nextLine();
            //check the input is a letter
            if (isLetter(st)){
                    //check the letter have guessed before
                    if (guessed(letters,st)){
                        System.out.println("You have guessed this letter before");
                        showGuess(guess);
                    }
                    else if (word.contains(st)){
                        System.out.println("Correct guess");
                        point++;
                        for (int i = 0; i < wordArray.length; i++){
                            int index = 0;
                            if (wordArray[i].equalsIgnoreCase(st)){
                                index = i;
                                guess[i] = st;
                            }
                        }
                        showGuess(guess);
                    }
                    else {
                        guessTime++;
                        System.out.println("Wrong guess and you have " + (8-guessTime) + " times only");
                        wrongGuess(guessTime-1);
                        showGuess(guess);
                    }
                    letters.add(st);

            }
            else{
                System.out.println("Invalid input");
            }
            if (guessTime == 8){
                break;
            }
        }while (!Arrays.equals(guess, wordArray));
        System.out.println();
        if (Arrays.equals(guess, wordArray)){
            System.out.println("You win and your point is " + point);
            highScore.setHistory(point);
        }
        else {
            System.out.println("You lose");
        }
        ViewHighScore();
        Restart();
    }
    public void Quit(){
        System.out.println("Bye Bye");
        System.exit(0);
    }
    public void ConfirmQuit(){
        System.out.println("Are you sure to quit? (Enter quit or not) ");
        String st = sc.nextLine();
        if (st.equalsIgnoreCase("quit")){
            Quit();
        }
        else if (st.equalsIgnoreCase("not")){
        }
        else {
            System.out.println("Invalid input");
            ConfirmQuit();
        }
    }
    public void Restart(){
        System.out.println("Do you want to restart game? (Enter restart or no)");
        String st = sc.nextLine();
        if (st.equalsIgnoreCase("restart")){
            word = w.getWord();
            wLength = w.getwLength();
            guessTime = 0;
            point = 0;
            start();
        }
        else if (st.equalsIgnoreCase("no")){
            Quit();
        }
        else {
            System.out.println("Invalid input");
            Restart();
        }
    }
    public void wrongGuess(int i){
        System.out.println(d.getPicture(i));
    }
    public void showGuess(String[] guess){
        for (String s:guess) {
            System.out.print(s +" ");
        }
        System.out.println();
        for (int i = 0; i < wLength; i++){
            System.out.print("_ ");
        }
    }
    public boolean guessed(ArrayList<String> guess, String st){
        boolean guessed = false;
        for (String s : guess) {
            if (s.equalsIgnoreCase(st)) {
                guessed = true;
                break;
            }
        }
        return guessed;
    }
    public void ViewHighScore(){
        System.out.println("Do you want to see high score list? (Enter yes or no)");
        String st = sc.nextLine();
        if (st.equalsIgnoreCase("yes")){
            System.out.println(Arrays.toString(highScore.getTop5(highScore.getHistory())));
        }
        else if (st.equalsIgnoreCase("no")){
        }
        else{
            System.out.println("Invalid input");
            ViewHighScore();
        }
    }
    public boolean isLetter(String st){
        if (st.length() == 1){
            return Character.isLetter(st.charAt(0));
        }
        return false;
    }
}
