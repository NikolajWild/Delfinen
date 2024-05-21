import java.util.Comparator;
public class DisciplinComparator implements Comparator<Konkurrencemedlem> {
    // her bruger jeg compare metoden, som er en int da den sortere ud fra -1, <0 og >0
    public int compare(Konkurrencemedlem medlem1, Konkurrencemedlem medlem2) {
        // Iterer gennem hver disciplin og find det bedste resultat for hvert medlem
        return CharSequence.compare(medlem1.getSvømmedisciplinOgResultater().getSvømmedisciplin(),
                medlem2.getSvømmedisciplinOgResultater().getSvømmedisciplin());
    }
}
