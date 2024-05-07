import java.util.ArrayList;
import java.util.Scanner;

public class UserInterface {
    Controller controller = new Controller();
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
                    System.out.println("Angiv navn på medlem: ");
                    scanner.nextLine();
                    String navn = scanner.nextLine();
                    System.out.println("Angiv alder på medlem: ");
                    int alder = scanner.nextInt();
                    System.out.println("Angiv om medlem har et aktivt eller passivt medlemskab. Tast \"aktiv\" for aktivt medlemskab eller \"passiv\" for passivt medlemskab: ");
                    scanner.nextLine();
                    String inputAktivEllerPassiv = scanner.nextLine();
                    boolean aktivtMedlemskab = false;
                    if (inputAktivEllerPassiv.toLowerCase().contains("aktiv")) {
                        aktivtMedlemskab = true;
                    }
                    boolean juniorMedlemskab = alder < 18;
                    System.out.println("Angiv om medlem er konkurrencesvømmer eller motionistsvømmer. Tast \"konkurrence\" for konkurrencesvømmer eller \"motionist\" for motionistsvømmer: ");
                    String inputKonkurrenceEllerMotionist = scanner.nextLine();
                    boolean konkurrenceSvømmer = false;
                    if (inputKonkurrenceEllerMotionist.toLowerCase().contains("konkurrence")) {
                        konkurrenceSvømmer = true;
                    }

                    Medlem medlem;

                    if (konkurrenceSvømmer) {
                        System.out.println("Angiv medlems træner: ");
                        String træner = scanner.nextLine();
                        String hold = alder < 18 ? "Ungdomshold" : "Seniorhold";
                        ArrayList<SvømmedisciplinOgResultater> svømmedisciplingOgResultater = new ArrayList<>();
                        medlem = new Konkurrencemedlem(navn, alder, aktivtMedlemskab, juniorMedlemskab, træner, hold, svømmedisciplingOgResultater);
                    } else {
                        medlem = new Medlem(navn, alder, aktivtMedlemskab,juniorMedlemskab);
                    }
                    controller.tilføjMedlem(medlem);
                    System.out.println("Medlem er blevet tilføjet");
                    System.out.println();
                    System.out.println(medlem);


                case 2:

            }

        }
    }

    public void dagiMåned() {
        controller.getMåned();
    }
    /*
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
        controller.tilføjMedlem(navn, alder, aktivtMedlemskab, juniorMedlemskab, motionistSvømmer);
        System.out.println("Medlemmet er registreret!");
    }

     */



    //finder et medlem via. Navn
    public ArrayList<Medlem> søgPåMedlem() {
        controller.getInstanceDelfinen().searchMatch.clear();

        Scanner input = new Scanner(System.in);
        System.out.println("Søg på medlem");
        String stringtosearchfor = input.nextLine();
        ArrayList<Medlem> searchResult = controller.findMedlem(stringtosearchfor);
        if (searchResult.size() <= 0) {
            System.out.println("Der blev ikke fundet et medlem med det navn.");
        } else {
            int count = 1;
            for (Medlem medlem : searchResult) {
                System.out.println(count++ + ". " + medlem.toString()); //skal lave en toString
            }
        }
return searchResult;
    }

    //Rediger medlem UI:
    public void redigérMedlemUI() {
        System.out.println("Indtast navnet på det medlem du ønsker at redigere: ");
        String medlemsnavn = scanner.nextLine();

        ArrayList<Medlem> searchResult = controller.findMedlem(medlemsnavn);

        if (searchResult.isEmpty()) {
            System.out.println("Ingen medlemmer fundet");
            return;
        }

        Medlem valgtMedlem = searchResult.get(0);

        System.out.println("Vælg oplysinger at redigere : ");
        System.out.println("1) navn");
        System.out.println("2) alder");
        System.out.println("3) Aktivt/Passivt medlemskab");
        System.out.println("4) Junior/Senior medlemskab");

        int redigeringsvalg = scanner.nextInt();
        System.out.println("Indtast ny værdi: ");
        String nyVærdi = scanner.nextLine();

    }




}