package Calculator;

import java.util.Scanner;

public class Calculator {


    public static void ConsoleLord() {

        Scanner scan = new Scanner(System.in);


        do {
            System.out.println("Potencjał Agresora: ");
            int attackerPotential = scan.nextInt();


            System.out.println("Wybierz typ ataku: \n 1 - Zwykły cios \n 2 - Szybki cios \n 3 - Silny cios\n 4 - Atak dystansowy");
            int actionType = scan.nextInt();
            if (actionType == 1){               // Zwykły cios
                meleeAttack.attack(attackerPotential, actionType);
            } else if (actionType == 2){        // Szybki cios
                meleeAttack.attack(attackerPotential, actionType);
                meleeAttack.attack(attackerPotential, actionType);
            } else if (actionType == 3){        // Silny cios
                meleeAttack.attack(attackerPotential, actionType);
            } else if (actionType == 4){        // Atak dystansowy
                rangedAttack.attack(attackerPotential);
            }
        } while (true);


    }



    public static void main(String[] args) {
        Calculator.ConsoleLord();
    }

}