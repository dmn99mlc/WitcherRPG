package Calculator;

import java.util.Scanner;

public class defense {

    public static int defense() {

        int DEFresult;

        Scanner scan = new Scanner(System.in);

        System.out.println("Potencjał Obrońcy: ");
        int DEFPotential = scan.nextInt();


        System.out.println("Rzut Obrońcy: ");
        int DEFroll = scan.nextInt();

        //Pech Obrońcy
        if (DEFroll == 1) {
            System.out.println("Rzuć na pech (1d10)");
            int DEFFumbleThrow = scan.nextInt();
            Fumble.DEFFumble(DEFFumbleThrow);
            DEFresult = DEFPotential - DEFFumbleThrow;
        } else
            DEFresult = DEFPotential + DEFroll;

        return DEFresult;

    }



}