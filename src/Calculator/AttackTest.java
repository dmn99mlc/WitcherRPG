package Calculator;

import java.util.Scanner;

class AttackTest {

 public static void AttackTest(int attackerPotential, int DEFPotential, int actionType) {

  int ATTresult, DEFresult;
  float locMultiplier = 0;
  String locationName ;

  Scanner scan = new Scanner(System.in);

  System.out.println("Rzut Agresora: ");
  int attackerRoll = scan.nextInt();

  //Rzut Agresora
  if (attackerRoll == 1) {
   System.out.println("Rzuć na pech (1d10)");
   int ATTFumbleThrow = scan.nextInt();
   locMultiplier = 3;
   locationName = "Głowa";
   Fumble.ATTFumble(ATTFumbleThrow, actionType, locationName);
   ATTresult = attackerPotential - ATTFumbleThrow;
  } else{
   ATTresult = attackerRoll + attackerPotential;
  }

  locationName = Location.locationName(attackerRoll);
  locMultiplier = Location.LocMultiplier(locationName);

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