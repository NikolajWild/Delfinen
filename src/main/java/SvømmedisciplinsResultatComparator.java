import java.util.Comparator;
public class SvømmedisciplinsResultatComparator implements Comparator<Konkurrencemedlem> {
        // her bruger jeg compare metoden, som er en int da den sortere ud fra -1, <0 og >0
        public int compare(Konkurrencemedlem medlem1, Konkurrencemedlem medlem2) {
            // Iterer gennem hver disciplin og find det bedste resultat for hvert medlem
            double bedsteResultat1 = Double.MAX_VALUE;
            for (SvømmedisciplinOgResultater disciplin : medlem1.getSvømmedisciplinOgResultater()) {
                double resultat = disciplin.getResultat();
                if (resultat < bedsteResultat1) {
                    bedsteResultat1 = resultat;
                }
            }




            double bedsteResultat2 = Double.MAX_VALUE;
            for (SvømmedisciplinOgResultater disciplin : medlem2.getSvømmedisciplinOgResultater()) {
                double resultat = disciplin.getResultat();
                if (resultat < bedsteResultat2) {
                    bedsteResultat2 = resultat;
                }
            }

            // Sammenlign de bedste resultater for de to medlemmer
            if (bedsteResultat1 < bedsteResultat2) {
                return -1;
            } else if (bedsteResultat1 > bedsteResultat2) {
                return 1;
            } else {
                return 0;
            }
        }

}
