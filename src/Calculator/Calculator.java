package Calculator;

import java.util.Scanner;

public class Calculator {


    public static void ConsoleLord() {

        Scanner scan = new Scanner(System.in);


        do {
            System.out.println("Potencjał Agresora: ");
            int attackerPotential = scan.nextInt();
            System.out.println("Potencjał Obrońcy: ");
            int DEFPotential = scan.nextInt();

            System.out.println("Wybierz typ ataku: \n 1 - Zwykły atak \n 2 - Szybkie ataki \n 3 - Silny atak");
            int actionType = scan.nextInt();
            if (actionType == 1){
                AttackTest.AttackTest(attackerPotential, DEFPotential, actionType);
            } else if (actionType == 2){
                AttackTest.AttackTest(attackerPotential, DEFPotential, actionType);
                AttackTest.AttackTest(attackerPotential, DEFPotential, actionType);
            } else if (actionType == 3){
                AttackTest.AttackTest(attackerPotential - 3,DEFPotential, actionType);
            }
        } while (0 < 1);


    }



    public static void main(String[] args) {
        Calculator.ConsoleLord();
    }

}