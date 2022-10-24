package Calculator;

import java.util.Scanner;

class DamageTest {

    public static void damage(int result, double locMultiplier, int actionType, String locationName) {

        Scanner scan = new Scanner(System.in);

        double bonusDMG = CriticalWounds.BonusDMG(result);

//
//        if (result <7)
//            CriticalDamage = 0;
//        else if (result <10)
//            CriticalDamage = 3;
//        else if (result <13)
//            CriticalDamage = 5;
//        else if (result <15)
//            CriticalDamage = 8;
//        else CriticalDamage = 10;



        System.out.println("Rzuć na obrażenia");
        double DamageRoll = scan.nextDouble();

        double StrikePower;
        if (actionType == 3){
            StrikePower = 2;
        } else {
            StrikePower = 1;
        }

        System.out.println("Wyparowania");
        double Evaporation = scan.nextDouble();

        System.out.println("Redukcje: \n 1 - Nie\n 2 - Tak");
        double Reduction = scan.nextDouble();

        double Damage = (((DamageRoll * StrikePower) - Evaporation) / Reduction) * locMultiplier + bonusDMG;

        boolean piercing = DamageRoll*StrikePower >= Evaporation;


        CriticalWounds.CriticalEffect(bonusDMG, locationName,piercing);
        System.out.println("Obrażenia: "+ Math.abs(Damage));




    }
}
