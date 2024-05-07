import java.util.ArrayList;

public class Controller {

    DelfinenMedlemmer instanceDelfinenMedlemmer = new DelfinenMedlemmer();


    public void tilføjMedlem(Medlem medlem) {
        instanceDelfinenMedlemmer.tilføjMedlem(medlem);
    }

    public ArrayList<Medlem> findMedlem(String navn) {
        return instanceDelfinenMedlemmer.søgMedlem(navn);
    }


    public DelfinenMedlemmer getInstanceDelfinen() {
        return instanceDelfinenMedlemmer;
    }


    public void getMåned() {
        instanceDelfinenMedlemmer.LocalDate();
    }


}
