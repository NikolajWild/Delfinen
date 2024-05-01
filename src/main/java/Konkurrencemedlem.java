import java.util.ArrayList;

public class Konkurrencemedlem extends Medlemmer{

    String træner;
    String hold = getAlder() < 18 ? "Ungdomshold" : "Seniorhold";
    ArrayList<SvømmedisciplinOgResultater> svømmedisciplinOgResultater;



    public Konkurrencemedlem(String navn, int alder, boolean aktivtMedlemskab, boolean juniorMedlemskab, String træner, String hold, ArrayList<SvømmedisciplinOgResultater> svømmedisciplinOgResultater) {
        super (navn, alder, aktivtMedlemskab, juniorMedlemskab);
        this.træner = træner;
        this.hold = hold;
        this.svømmedisciplinOgResultater = svømmedisciplinOgResultater;
    }
}
