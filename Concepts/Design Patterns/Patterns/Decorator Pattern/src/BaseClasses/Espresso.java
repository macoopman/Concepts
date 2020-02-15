package BaseClasses;

import BaseClasses.Beverage;

public class Espresso extends Beverage {

   public Espresso() {
      description = "BaseClasses.Espresso";
   }

   @Override
   public double cost() {
      return 1.99;
   }
}
