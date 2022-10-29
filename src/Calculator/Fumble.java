package Calculator;

import java.util.Scanner;

public class Fumble {

    //Pech Atakującego
    public static void ATTFumble(int ATTFumbleThrow) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Pech!\n Wskaż typ ataku: \n 1 - Atak wręcz \n 2 - Atak dystansowy");
        int attackType = scan.nextInt();

        //Atak wręcz
        int actionType;
        String locationName;
        if (attackType == 1) {

            if (ATTFumbleThrow <= 5)
                System.out.println("Bez konsekwencji.");
            else if (ATTFumbleThrow == 6)
                System.out.println("Broń odbija się, a postać jest oszołomiona.");
            else if (ATTFumbleThrow == 7)
                System.out.println("Broń utkwiła w jakimś obiekcie i potrzeba 1 Akcji, by ją wydobyć.");
            else if (ATTFumbleThrow == 8) {
                System.out.println("Rzuć 1d10");
                int LossDurability = scan.nextInt();
                System.out.println("Broń zostaje poważnie uszkodzona. Traci " + LossDurability + " Trwałości.");
            }
            else if (ATTFumbleThrow == 9) {
                System.out.println("Postać trafia samą siebie. Rzuć na lokację.");
                int attackerroll = scan.nextInt();
                locationName = Location.rolledlocationName(attackerroll);
                double locMultiplier = Location.LocMultiplier(locationName);
                actionType = 1;
                DamageTest.damage(0,locMultiplier, actionType, locationName);
            }
            else {
                System.out.println("Postać trafia losowego sojusznika, jeżeli taki jest w zasięgu. Rzuć na lokalizację.");
                int attackerroll = scan.nextInt();
                locationName = Location.rolledlocationName(attackerroll);
                double locMultiplier = Location.LocMultiplier(locationName);
                actionType = 1;
                DamageTest.damage(0,locMultiplier, actionType, locationName);
            }

        }

        //Atak dystansowy
        if (attackType == 2) {

            if (ATTFumbleThrow <= 5)
                System.out.println("Bez konsekwencji.");
            else if (ATTFumbleThrow == 6 || ATTFumbleThrow == 7)
                System.out.println("Strzała, bełt czy broń rzucana trafia w coś twardego i pęka.");
            else if (ATTFumbleThrow == 8 || ATTFumbleThrow == 9) {
                System.out.println("Pęka cięciwa, zacina się kusza, broń rzucana wypada na ziemię. Potrzeba 1 Akcji, by to naprawić.");
            }
            else {
                System.out.println("Pocisk rykoszetuje i trafia losowego sojusznika w zasięgu. Rzuć na lokację.");
                int attackerroll = scan.nextInt();
                locationName = Location.rolledlocationName(attackerroll);
                double locMultiplier = Location.LocMultiplier(locationName);
                actionType = 1;
                DamageTest.damage(0,locMultiplier, actionType, locationName);
            }

        }
    }

    //Pech Obrońcy
    public static void DEFFumble(int DEFFumbleThrow) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Pech!\n Wskaż typ obrony: \n 1 - Obrona bronią \n 2 - Obrona ruchem");
        int defensetype = scan.nextInt();

        //Obrona bronią
        if (defensetype == 1){
            if (DEFFumbleThrow <= 5)
                System.out.println("Bez konsekwencji");
            else if (DEFFumbleThrow == 6){
                System.out.println("Rzuć kością (1d6)");
                int dice = scan.nextInt();
                System.out.println("Broń traci dodatkowe " + dice +" Trwałości.");
            }
            else if (DEFFumbleThrow == 7){
                System.out.println("Rzuć kością (1d6)");
                int dice = scan.nextInt();
                System.out.println("Postać zostaje rozbrojona. Broń ląduje " + dice + "metrów od niej w losowym kierunku");
            }
            else if (DEFFumbleThrow == 8)
                System.out.println("Postać potyka się i pada przewrócona. Musi natychmiast wykonać test Przytomności.");
            else if (DEFFumbleThrow == 9){
                System.out.println("Rzuć kością (2d6)");
                int dice = scan.nextInt();
                System.out.println("Broń traci dodatkowe 2k6 Trwałości");
            }
            else {
                System.out.println("Postać dostaje własnym żelazem, gdy cios przeciwnika odbija broń. Rzuć na lokację");
                int attackerroll = scan.nextInt();
                String locationName = Location.rolledlocationName(attackerroll);
                double locMultiplier = Location.LocMultiplier(locationName);
                int actionType = 1;
                DamageTest.damage(0,locMultiplier, actionType, locationName);
            }



        }

        //Obrona ruchem
        if (defensetype == 2){
            if (DEFFumbleThrow <= 5)
                System.out.println("Bez konsekwencji");
            else if (DEFFumbleThrow == 6)
                System.out.println("Atakujący ociera się o postać, która jest od tego oszołomiona");
            else if (DEFFumbleThrow == 7)
                System.out.println("Postać potyka się. Jest przewrócona");
            else if (DEFFumbleThrow == 8) {
                System.out.println("Rzuć kością (1d6)");
                int dice = scan.nextInt();
                System.out.println("Postać potyka się. Jest przewrócona, a broń wypada jej z ręki, odlatując na " + dice + " metrów w losowym kierunku.");
            }
            else if (DEFFumbleThrow == 9){
                System.out.println("Rzuć kością (1d6)");
                int dice = scan.nextInt();
                System.out.println("Postać potyka się i uderza w głowę. Jest przewrócona i dostaje " + dice +" stłuczeń. Musi też wykonać test Przytomności.");
            }
            else {
                System.out.println("Rzuć kością (1d6)");
                int dice = scan.nextInt();
                System.out.println("Postać wpadła na coś twardego. Jest przewrócona, traci dodatkowe " + dice +" PZ i musi wykonać test Przytomności.");
            }



        }


    }
}