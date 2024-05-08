public class Kontingent {
    private DelfinenMedlemmer delfinenMedlemmer;

    public Kontingent(DelfinenMedlemmer delfinenMedlemmer){
        this.delfinenMedlemmer = delfinenMedlemmer;
    }
    /*
    public double beregningAfKontingent(){
        double indkomst = 0.0;
        for (Medlem medlem : delfinenMedlemmer.getMedlemskollektion()){
            public double calculateTotalExpectedIncome() {

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
        }
    }

     */
}
