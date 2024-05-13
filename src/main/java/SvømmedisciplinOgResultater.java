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




    ////////////////////////
    // NOGET DATO HER EVT //
    ////////////////////////



    public String getSvømmedisciplin(){
        return svømmedisciplin;
    }

    public double getResultat(){
        return resultat;
    }

    public void setSvømmedisciplin(String svømmedisciplin){
        this.svømmedisciplin = svømmedisciplin;
    }

    public void setResultat(int resultat){
        this.resultat = resultat;
    }
}
