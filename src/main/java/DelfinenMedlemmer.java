import java.time.LocalDate;
import java.util.*;

public class DelfinenMedlemmer {

    private ArrayList<Medlem> medlemskollektion = new ArrayList<>();

    private FileHandler fileHandler;

    private ArrayList<Konkurrencemedlem> konkurrencemedlemsKollektion = new ArrayList<>();

    public DelfinenMedlemmer(){
        this.fileHandler = new FileHandler();
        this.medlemskollektion = fileHandler.loadMedlemdsData();
    }



    public ArrayList<Medlem> getMedlemskollektion() {
        return medlemskollektion;
    }
    public ArrayList<Konkurrencemedlem>getKonkurrencemedlemsKollektion(){
        return konkurrencemedlemsKollektion;
    }

    //viser dag i måned (now og of er vigtige)
    public static void LocalDate() {
        LocalDate herognu = LocalDate.now();
        int dagIMåned = herognu.getDayOfMonth();
        System.out.println(dagIMåned);
    }

    //laver en arraylist til søgemetode
    public ArrayList<Medlem> searchMatch = new ArrayList<>();

    //Søger et medlem
    public void søgMedlem(String navn) {
        searchMatch.clear();
        for (Medlem medlem : medlemskollektion) {
            if (medlem.getNavn().toLowerCase().contains(navn.toLowerCase())) {
                searchMatch.add(medlem);
            }
        }
    }

    //Redigér i medlemslisten
    public ArrayList<Medlem> redigérMedlem(String navn, int redigeringsvalg, String nyVærdi) {
        for (Medlem medlem : medlemskollektion) {
            if (medlem.getNavn().toLowerCase().contains(navn.toLowerCase())) {
                switch (redigeringsvalg) {
                    case 1:
                        medlem.setNavn(nyVærdi);
                        break;
                    case 2:
                        int nyAlder = Integer.parseInt(nyVærdi);
                        medlem.setAlder(nyAlder);
                        medlem.setJuniorMedlemskab(nyAlder < 18);
                        break;
                    case 3:
                        boolean nytAktivtMedlemskab = Boolean.parseBoolean(nyVærdi);
                        medlem.setAktivtMedlemskab(nytAktivtMedlemskab);
                        break;
                    case 4:
                        boolean nytKonkurrenceMotionistSvømmer = Boolean.parseBoolean(nyVærdi);
                        medlem.setJuniorMedlemskab(nytKonkurrenceMotionistSvømmer);
                        break;
                    case 5:
                        if (medlem instanceof Konkurrencemedlem) {
                        Konkurrencemedlem konkurrenceMedlem = (Konkurrencemedlem) medlem;
                        konkurrenceMedlem.setDisciplin((nyVærdi));

                    }
                    case 6:
                        if (medlem instanceof Konkurrencemedlem) {
                        Konkurrencemedlem konkurrenceMedlem = (Konkurrencemedlem) medlem;
                        konkurrenceMedlem.setResultat(Double.parseDouble(nyVærdi));
                    }

                }

            }
        }
        fileHandler.gemListeAfMedlemmer(medlemskollektion);
        return medlemskollektion;
    }



    public void tilføjMedlem(Medlem medlem) {
        medlemskollektion.add(medlem);

        fileHandler.gemListeAfMedlemmer(medlemskollektion);
    }

    public ArrayList<String> listeAfMedlemmer() {
        ArrayList<String> listeAfMedlemmer = new ArrayList<>();
        for (Medlem medlem: medlemskollektion) {
            listeAfMedlemmer.add(medlem.toString());
        }
        return listeAfMedlemmer;
    }

    public ArrayList<String> listeAfKonkurrence() {
        ArrayList<String> listeAfKonkurrence = new ArrayList<>();
        for (Konkurrencemedlem konkurrencemedlem: konkurrencemedlemsKollektion) {
            listeAfKonkurrence.add(konkurrencemedlem.toString());
        }
        return listeAfKonkurrence;
    }

   /* public List<Konkurrencemedlem> top5Bedste(){
        sorterResultater();
        List<Konkurrencemedlem> top5= new ArrayList<>();
        for (int i = 0; i<5&& i<konkurrencemedlemsKollektion.size(); i++) {
            top5.add(konkurrencemedlemsKollektion.get(i));
        }
        return top5;
    }*/
    public ArrayList<Konkurrencemedlem> top5Bedste(){
        ArrayList<Konkurrencemedlem> crawl = new ArrayList<>();
        ArrayList<Konkurrencemedlem> rygCrawl = new ArrayList<>();
        ArrayList<Konkurrencemedlem> butterfly = new ArrayList<>();
        ArrayList<Konkurrencemedlem> brystsvømning = new ArrayList<>();

        sorterResultater();
        ArrayList<Konkurrencemedlem> top5AlleDiscipliner = new ArrayList<>();
        for (Konkurrencemedlem konkurrencemedlem : konkurrencemedlemsKollektion) {
            if (konkurrencemedlem.getDisciplin().toLowerCase().equals("crawl")) {
                crawl.add(konkurrencemedlem);
                //return top5Crawl;
            } else if (konkurrencemedlem.getDisciplin().toLowerCase().equals("rygcrawl")) {
                rygCrawl.add(konkurrencemedlem);
                // return top5RygCrawl;
            } else if (konkurrencemedlem.getDisciplin().toLowerCase().equals("butterfly")) {
                butterfly.add(konkurrencemedlem);
                // return top5Butterfly;
            } else if (konkurrencemedlem.getDisciplin().toLowerCase().equals("brystsvømning")) {
                brystsvømning.add(konkurrencemedlem);
                // return top5Brystsvømning;
            }
        }
            for (int i = 0; i<5&& i<crawl.size(); i++) {
                top5AlleDiscipliner.add(crawl.get(i));
            }
            for (int i = 0; i<5&& i<rygCrawl.size(); i++) {
                top5AlleDiscipliner.add(rygCrawl.get(i));
            }
            for (int i = 0; i<5&& i<butterfly.size(); i++) {
                top5AlleDiscipliner.add(butterfly.get(i));
            }
            for (int i = 0; i<5&& i<brystsvømning.size(); i++) {
                top5AlleDiscipliner.add(brystsvømning.get(i));
            }
        return top5AlleDiscipliner;
    }

    public ArrayList<Konkurrencemedlem> sorterResultater() {
        konkurrencemedlemsKollektion.clear();
        for (Medlem medlem:medlemskollektion){
            if (medlem instanceof Konkurrencemedlem){
                konkurrencemedlemsKollektion.add((Konkurrencemedlem) medlem);
            }
        }
        konkurrencemedlemsKollektion.sort(new KonkurrenceMedlemsResultatComparator());
        return konkurrencemedlemsKollektion;
    }
    public ArrayList<Konkurrencemedlem> sorterDisciplin() {
        konkurrencemedlemsKollektion.clear();
        for (Medlem medlem:medlemskollektion){
            if (medlem instanceof Konkurrencemedlem){
                konkurrencemedlemsKollektion.add((Konkurrencemedlem) medlem);
            }
        }
        konkurrencemedlemsKollektion.sort(new DisciplinComparator());
        return konkurrencemedlemsKollektion;
    }

}
