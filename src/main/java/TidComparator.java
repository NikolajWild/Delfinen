import java.util.Comparator;

public class TidComparator implements Comparator<SvømmedisciplinOgResultater> {

    // her bruger jeg compare metoden, som er en int da den sortere ud fra -1, <0 og >0
    public int compare(SvømmedisciplinOgResultater m1, SvømmedisciplinOgResultater m2) {
        if (m1.getResultat() < m2.getResultat()) {
            return -1;
        } else if (m1.getResultat() > m2.getResultat()) {
            return 1;
        } else {
            return 0;
        }
    }
}