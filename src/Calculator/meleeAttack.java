package Calculator;

import java.util.Scanner;

class meleeAttack {

 public static void attack(int attackerPotential, int actionType) {

  int ATTresult, DEFresult;
  float locMultiplier;
  String locationName;
  int measuringMod = 0;

  Scanner scan = new Scanner(System.in);




  if (actionType == 3){
   attackerPotential = attackerPotential - 3;
  }

  System.out.println("Czy atak jest mierzony?\n1 - Tak\n0 - Nie");
  int measured = scan.nextInt();

  System.out.println("Rzut Agresora: ");
  int attackerRoll = scan.nextInt();

  if (measured == 0){
   locationName = Location.rolledlocationName(attackerRoll);
   locMultiplier = Location.LocMultiplier(locationName);
  } else {
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
   ATTresult = attackerPotential + measuringMod - ATTFumbleThrow;
  } else{
   ATTresult = attackerRoll + attackerPotential + measuringMod;
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