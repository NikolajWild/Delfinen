import java.util.Comparator;
public class SvømmedisciplinsResultatComparator implements Comparator<SvømmedisciplinOgResultater> {

        // her bruger jeg compare metoden, som er en int da den sortere ud fra -1, <0 og >0
        public int compare (SvømmedisciplinOgResultater m1, SvømmedisciplinOgResultater m2) {
            return m1.getSvømmedisciplin().compareTo(m2.getSvømmedisciplin());
        }
    }

