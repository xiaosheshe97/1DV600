public interface GameInterface {
    void login();
    void createAccount();
    void greeting();      //start game
    String getWords();    //get words from database
    void printNum();      //show number of letter
    void drawLine();      //basic number of letter to draw lines
    boolean check();      //check the letter is correct
    void letter();        //if correct display the number
    void draw();          //if not correct draw picture

}
