package CondimentDecorators;

import BaseClasses.Beverage;

public class Soy extends CondimentDecorator {
   Beverage beverage;
   public Soy(Beverage beverage3) {
     this.beverage = beverage3;
   }


   @Override
   public String getDescription() {
      return beverage.getDescription() + ", Soy";
   }

   @Override
   public double cost() {
      return beverage.cost() + .10;
   }
}
