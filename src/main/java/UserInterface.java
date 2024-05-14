import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import java.util.List;
import java.util.Scanner;

public class UserInterface {
    Controller controller = new Controller();
    Scanner scanner = new Scanner(System.in);
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    public void startProgram() {
        while (true) {
            System.out.println("""
                             1) Tilføj medlem
                             2) Søg på medlem
                             3) Rediger medlem
                             4) Vis Kontingent
                             5) Medlemmer i restance
                             6) Medlemsoversigt
                             7) Indbetal
                
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
                            System.out.println("Angiv om medlem er konkurrence- eller motionistsvømmer. Tast \"konkurrence\" for konkurrencesvømmer eller \"motionist\" for motionistsvømmer: ");
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
                case 5:
                    restance();
                    break;

            }

        }
    }

    public void restance(){
        List<Medlem> medLemmer = controller.medlemmerMedNegativSaldo();
        if(medLemmer.isEmpty()){
            System.out.println("Ingen medlemmer er i restance");
        } else{
            System.out.println("Medlemmer i restance : ");
            for (Medlem medlem : medLemmer){
                System.out.println(medlem.getNavn() + " Saldo: " + medlem.getSaldo());
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
            String træner = alder < 18 ? "Peter Jacobsen" : "Maria Clausen";
            String hold = alder < 18 ? "Ungdomshold" : "Seniorhold";
            ArrayList<SvømmedisciplinOgResultater> svømmedisciplingOgResultater = new ArrayList<>();
            System.out.println("Angiv medlems svømmedisciplin (butterfly, crawl, rygcrawl, eller brystsvømning): ");
            String svømmedisciplin = scanner.nextLine();
            svømmedisciplin = scanner.nextLine();
            if (svømmedisciplin.toLowerCase().contains("butterfly") || svømmedisciplin.toLowerCase().contains("crawl") || svømmedisciplin.toLowerCase().contains("rygcrawl") || svømmedisciplin.toLowerCase().contains("brystsvømning")) {
                System.out.println("1) Angiv resultat og dato for resultat.");
                System.out.println("2) Afslut og opret medlem.");
                int resultatValg = scanner.nextInt();
                switch (resultatValg) {
                    case 1:
                        System.out.println("Angiv resultat i sekunder: ");
                        double resultat = scanner.nextDouble();
                        System.out.println("Angiv dato for resultat: ");
                        System.out.println("År: ");
                        int år = scanner.nextInt();
                        System.out.println("Måned: ");
                        int måned = scanner.nextInt();
                        System.out.println("Dag: ");
                        int dag = scanner.nextInt();
                        SvømmedisciplinOgResultater resultater = new SvømmedisciplinOgResultater(svømmedisciplin, resultat, år, måned, dag);
                        svømmedisciplingOgResultater.add(resultater);
                    case 2:
                        break;
                }
            } else {
                System.out.println("Svømmedisciplin eksisterer ikke. Tjek eventuelle tastefejl.");
            }
            medlem = new Konkurrencemedlem(navn, alder, aktivtMedlemskab, juniorMedlemskab, saldo, træner, hold, svømmedisciplingOgResultater);
        } else {
            medlem = new Medlem(navn, alder, aktivtMedlemskab, juniorMedlemskab, saldo);
        }
        controller.tilføjMedlem(medlem);
        System.out.println("Medlem er blevet tilføjet");
        System.out.println();
        System.out.println(medlem);

    }
}