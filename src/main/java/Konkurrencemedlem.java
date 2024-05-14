import java.util.ArrayList;

public class Konkurrencemedlem extends Medlem {

    String træner = getAlder() < 18 ? "Peter Jacobsen" : "Maria Clausen";
    String hold = getAlder() < 18 ? "Ungdomshold" : "Seniorhold";
    ArrayList<SvømmedisciplinOgResultater> svømmedisciplinOgResultater = new ArrayList<>();



    public Konkurrencemedlem(String navn, int alder, boolean aktivtMedlemskab, boolean juniorMedlemskab, double saldo, String træner, String hold, ArrayList<SvømmedisciplinOgResultater> svømmedisciplinOgResultater) {
        super (navn, alder, aktivtMedlemskab, juniorMedlemskab, saldo);
        this.træner = træner;
        this.hold = hold;
        this.svømmedisciplinOgResultater = svømmedisciplinOgResultater;
    }

    public String toString() {
        return "Navn: "  + getNavn() + "\n" + "Alder: " + getAlder() + "\n" + "Aktivt medlemskab: " + getAktivtMedlemskab() + "\n" + "Junior medlemskab: " + getJuniorMedlemskab() + "\n" + "Træner: " + træner + "\n" + "Hold: " + hold;
    }
}
