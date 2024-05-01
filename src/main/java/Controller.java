import java.util.ArrayList;

public class Controller {

    Delfinen instanceDelfinen = new Delfinen();


    public void tilføjMedlem(String navn, int alder, boolean aktivtMedlemskab, boolean juniorMedlemskab, boolean motionistSvømmer) {
        instanceDelfinen.tilføjMedlem(navn, alder, aktivtMedlemskab, juniorMedlemskab, motionistSvømmer);
    }

    public ArrayList<Medlemmer> findMedlem(String navn) {
        return instanceDelfinen.søgMedlem(navn);
    }


    public Delfinen getInstanceDelfinen() {
        return instanceDelfinen;
    }


    public void getMåned() {
        instanceDelfinen.LocalDate();
    }


}
