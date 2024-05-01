import java.util.ArrayList;

public class Delfinen {

    private ArrayList<Medlemmer> medlemskollektion;

    public ArrayList<Medlemmer> getMedlemskollektion(){
        return medlemskollektion;
    }


    //laver en arraylist til søgemetode
    public ArrayList<Medlemmer> searchMatch = new ArrayList<>();


    public void tilføjMedlem(String navn, int alder, boolean aktivtMedlemskab, boolean juniorMedlemskab) {
        medlemskollektion.add(new Medlemmer(navn, alder, aktivtMedlemskab, juniorMedlemskab));
    //to do lav save funktion her.
    }



}
