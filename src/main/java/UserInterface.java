import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class UserInterface {
    Controller kontrol = new Controller();
    Scanner scanner = new Scanner(System.in);

    public void startProgram() {
        while (true) {
            System.out.println("""
                             1) Søg medlem
                             2) Rediger medlemsliste
                             3) Gem medlemsliste
                             4) Se 
                             
                             
                    """);

            int input = scanner.nextInt();

            switch (input) {
                case 1:

            }

        }
    }

    public void dagiMåned() {
        kontrol.getMåned();
    }

    //finder et medlem via. Navn
    public ArrayList<Medlemmer> søgPåMedlem() {
        kontrol.getInstanceDelfinen().searchMatch.clear();

        Scanner input = new Scanner(System.in);
        System.out.println("Søg på medlem");
        String stringtosearchfor = input.nextLine();
        ArrayList<Medlemmer> searchResult = kontrol.findMedlem(stringtosearchfor);
        if (searchResult.size() <= 0) {
            System.out.println("Der blev ikke fundet et medlem med det navn.");
        } else {
            int count = 1;
            for (Medlemmer medlem : searchResult) {
                System.out.println(count++ + ". " + medlem.toString()); //skal lave en toString
            }
        }
return searchResult;
    }
}