import java.util.ArrayList;
import java.util.Comparator;

public class HighScore {
    private ArrayList<Integer> history = new ArrayList<>();
    private int[] top5 = new int[5];

    public HighScore() {
    }

    public int[] getHistory() {
        Comparator<Integer> reverse = (s1, s2) -> s2.compareTo(s1);
        history.sort(reverse);
        for (int i = 0; i < 5; i++){
            try{
                top5[i] = history.get(i);
            }
            catch (IndexOutOfBoundsException e){
            }
        }
        return top5;
    }

    public void setHistory(int i) {
        history.add(i);
    }
}
