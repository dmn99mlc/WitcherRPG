package Calculator;

import java.util.Scanner;

class AttackTest {

 public static void attack(int attackerPotential, int DEFPotential, int actionType) {

  int ATTresult, DEFresult;
  float locMultiplier;
  String locationName;
  int measuringMod = 0;

  Scanner scan = new Scanner(System.in);

  System.out.println("Czy atak jest mierzony?\n1 - Tak\n0 - Nie");
  int measured = scan.nextInt();

  System.out.println("Rzut Agresora: ");
  int attackerRoll = scan.nextInt();

  System.out.println("Czy mierzony?\n1 - Tak\n0 - Nie");
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
   Fumble.ATTFumble(ATTFumbleThrow, actionType, locationName);
   ATTresult = attackerPotential + measuringMod - ATTFumbleThrow;
  } else{
   ATTresult = attackerRoll + attackerPotential + measuringMod;
  }



  System.out.println("Rzut Obrońcy: ");
  int DEFroll = scan.nextInt();

  //Pech Obrońcy
  if (DEFroll ==1){
   System.out.println("Rzuć na pech (1d10)");
   int DEFFumbleThrow = scan.nextInt();
   Fumble.DEFFumble(DEFFumbleThrow, actionType, locationName);
   DEFresult = DEFPotential - DEFFumbleThrow;
  }

  else
   DEFresult = DEFPotential + DEFroll;

  int result = ATTresult - DEFresult;
  if (result > 0) {

   System.out.println("Atak się powiódł - " + locationName);
   DamageTest.damage(result, locMultiplier, actionType, locationName);
  } else {
   System.out.println("Atak nie powiódł się");
  }
}

}