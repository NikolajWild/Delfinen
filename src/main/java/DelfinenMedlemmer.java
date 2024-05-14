import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DelfinenMedlemmer {

    private ArrayList<Medlem> medlemskollektion = new ArrayList<>();

    private FileHandler fileHandler;

    public DelfinenMedlemmer(){
        this.fileHandler = new FileHandler();
        this.medlemskollektion = fileHandler.loadMedlemdsData();
    }



    public ArrayList<Medlem> getMedlemskollektion() {
        return medlemskollektion;
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
                }

            }
        }
        fileHandler.gemListeAfMedlemmer(medlemskollektion);
        return medlemskollektion;
    }


    public void tilføjMedlem(Medlem medlem) {
        medlemskollektion.add(medlem);

        fileHandler.gemListeAfMedlemmer(medlemskollektion);

        //to do lav save funktion her.
    }

    public ArrayList<String> listeAfMedlemmer() {
        ArrayList<String> listeAfMedlemmer = new ArrayList<>();
        for (int i = 0; i < medlemskollektion.size(); i++) {
            listeAfMedlemmer.add(medlemskollektion.get(i).toString());
        }
        return listeAfMedlemmer;
    }


    public List<Medlem> findMedlemmerIRestance() {
        List<Medlem> medlemmerIRestance = new ArrayList<>();
        for (Medlem medlem : medlemskollektion) {
            double kontingent = 0.0;
            if (medlem.getAktivtMedlemskab()) {
                if (medlem.getAlder() < 18) {
                    kontingent += 1000;
                } else if (medlem.getAlder() >= 60) {
                    kontingent += 1600 * 0.75;
                } else {
                    kontingent += 1600;
                }
            } else {
                kontingent += 500;
            }
            if (medlem.getSaldo() < kontingent){
                medlemmerIRestance.add(medlem);
            }
        }
        return medlemmerIRestance;
    }//asd
}
