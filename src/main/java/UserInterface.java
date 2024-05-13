import java.util.ArrayList;
import java.util.Scanner;

public class UserInterface {
    Controller controller = new Controller();
    Scanner scanner = new Scanner(System.in);

    public void startProgram() {
        while (true) {
            System.out.println("""
                             1) Tilføj medlem
                             2) Søg på medlem
                             3) Rediger medlem
                             4) Vis Kontingent
                             5) Gem medlemsliste
                             6) Medlemsoversigt
                             
                             
                    """);

            int input = scanner.nextInt();

            switch (input) {
                case 1:
                    tilføjMedlem();
                    break;
                case 2:
                    søgPåMedlem();
                    break;

                case 3:
                    System.out.println("Søg efter navn på medlem nu ønsker at redigere: ");
                    scanner.nextLine();
                    String navnRediger = scanner.nextLine();
                    controller.søgMedlem(navnRediger);
                    Medlem medlemRed = controller.instanceDelfinenMedlemmer.searchMatch.get(0);
                    System.out.println(medlemRed);
                    System.out.println();
                    System.out.println("Hvad ønsker du at redigere?");
                    System.out.println("1) Redigér navn");
                    System.out.println("2) Redigér alder");
                    System.out.println("3) Redigér aktivt/passivt medlemskab");
                    System.out.println("4) Redigér motionist-/konkurrencessvømmer");
                    int redigeringsValg = scanner.nextInt();
                    switch (redigeringsValg) {
                        case 1:
                            System.out.println("Angiv nyt navn: ");
                            scanner.nextLine();
                            String nytNavn = scanner.nextLine();
                            controller.redigérMedlem(navnRediger, redigeringsValg, nytNavn);
                            break;
                        case 2:
                            System.out.println("Angiv ny alder: ");
                            scanner.nextLine();
                            String nyAlder = scanner.nextLine();
                            controller.redigérMedlem(navnRediger, redigeringsValg, nyAlder);
                            break;
                        case 3:
                            System.out.println("Angiv om medlem har aktivt eller passivt medlemskab: Tast \"aktiv\" for aktivt medlemskab eller \"passiv\" for passivt medlemskab: ");
                            scanner.nextLine();
                            String nyAktivEllerPassiv = scanner.nextLine();
                            if (nyAktivEllerPassiv.toLowerCase().contains("aktiv")) {
                                nyAktivEllerPassiv = "true";
                            }
                            controller.redigérMedlem(navnRediger, redigeringsValg, nyAktivEllerPassiv);
                            break;
                        case 4:
                            System.out.println("Redigér om medlem er konkurrence- eller motionistsvømmer. Tast \"konkurrence\" for konkurrencesvømmer eller \"motionist\" for motionistsvømmer: ");
                            scanner.nextLine();
                            String nyMotionistKonkurrence = scanner.nextLine();
                            if (nyMotionistKonkurrence.toLowerCase().contains("konkurrence")) {
                                nyMotionistKonkurrence = "true";
                                System.out.println("Angiv medlems træner: ");
                                String træner = scanner.nextLine();
                                String hold = medlemRed.getAlder() < 18 ? "Ungdomshold" : "Seniorhold";
                                ArrayList<SvømmedisciplinOgResultater> svømmedisciplingOgResultater = new ArrayList<>();
                                medlemRed = new Konkurrencemedlem(medlemRed.getNavn(), medlemRed.getAlder(), medlemRed.getAktivtMedlemskab(), medlemRed.getJuniorMedlemskab(), medlemRed.getSaldo(), træner, hold, svømmedisciplingOgResultater);
                            }

                            controller.redigérMedlem(navnRediger, redigeringsValg, nyMotionistKonkurrence);
                            System.out.println("Medlemsoplysninger er blevet opdateret");
                            System.out.println();
                            System.out.println(medlemRed);
                            break;
                    }
                    break;
                case 4:
                    visKontingent();
                    break;
            }

        }
    }

    public void visKontingent() {
        double kontingent = controller.beregningAfKontingent();
        System.out.println("Dette er den indkomst, som svømmeklubben burde tjene i år, kunder" +
                " i restance er ikke regnet med i dette beløb" + kontingent);
    }

    public void dagiMåned() {
        controller.getMåned();
    }

    public void søgPåMedlem() {
        System.out.println("Søg efter navn: ");
        scanner.nextLine();
        String navnSøg = scanner.nextLine();
        controller.søgMedlem(navnSøg);
        System.out.println(controller.instanceDelfinenMedlemmer.searchMatch.get(0));
    }

    public void tilføjMedlem() {
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
        System.out.println("Indbetal penge til din konto");
        double saldo = scanner.nextDouble();
        Medlem medlem;

        if (konkurrenceSvømmer) {
            System.out.println("Angiv medlems træner: ");
            String træner = scanner.nextLine();
            String hold = alder < 18 ? "Ungdomshold" : "Seniorhold";
            ArrayList<SvømmedisciplinOgResultater> svømmedisciplingOgResultater = new ArrayList<>();
            medlem = new Konkurrencemedlem(navn, alder, aktivtMedlemskab, juniorMedlemskab, saldo, træner, hold, svømmedisciplingOgResultater);
        } else {
            medlem = new Medlem(navn, alder, aktivtMedlemskab, juniorMedlemskab, saldo);
        }
        controller.tilføjMedlem(medlem);
        System.out.println("Medlem er blevet tilføjet");
        System.out.println();
        System.out.println(medlem);

    }

  /*  public void redigerMedlem(){
        System.out.println("Søg efter navn på medlem nu ønsker at redigere: ");
        scanner.nextLine();
        String navnRediger = scanner.nextLine();
        controller.søgMedlem(navnRediger);
        Medlem medlemRed = controller.instanceDelfinenMedlemmer.searchMatch.get(0);
        System.out.println(medlemRed);
        System.out.println();
        System.out.println("Hvad ønsker du at redigere?");
        System.out.println("1) Redigér navn");
        System.out.println("2) Redigér alder");
        System.out.println("3) Redigér aktivt/passivt medlemskab");
        System.out.println("4) Redigér motionist-/konkurrencessvømmer");
        int redigeringsValg = scanner.nextInt();
        switch (redigeringsValg) {
            case 1:
                System.out.println("Angiv nyt navn: ");
                scanner.nextLine();
                String nytNavn = scanner.nextLine();
                controller.redigérMedlem(navnRediger, redigeringsValg, nytNavn);
                break;
            case 2:
                System.out.println("Angiv ny alder: ");
                scanner.nextLine();
                String nyAlder = scanner.nextLine();
                controller.redigérMedlem(navnRediger, redigeringsValg, nyAlder);
                break;
            case 3:
                System.out.println("Angiv om medlem har aktivt eller passivt medlemskab: Tast \"aktiv\" for aktivt medlemskab eller \"passiv\" for passivt medlemskab: ");
                scanner.nextLine();
                String nyAktivEllerPassiv = scanner.nextLine();
                if (nyAktivEllerPassiv.toLowerCase().contains("aktiv")) {
                    nyAktivEllerPassiv = "true";
                }
                controller.redigérMedlem(navnRediger, redigeringsValg, nyAktivEllerPassiv);
                break;
            case 4:
                System.out.println("Redigér om medlem er konkurrence- eller motionistsvømmer. Tast \"konkurrence\" for konkurrencesvømmer eller \"motionist\" for motionistsvømmer: ");
                scanner.nextLine();
                String nyMotionistKonkurrence = scanner.nextLine();
                if (nyMotionistKonkurrence.toLowerCase().contains("konkurrence")) {
                    nyMotionistKonkurrence = "true";
                    System.out.println("Angiv medlems træner: ");
                    String træner = scanner.nextLine();
                    String hold = medlemRed.getAlder() < 18 ? "Ungdomshold" : "Seniorhold";
                    ArrayList<SvømmedisciplinOgResultater> svømmedisciplingOgResultater = new ArrayList<>();
                    medlemRed = new Konkurrencemedlem(medlemRed.getNavn(), medlemRed.getAlder(), medlemRed.getAktivtMedlemskab(), medlemRed.getJuniorMedlemskab(), træner, hold, svømmedisciplingOgResultater);
                }

                controller.redigérMedlem(navnRediger, redigeringsValg, nyMotionistKonkurrence);
                System.out.println("Medlemsoplysninger er blevet opdateret");
                System.out.println();
                System.out.println(medlemRed);
                break;
    }*/


    //finder et medlem via. Navn
    /*
    public ArrayList<Medlem> søgPåMedlem() {
        controller.getInstanceDelfinen().searchMatch.clear();

        Scanner input = new Scanner(System.in);
        System.out.println("Søg på medlem");
        String stringtosearchfor = input.nextLine();
        ArrayList<Medlem> searchResult = controller.søgMedlem(stringtosearchfor);
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

     */

    /*
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

     */


}