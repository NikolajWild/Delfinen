package domainmodel;

import java.util.Comparator;
public class KonkurrenceMedlemsResultatComparator implements Comparator<Konkurrencemedlem> {
        // her bruger jeg compare metoden, som er en int da den sortere ud fra -1, <0 og >0
        public int compare(Konkurrencemedlem medlem1, Konkurrencemedlem medlem2) {
            // Iterer gennem hver disciplin og find det bedste resultat for hvert medlem
            return Double.compare(medlem1.getSvømmedisciplinOgResultater().getResultat(),
                    medlem2.getSvømmedisciplinOgResultater().getResultat());

        }

}
