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

   /*public DelfinenMedlemmer<Medlem> medlemmerMedNegativSaldo(){
        List <Medlem> medlemmerMedNegativSaldo = new ArrayList<>();
        for(Medlem medlem : delfinenMedlemmer.getMedlemskollektion()){
            if (medlem.getSaldo() <0){
                medlemmerMedNegativSaldo.add(medlem);
            }
        }
        return medlemmerMedNegativSaldo;
    }*/
}





