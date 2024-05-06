import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class UserInterface {
    Controller kontrol = new Controller();
    Scanner scanner = new Scanner(System.in);

    public void startProgram() {
        while (true) {
            System.out.println("""
                             1) Tilføj medlem
                             2) Søg medlem
                             2) Rediger medlemsliste
                             3) Gem medlemsliste
                             4) Se 
                             
                             
                    """);

            int input = scanner.nextInt();

            switch (input) {
                case 1:
                    tilføjMedlem();
                case 2:

            }

        }
    }

    public void dagiMåned() {
        kontrol.getMåned();
    }
    public void tilføjMedlem(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Indsæt medlemmets navn");
        String navn = scanner.nextLine();
        System.out.println("Tilføj medlemmets Alder");
        int alder = scanner.nextInt();
        System.out.println("Er medlemmet aktiv eller passiv medlem");
        boolean aktivtMedlemskab = false;
        if (scanner.next().equalsIgnoreCase("ja")) {
            aktivtMedlemskab = true;
        }
        System.out.println("Er medlemmet senior eller junior medlem");
        boolean juniorMedlemskab = false;
        if (scanner.next().equalsIgnoreCase("ja")) {
            juniorMedlemskab = true;
        }
        System.out.println("Er medlemmet motionist eller konkurrencesvømmer?");
        boolean motionistSvømmer = false;
        if (scanner.next().equalsIgnoreCase("ja")) {
            motionistSvømmer = true;
        }
        kontrol.tilføjMedlem(navn, alder, aktivtMedlemskab, juniorMedlemskab, motionistSvømmer);
        System.out.println("Medlemmet er registreret!");
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