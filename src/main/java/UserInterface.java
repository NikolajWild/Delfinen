import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class UserInterface {
    Controller kontrol = new Controller();
    Scanner scanner = new Scanner(System.in);

    public void startProgram(){
        while(true){
            System.out.println("""
                    1) Søg medlem
                    2) Rediger medlemsliste
                    3) Gem medlemsliste
                    4) Se 
                    
                    
           """ );

        }
    }


    public ArrayList<Medlemmer> søgPåMedlem(){
        kontrol().searchMatch.clear();

    }


}
