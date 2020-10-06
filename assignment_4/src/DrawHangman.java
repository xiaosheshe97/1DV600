public class DrawHangman {
     private String[] hangman= new String[8];

    public DrawHangman() {
        setHangman();
    }

    public void setHangman() {
        hangman[0] =
                "    ________\n" +
                "    |\n" +
                "    |\n" +
                "    |\n" +
                "    |\n" +
                "    |\n" +
                "========\n";
        hangman[1] =
                "    ________\n" +
                "    |    |\n" +
                "    |\n" +
                "    |\n" +
                "    |\n" +
                "    |\n" +
                "========\n";
        hangman[2] =
                "    ________\n" +
                "    |    |\n" +
                "    |    o\n" +
                "    |\n" +
                "    |\n" +
                "    |\n" +
                "========\n";
        hangman[3] =
                "    ________\n" +
                "    |    |\n" +
                "    |    o\n" +
                "    |    |\n" +
                "    |\n" +
                "    |\n" +
                "========\n";
        hangman[4] =
                "    ________\n" +
                "    |    |\n" +
                "    |    o\n" +
                "    |   /|\n" +
                "    |\n" +
                "    |\n" +
                "========\n";
        hangman[5] =
                "    ________\n" +
                "    |    |\n" +
                "    |    o\n" +
                "    |   /|\\\n" +
                "    |\n" +
                "    |\n" +
                "========\n";
        hangman[6] =
                "    ________\n" +
                "    |    |\n" +
                "    |    o\n" +
                "    |   /|\\\n" +
                "    |   / \n" +
                "    |\n" +
                "========\n";
        hangman[7] =
                "    ________\n" +
                "    |    |\n" +
                "    |    o\n" +
                "    |   /|\\\n" +
                "    |   / \\\n" +
                "    |\n" +
                "========\n";
    }
    public String getPicture(int in){
        return hangman[in];
    }
}
