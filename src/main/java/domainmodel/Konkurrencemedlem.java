package domainmodel;

import java.time.LocalDate;

public class Konkurrencemedlem extends Medlem {

    private String træner = getAlder() < 18 ? "Peter Jacobsen" : "Maria Clausen";
    private String hold = getAlder() < 18 ? "Ungdomshold" : "Seniorhold";
    private SvømmedisciplinOgResultater svømmedisciplinOgResultater;
    LocalDate resultater = LocalDate.now();

    public String getTræner() {
        return træner;
    }

    public String getHold() {
        return hold;
    }

    public SvømmedisciplinOgResultater getSvømmedisciplinOgResultater() {
        return svømmedisciplinOgResultater;
    }

    public Konkurrencemedlem(String navn, int alder, boolean aktivtMedlemskab, boolean juniorMedlemskab, double saldo, String træner, String hold, SvømmedisciplinOgResultater svømmedisciplinOgResultater) {
        super(navn, alder, aktivtMedlemskab, juniorMedlemskab, saldo);
        this.træner = træner;
        this.hold = hold;
        this.svømmedisciplinOgResultater = svømmedisciplinOgResultater;
    }

    public String toString() {
        return "\nNavn: " + getNavn() + "\n" + "Alder: " + getAlder() + "\n" + "Aktivt medlemskab: " + getAktivtMedlemskab() + "\n" + "Junior medlemskab: " + getJuniorMedlemskab() + "\n" + "Træner: " + træner + "\n" + "Hold: " + hold + "\nResultater- " + getSvømmedisciplinOgResultater();
    }

    public double getTid() {
        return svømmedisciplinOgResultater.getResultat();
    }

    public void setResultat(double resultat) {
        svømmedisciplinOgResultater.setResultat(resultat);
    }
    public String getDisciplin(){
        return svømmedisciplinOgResultater.getSvømmedisciplin();
    }
    public void setDisciplin(String svømmeDisciplin){
        svømmedisciplinOgResultater.setSvømmedisciplin(svømmeDisciplin);
    }
}


