public class Controller {

    Delfinen instanceDelfinen = new Delfinen();


    public void tilføjMedlem(String navn, int alder, boolean aktivtMedlemskab, boolean juniorMedlemskab, boolean motionistSvømmer){
        instanceDelfinen.tilføjMedlem(navn, alder, aktivtMedlemskab, juniorMedlemskab, motionistSvømmer);
    }

    public Delfinen getInstanceDelfinen(){
        return instanceDelfinen;
    }
}
