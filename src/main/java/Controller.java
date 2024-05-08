import java.util.ArrayList;

public class Controller {

    DelfinenMedlemmer instanceDelfinenMedlemmer = new DelfinenMedlemmer();


    public void tilføjMedlem(Medlem medlem) {
        instanceDelfinenMedlemmer.tilføjMedlem(medlem);
    }

    public void søgMedlem(String navn) {
        instanceDelfinenMedlemmer.søgMedlem(navn);
    }


    public DelfinenMedlemmer getInstanceDelfinen() {
        return instanceDelfinenMedlemmer;
    }


    public void getMåned() {
        instanceDelfinenMedlemmer.LocalDate();
    }

    public ArrayList<String> listeAfMedlemmer() {
        return instanceDelfinenMedlemmer.listeAfMedlemmer();
    }

    public ArrayList<Medlem> redigérMedlem(String navn, int redigeringsvalg, String nyVærdi) {
        instanceDelfinenMedlemmer.redigérMedlem(navn, redigeringsvalg, nyVærdi);
        return instanceDelfinenMedlemmer.getMedlemskollektion();
    }


}
