package Calculator;
import java.util.Scanner;

public class Location {

    public static String rolledlocationName(int attackerRoll) {
        String locationName;

        if (attackerRoll %10 == 1){
            locationName = "Głowa";
        }
        else if (attackerRoll %10 >= 2 && attackerRoll %10 <= 4){
            locationName = "Korpus";
        }
        else if (attackerRoll %10 == 5){
            locationName = "Prawa Ręka / Kończyna";
        }
        else if (attackerRoll %10 == 6){
            locationName = "Lewa Ręka / Kończyna";
        }
        else if (attackerRoll %10 >= 7 && attackerRoll %10 <= 8){
            locationName = "Prawa Noga";
        }
        else if (attackerRoll %10 >= 9){
            locationName = "Lewa Noga";
        } else {
            locationName = "Specjalne";
        }

        return locationName;
    }

    public static String measuredlocationName(){
        Scanner scan = new Scanner(System.in);
        String locationName = "";

        System.out.println
                ("""

                        \tLokacja\t\t\t\t\tMierzony\tObrażenia
                        1 - Głowa\t\t\t\t\t-6\t\t\tx3
                        2 - Korpus\t\t\t\t\t-1\t\t\tx1
                        3 - Prawa Ręka / Kończyna\t-3\t\t\tx1/2
                        4 - Lewa Ręka / Kończyna\t-3\t\t\tx1/2
                        5 - Prawa Noga\t\t\t\t-3\t\t\tx1/2
                        6 - Lewa Noga\t\t\t\t-3\t\t\tx1/2
                        7 - Specjalne\t\t\t\t-2\t\t\tx1/2""");
        int measuredLocation = scan.nextInt();

        if (measuredLocation == 1){
            locationName = "Głowa";
        }
        else if (measuredLocation == 2){
            locationName = "Korpus";
        }
        else if (measuredLocation == 3){
            locationName = "Prawa Ręka / Kończyna";
        }
        else if (measuredLocation == 4){
            locationName = "Lewa Ręka / Kończyna";
        }
        else if (measuredLocation == 5){
            locationName = "Prawa Noga";
        }
        else if (measuredLocation == 6){
            locationName = "Lewa Noga";
        }
        else if (measuredLocation == 7) {
            locationName = "Specjalne";
        }

        return locationName;
    }

    public static float LocMultiplier(String locationName) {
        float locMultiplier;
        if (locationName.equals("Głowa")){
            locMultiplier = 3;
        } else if (locationName.equals("Korpus")) {
            locMultiplier = 1;
        } else {
            locMultiplier = 0.5F;
        }

        return locMultiplier;

    }


    public static int measuringMod(String locationName) {

        return switch (locationName) {
            case "Głowa" -> -6;
            case "Korpus" -> -1;
            case "Specjalne" -> -2;
            default -> -3;
        };
    }
}
