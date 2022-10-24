package Calculator;

public class Location {

    public static String locationName(int attackerRoll) {
        String locationName = "";

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
        else if (attackerRoll %10 >= 9 && attackerRoll %10 <= 10){
            locationName = "Lewa Noga";
        }

        return locationName;
    }

    public static float LocMultiplier(String locationName) {
        float locMultiplier;
        if (locationName == "Głowa"){
            locMultiplier = 3;
        } else if (locationName == "Korpus") {
            locMultiplier = 1;
        } else {
            locMultiplier = 0.5F;
        }

        return locMultiplier;

    }

}
