package domainmodel;

import java.util.ArrayList;
import java.util.List;


public class Controller {

    public DelfinenMedlemmer instanceDelfinenMedlemmer = new DelfinenMedlemmer();
    Kontingent kontingent = new Kontingent(instanceDelfinenMedlemmer);


    public void tilføjMedlem(Medlem medlem) {
        instanceDelfinenMedlemmer.tilføjMedlem(medlem);
    }

    public void søgMedlem(String navn) {
        instanceDelfinenMedlemmer.søgMedlem(navn);
    }


    public ArrayList<Konkurrencemedlem> getKonkurrenceMedlem() {
        return instanceDelfinenMedlemmer.getKonkurrencemedlemsKollektion();
    }

    public ArrayList<Medlem> redigerSvømmedisciplinOgResultater(String navn, String nyDisciplin, double nytResultat, int nytÅr, int nyMåned, int nyDag) {
        instanceDelfinenMedlemmer.redigerSvømmedisciplingOgResultat(navn, nyDisciplin, nytResultat, nytÅr, nyMåned, nyDag);
        return instanceDelfinenMedlemmer.getMedlemskollektion();
    }

    public void getMåned() {
        instanceDelfinenMedlemmer.LocalDate();
    }

    public ArrayList<String> listeAfMedlemmer() {
        return instanceDelfinenMedlemmer.listeAfMedlemmer();
    }

    public ArrayList<String> listeAfKonkurrence() {
        return instanceDelfinenMedlemmer.listeAfKonkurrence();
    }

    public ArrayList<Medlem> redigérMedlem(String navn, int redigeringsvalg, String nyVærdi) {
        instanceDelfinenMedlemmer.redigérMedlem(navn, redigeringsvalg, nyVærdi);
        return instanceDelfinenMedlemmer.getMedlemskollektion();
    }
    public double beregningAfKontingent(){
       return kontingent.beregningAfKontingent();
    }

    public List<Medlem> medlemmerMedNegativSaldo(){
        return kontingent.findMedlemmerIRestance();
    }
    public ArrayList<Konkurrencemedlem> sorterMedlemmer(){
        return instanceDelfinenMedlemmer.sorterResultater();
    }
    public ArrayList<Konkurrencemedlem> sorterDisciplin(){
        return instanceDelfinenMedlemmer.sorterDisciplin();
    }
    public ArrayList<Konkurrencemedlem> top5Bedste(){
       return instanceDelfinenMedlemmer.top5Bedste();
    }
}
