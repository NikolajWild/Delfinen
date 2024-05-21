public class SvømmedisciplinOgResultater {

    private String svømmedisciplin;
    private double resultat;
    private int år;
    private int måned;
    private int dag;

    public SvømmedisciplinOgResultater(String svømmedisciplin, double resultat, int år, int måned, int dag) {
        this.svømmedisciplin = svømmedisciplin;
        this.resultat = resultat;
        this.år = år;
        this.måned = måned;
        this.dag = dag;
    }

    @Override
    public String toString() {
        return "svømmedisciplin: " + svømmedisciplin+ " Resultat i sekunder: " + resultat +" Dato: " + dag + "/"+måned+"-"+år;

    }


////////////////////////
    // NOGET DATO HER EVT //
    ////////////////////////



    public String getSvømmedisciplin(){
        return svømmedisciplin;
    }

    public double getResultat(){
        return resultat;
    }

    public int getÅr() {
        return år;
    }

    public int getMåned() {
        return måned;
    }

    public int getDag() {
        return dag;
    }

    public void setSvømmedisciplin(String svømmedisciplin){
        this.svømmedisciplin = svømmedisciplin;
    }

    public void setResultat(double resultat){
        this.resultat = resultat;
    }

    public void setÅr(int år) {
        this.år = år;
    }

    public void setMåned(int måned) {
        this.måned = måned;
    }

    public void setDag(int dag) {
        this.dag = dag;
    }
}
