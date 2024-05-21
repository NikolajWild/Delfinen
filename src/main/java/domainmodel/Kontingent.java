package domainmodel;

import java.util.ArrayList;
import java.util.List;


public class Kontingent {
    private DelfinenMedlemmer delfinenMedlemmer;

    public Kontingent(DelfinenMedlemmer delfinenMedlemmer){
        this.delfinenMedlemmer = delfinenMedlemmer;
    }

    public double beregningAfKontingent(){
        double indkomst = 0.0;
        for (Medlem medlem : delfinenMedlemmer.getMedlemskollektion()){
                    if (medlem.getAktivtMedlemskab()) {
                        if (medlem.getAlder() < 18) {
                            indkomst += 1000;
                        } else if (medlem.getAlder() >= 60) {
                            indkomst += 1600 * 0.75;
                        } else {
                            indkomst += 1600;
                        }
                    } else {
                        indkomst += 500;
                    }
                } return indkomst;
            }
    public List<Medlem> findMedlemmerIRestance() {
        List<Medlem> medlemmerIRestance = new ArrayList<>();
        for (Medlem medlem : delfinenMedlemmer.getMedlemskollektion()) {
            double kontingent = 0.0;
            if (medlem.getAktivtMedlemskab()) {
                if (medlem.getAlder() < 18) {
                    kontingent += 1000;
                } else if (medlem.getAlder() >= 60) {
                    kontingent += 1600 * 0.75;
                } else {
                    kontingent += 1600;
                }
            } else {
                kontingent += 500;
            }
            if (medlem.getSaldo() < kontingent){
                medlemmerIRestance.add(medlem);
            }
        }
        return medlemmerIRestance;
    }
}





