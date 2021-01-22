import java.util.Comparator;

public class ArcoComparator implements Comparator<Arco>{
    @Override
    public int compare(Arco first, Arco second) {
        return Float.compare(first.getCosto(), second.getCosto());
    }
}
