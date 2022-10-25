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

            System.out.println("Wybierz typ ataku: \n 1 - Zwykły cios \n 2 - Szybki cios \n 3 - Silny cios");
            int actionType = scan.nextInt();
            if (actionType == 1){               // Zwykły cios
                AttackTest.attack(attackerPotential, DEFPotential, actionType);
            } else if (actionType == 2){        // Szybki cios
                AttackTest.attack(attackerPotential, DEFPotential, actionType);
                System.out.println("Potencjał Obrońcy: ");
                DEFPotential = scan.nextInt();  // Silny cios
                AttackTest.attack(attackerPotential, DEFPotential, actionType);
            } else if (actionType == 3){
                AttackTest.attack(attackerPotential - 3,DEFPotential, actionType);
            }
        } while (true);


    }



    public static void main(String[] args) {
        Calculator.ConsoleLord();
    }

}