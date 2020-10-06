import java.util.ArrayList;

/**
 * this is player class which define the players information
 * like name, account number, password
 *
 * link to the History class
 * <li>{@link History}</li>
 */
public class Player implements History{
    private String name;
    private int account;
    private int password;
    private ArrayList<String> history = new ArrayList<>();

    public void login(){

    }
    public void createAccount(){

    }

    @Override
    public String getHistory() {
        return null;
    }

    @Override
    public void setHistoryGrade() {

    }

    @Override
    public void setHistoryTime() {

    }

    @Override
    public void rank() {

    }

    @Override
    public String getHigh() {
        return null;
    }
}
