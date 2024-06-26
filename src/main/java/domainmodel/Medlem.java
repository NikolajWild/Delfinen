package domainmodel;

public class Medlem {

    private String navn;
    private int alder;
    private boolean aktivtMedlemskab;
    private boolean juniorMedlemskab = alder < 18;
    private double saldo;


public Medlem(String navn, int alder, boolean aktivtMedlemskab, boolean juniorMedlemskab, double saldo){
    this.navn = navn;
    this.alder = alder;
    this.aktivtMedlemskab = aktivtMedlemskab;
    this.juniorMedlemskab = juniorMedlemskab;
    this.saldo = saldo;
}
public int getAlder(){
    return alder;
}
public double getSaldo(){
    return saldo;
}
public void setSaldo(){
    this.saldo = saldo;
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

    public String toString() {
        return "Navn: "  + navn  + "Alder: " + alder+ "Aktivt medlemskab: " + aktivtMedlemskab  + "Junior medlemskab: " + juniorMedlemskab;
    }
}

