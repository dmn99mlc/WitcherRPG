package Calculator;

import java.util.Scanner;

class rangedAttack {

    public static void attack(int attackerPotential, int actionType){
        Scanner scan = new Scanner(System.in);
        int ATTresult, DEFresult;
        float locMultiplier;
        String locationName;
        int measuringMod = 0;
        int rangeMod;

        System.out.println("""
                Zasięg strzału:
                1 - Bezpośredni
                2 - Bliski\t\t(do 1/4 zasięgu broni)
                3 - Średni\t\t(między 1/4 a 1/2)
                4 - Długi\t\t(między 1/2 a pełnym zasięgiem)
                5 - Ekstremalny\t(między zasięgiem a zasięgiem x2)""");
        int range = scan.nextInt();


        switch(range){
            case 1 -> rangeMod = 5;
            case 2 -> rangeMod = 0;
            case 3 -> rangeMod =-2;
            case 4 -> rangeMod =-4;
            case 5 -> rangeMod =-6;
            default -> rangeMod =0;
        }


        System.out.println("Czy atak jest mierzony?\n1 - Tak\n0 - Nie");
        int measured = scan.nextInt();

        System.out.println("Rzut Agresora: ");
        int attackerRoll = scan.nextInt();

        if (measured == 0){
            locationName = Location.rolledlocationName(attackerRoll);
            locMultiplier = Location.LocMultiplier(locationName);
        } else{
            locationName = Location.measuredlocationName();
            locMultiplier = Location.LocMultiplier(locationName);
            measuringMod = Location.measuringMod(locationName);
        }


        //Rzut Agresora
        if (attackerRoll == 1) {
            System.out.println("Rzuć na pech (1d10)");
            int ATTFumbleThrow = scan.nextInt();
            locMultiplier = 3;
            locationName = "Głowa";
            Fumble.ATTFumble(ATTFumbleThrow);
            ATTresult = attackerPotential + measuringMod + rangeMod - ATTFumbleThrow;
        } else{
            ATTresult = attackerRoll + attackerPotential + measuringMod + rangeMod;
        }

        DEFresult = defense.defense();


        int result = ATTresult - DEFresult;
        if (result > 0) {

            System.out.println("Atak się powiódł - " + locationName);
            DamageTest.damage(result, locMultiplier, actionType, locationName);
        } else {
            System.out.println("Atak nie powiódł się");
        }

    }


}
