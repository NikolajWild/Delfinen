public class Medlem {

    private String navn;
    private int alder;
    private boolean aktivtMedlemskab;
    private boolean juniorMedlemskab = alder < 18;
    private double kredit;

Medlem(String navn, int alder, boolean aktivtMedlemskab, boolean juniorMedlemskab){
    this.navn = navn;
    this.alder = alder;
    this.aktivtMedlemskab = aktivtMedlemskab;
    this.juniorMedlemskab = juniorMedlemskab;
}
public int getAlder(){
    return alder;
}
public double getKredit(){
    return kredit;
}

public String getNavn(){
    return navn;
}

public boolean getAktivtMedlemskab(){
    return aktivtMedlemskab;
}

public boolean getJuniorMedlemskab(){
    return juniorMedlemskab;
}

public void setAlder(int alder){
     this.alder = alder;
}
public void setNavn(String navn) {
        this.navn = navn;
    }

    public void setAktivtMedlemskab(boolean aktivtMedlemskab) {
        this.aktivtMedlemskab = aktivtMedlemskab;
    }

    public void setJuniorMedlemskab(boolean juniorMedlemskab) {
        this.juniorMedlemskab = juniorMedlemskab;
    }
    public void setKredit(double kredit){
        this.kredit = kredit;
    }

    public String toString() {
        return "Navn: "  + navn + "\n" + "Alder: " + alder + "\n" + "Aktivt medlemskab: " + aktivtMedlemskab + "\n" + "Junior medlemskab: " + juniorMedlemskab;
    }
}

